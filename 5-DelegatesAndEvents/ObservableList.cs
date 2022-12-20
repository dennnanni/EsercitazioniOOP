namespace DelegatesAndEvents
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq;
    using System.Runtime.CompilerServices;

    /// <inheritdoc cref="IObservableList{T}" />
    public class ObservableList<TItem> : IObservableList<TItem>
    {
        private IList<TItem> _items = new List<TItem>();

        /// <inheritdoc cref="IObservableList{T}.ElementInserted" />
        public event ListChangeCallback<TItem> ElementInserted;

        /// <inheritdoc cref="IObservableList{T}.ElementRemoved" />
        public event ListChangeCallback<TItem> ElementRemoved;

        /// <inheritdoc cref="IObservableList{T}.ElementChanged" />
        public event ListElementChangeCallback<TItem> ElementChanged;

        /// <inheritdoc cref="ICollection{T}.Count" />
        public int Count
        {
            get => _items.Count;
        }

        /// <inheritdoc cref="ICollection{T}.IsReadOnly" />
        public bool IsReadOnly
        {
            get => _items.IsReadOnly;
        }

        /// <inheritdoc cref="IList{T}.this" />
        public TItem this[int index]
        {
            get => _items[index];

            set
            {
                if (index >= 0 || index < _items.Count)
                {
                    TItem old = _items[index];
                    _items[index] = value;
                    ElementChanged?.Invoke(this, value, old, index);
                }
            }
        }

        /// <inheritdoc cref="IEnumerable{T}.GetEnumerator" />
        public IEnumerator<TItem> GetEnumerator() => _items.GetEnumerator();

        /// <inheritdoc cref="IEnumerable.GetEnumerator" />
        IEnumerator IEnumerable.GetEnumerator() => ((IEnumerable)_items).GetEnumerator();

        /// <inheritdoc cref="ICollection{T}.Add" />
        public void Add(TItem item)
        {
            _items.Add(item);
            ElementInserted?.Invoke(this, item, IndexOf(item));
        }

        /// <inheritdoc cref="ICollection{T}.Clear" />
        public void Clear()
        {
            _items = new ObservableList<TItem>();
        }

        /// <inheritdoc cref="ICollection{T}.Contains" />
        public bool Contains(TItem item) => _items.Contains(item);

        /// <inheritdoc cref="ICollection{T}.CopyTo" />
        public void CopyTo(TItem[] array, int arrayIndex)
        {
            int count = 0;
            while (arrayIndex <  array.Length && count < _items.Count)
            {
                array[arrayIndex] = _items[count];
                count++;
                arrayIndex++;
            }
        }

        /// <inheritdoc cref="ICollection{T}.Remove" />
        public bool Remove(TItem item)
        {
            int index = IndexOf(item);
            bool result = _items.Remove(item);
            ElementRemoved?.Invoke(this, item, index);
            return result;
        }

        /// <inheritdoc cref="IList{T}.IndexOf" />
        public int IndexOf(TItem item) => _items.IndexOf(item);

        /// <inheritdoc cref="IList{T}.RemoveAt" />
        public void Insert(int index, TItem item)
        {
            _items.Insert(index, item);
            ElementInserted?.Invoke(this, item, IndexOf(item));
        }

        /// <inheritdoc cref="IList{T}.RemoveAt" />
        public void RemoveAt(int index)
        {
            TItem value = _items[index];
            _items.RemoveAt(index);
            ElementRemoved?.Invoke(this, value, index);
        }

        /// <inheritdoc cref="object.Equals(object?)" />
        public override bool Equals(object obj)
        {
            return obj is ObservableList<TItem> && _items.SequenceEqual((ObservableList<TItem>)obj);
        }

        /// <inheritdoc cref="object.GetHashCode" />
        public override int GetHashCode()
        {
            return HashCode.Combine(_items);
        }

        /// <inheritdoc cref="object.ToString" />
        public override string ToString()
        {
            // TODO improve
            return base.ToString();
        }
    }
}
