package methods.hermite.main;

import java.text.NumberFormat;

/**
 * Klasa reprezentująca wielomian
 *
 */
public class Polynomial{
	public static final double EPSILON = 1e-10;

	private final double[] a;

	/**
	 * Tworzy nowy wielomian z danych, kolejnych wspóczynników
	 * @param coefficients - kolejne (zaczynając od wyrazu wolnego) wspóczynniki
	 */
	public Polynomial(double... coefficients) {
		int l = 1;
		for (int i = coefficients.length - 1; i > 0; i--)
			if (coefficients[i] != 0) {
				l = i + 1;
				break;
			}

		a = new double[l];
		for (int i = 0; i < l; i++)
			a[i] = coefficients[i];
	}

	/**
	 * 
	 * @return Stopień wielomianu
	 */
	public int getDegree() {
		return a.length - 1;
	}

	/**
	 * 
	 * @param d - indeks współczynnika
	 * @return Współczynnik o indeksie d
	 */
	public double getCoefficient(int d) {
		return a[d];
	}

	/**
	 * 
	 * @return Tablicę (kopię) zawierającą współczynniki
	 */
	public double[] getCoefficients() {
		return a.clone();
	}

	public double evaluate(double x) {
		double value = a[0];

		for (int i = 1; i < a.length; i++) {
			value += a[i] * x;
			x *= x;
		}

		return value;
	}

	@Override
	public String toString() {
		return toString(EPSILON);
	}

	/**
	 * Zwraca łańcuch znaków reprezentujący wielomian, ale ignoruje
	 * współczynniki których wartość bezwzględna jest mniejsza od epsilonu.
	 * @param epsilon - dowolna (w domyśle - mała) wartość
	 * @return Reprezentację wielomianu w postaci łańcucha znaków
	 */
	public String toString(double epsilon) {
		StringBuilder b = new StringBuilder();
		NumberFormat nf = NumberFormat.getInstance();
		if (a[a.length - 1] < 0)
			b.append("-");
		double c = Math.abs(a[a.length - 1]);
		if (a.length == 1 || c != 1)
			b.append(nf.format(c));
		if (a.length - 1 > 0)
			b.append("x");
		if (a.length - 1 > 1)
			b.append("^" + (a.length - 1));
		for (int i = a.length - 2; i >= 0; i--) {
			c = Math.abs(a[i]);
			if (c > epsilon) {
				if (a[i] < 0)
					b.append(" - ");
				else
					b.append(" + ");

				if (i == 0 || c != 1)
					b.append(nf.format(c));
				if (i > 0)
					b.append("x");
				if (i > 1)
					b.append("^" + i);
			}
		}

		return b.toString();
	}
	
	public static Polynomial NewtonFormToPolynomial(double[] a, double[] x) {
		int n = a.length - 1;
		double[] w = new double[n + 1];

		for (int i = n; i >= 0; i--) {
			for (int j = i; j < n; j++)
				w[j] -= x[i] * w[j + 1];

			w[i] += a[i];
		}

		return new Polynomial(w);
	}
}
