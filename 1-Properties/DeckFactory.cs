namespace Properties
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    /// <summary>
    /// A factory class for building <see cref="ISet{T}">decks</see> of <see cref="Card"/>s.
    /// </summary>
    public class DeckFactory
    {
        public string[] Seeds { get; set; } = null;
        public string[] Names { get; set; } = null;

        public int DeckSize
        {
            get
            {
                return Seeds.Length * Names.Length;
            }
        }

        public ISet<Card> Deck
        {
            get
            {
                if (Names == null || Seeds == null)
                {
                    throw new InvalidOperationException();
                }

                return new HashSet<Card>(Enumerable
                    .Range(0, Names.Length)
                    .SelectMany(i => Enumerable
                        .Repeat(i, Seeds.Length)
                        .Zip(
                            Enumerable.Range(0, Seeds.Length),
                            (n, s) => Tuple.Create(Names[n], Seeds[s], n)))
                    .Select(tuple => new Card(tuple))
                    .ToList());
            }
        }
    }
}
