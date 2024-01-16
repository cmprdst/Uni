package Uebung12;

import java.io.Serial;

public class ComplexNumber {
  private class InvalidInputForSquareRoot extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;
    private InvalidInputForSquareRoot() { super("Syntax issue or imaginary part != 0!"); }
  }

  private double real;
  private double imag;

  public ComplexNumber(double re, double im) { real = re; imag = im; }

  public ComplexNumber add(ComplexNumber k) { return new ComplexNumber(real + k.real, imag + k.imag); }

  public ComplexNumber mult(ComplexNumber k) {
    return new ComplexNumber(real * k.real - imag * k.imag, real * k.imag + imag * k.real);
  }

  public double absoluteValue() { return Math.sqrt(real * real + imag * imag); }

  public ComplexNumber sqrt() throws InvalidInputForSquareRoot {
    try {
      if (imag != 0) throw new InvalidInputForSquareRoot();
      return real >= 0 ? new ComplexNumber(Math.sqrt(real), 0) : new ComplexNumber(0, Math.sqrt(-real));
    } catch (InvalidInputForSquareRoot invalidInputForSquareRoot) {
      throw new InvalidInputForSquareRoot();
    }
  }

  public String toString() { return real + " + " + imag + "*i"; }

  public static void main(String[] args) {
    ComplexNumber z = new ComplexNumber(4, 0);
    ComplexNumber y = new ComplexNumber(3, 1);
    ComplexNumber x = new ComplexNumber(2, 2);

    System.out.println(z.add(y));
    System.out.println(y.mult(x));

    double abs_z = z.absoluteValue();
    System.out.println(z.sqrt());
    System.out.println(abs_z);

    System.out.println(y.sqrt());
  }
}