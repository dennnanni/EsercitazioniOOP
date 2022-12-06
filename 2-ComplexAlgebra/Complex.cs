using System;
using System.Text;

namespace ComplexAlgebra
{
    /// <summary>
    /// A type for representing Complex numbers.
    /// </summary>
    ///
    /// TODO: Model Complex numbers in an object-oriented way and implement this class.
    /// TODO: In other words, you must provide a means for:
    /// TODO: * instantiating complex numbers
    /// TODO: * accessing a complex number's real, and imaginary parts
    /// TODO: * accessing a complex number's modulus, and phase
    /// TODO: * complementing a complex number
    /// TODO: * summing up or subtracting two complex numbers
    /// TODO: * representing a complex number as a string or the form Re +/- iIm
    /// TODO:     - e.g. via the ToString() method
    /// TODO: * checking whether two complex numbers are equal or not
    /// TODO:     - e.g. via the Equals(object) method
    public class Complex
    {
        // TODO: fill this class\

        public Complex(double real, double imaginary)
        {
            Real = real;
            Imaginary = imaginary;
        }

        public Complex() : this(0, 0) { }

        public double Real { get; set; } = 0;
        public double Imaginary { get; set; } = 0;
        public double Modulus
        {
            get => Math.Sqrt(Math.Pow(Real, 2) + Math.Pow(Imaginary, 2));
        }
        public double Phase
        {
            get
            {
                if (Imaginary == 0) return 0;

                return Math.Atan(Imaginary / Real);
            }
        }
        public Complex Complement() => new Complex(Real, -Imaginary);

        public Complex Plus(Complex c)
        {
            return this + c;
        }

        public Complex Minus(Complex c)
        {
            return this - c;
        }

        public override string ToString()
        {
            StringBuilder complex = new StringBuilder();
            complex.Append(Real != 0 ? Real : "");
            complex.
        }

        public override bool Equals(object obj)
        {
            return obj is Complex complex &&
                   Real == complex.Real &&
                   Imaginary == complex.Imaginary;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Real, Imaginary);
        }

        static public Complex operator +(Complex c1, Complex c2)
        {
            return new Complex(c1.Real + c2.Real, c1.Imaginary + c2.Imaginary);
        }

        static public Complex operator -(Complex c1, Complex c2)
        {
            return new Complex(c1.Real - c2.Real, c1.Imaginary - c2.Imaginary);
        }
    }
}