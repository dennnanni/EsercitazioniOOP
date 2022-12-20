namespace ExtensionMethods
{
    using System;
    using System.Text;

    /// <inheritdoc cref="IComplex"/>
    public class Complex : IComplex
    {
        private readonly double re;
        private readonly double im;

        /// <summary>
        /// Initializes a new instance of the <see cref="Complex"/> class.
        /// </summary>
        /// <param name="re">the real part.</param>
        /// <param name="im">the imaginary part.</param>
        public Complex(double re, double im)
        {
            this.re = re;
            this.im = im;
        }

        /// <inheritdoc cref="IComplex.Real"/>
        public double Real
        {
            get => re;
        }

        /// <inheritdoc cref="IComplex.Imaginary"/>
        public double Imaginary
        {
            get => im;
        }

        /// <inheritdoc cref="IComplex.Modulus"/>
        public double Modulus
        {
            get => Math.Sqrt(re * re + im * im);
        }

        /// <inheritdoc cref="IComplex.Phase"/>
        public double Phase
        {
            get
            {
                if (re == 0) throw new DivideByZeroException();
                return Math.Atan(-im / re);
            }
        }

        /// <inheritdoc cref="IComplex.ToString"/>
        public override string ToString()
        {
            StringBuilder complex = new StringBuilder();
            if (re == 0 && im == 0)
                return "0";

            if (re != 0)
            {
                complex.Append(re.ToString());
                if (Math.Abs(im) == 1) complex.Append(im > 0 ? "+i" : "-i");
                else complex.Append((im > 0 ? "+" : "") + im + "i");
            }
            else
            {
                if (Math.Abs(im) == 1) complex.Append(im > 0 ? "i" : "-i");
                else complex.Append($"{im}i");
            }
            return complex.ToString();

        }

        /// <inheritdoc cref="IEquatable{T}.Equals(T)"/>
        public bool Equals(IComplex other) => re == other.Real && im == other.Imaginary;

        /// <inheritdoc cref="object.Equals(object?)"/>
        public override bool Equals(object obj) => obj is Complex && Equals((Complex)obj);

        /// <inheritdoc cref="object.GetHashCode"/>
        public override int GetHashCode() => HashCode.Combine(Real, Imaginary);
    }
}
