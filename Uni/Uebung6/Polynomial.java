package Uebung6;

import java.util.Arrays;

public class Polynomial {

    private int degree; // highest power of x
    private double[] coeffs; // Array with coefficients, all coefficients [0..degree] are necessary

    public Polynomial(double[] c) {
        if (c.length > 0) {
            this.coeffs = c; // Koeffizienten werden 1:1 übernommen
            this.degree = getDegree(); // Grad des Polynoms = höchster Index mit Koeffizient != 0;
        } else System.out.println("Array must consist of at least one double value.");
    }

    public int getDegree() {
        int i = 1;
        while (this.coeffs[this.coeffs.length - i] == 0) { i++; } // Ermittlung des höchsten Index mit Koeffizient != 0
        return this.degree = this.coeffs.length - i;
    }

    public double[] getAllCoefficients() { return this.coeffs; }

    public double getCoefficient(int i) {
        if (i >= 0 && i < this.coeffs.length) return this.coeffs[i]; // Koeffizienten = 0 werden berücksichtigt
        else {
            System.out.println("Input index is out of bounds.");
            return -1;
        }
    }

    public String toString() {
        String polynomial = "";
        int j = 0; // Zählt, wie viele Terme dem String bereits hinzugefügt wurden

        for (int i = this.coeffs.length - 1; i >= 0; i--) {
            if (this.coeffs[i] == 0) { // falls Koeffizient = 0 gesamter Term = 0 → wird übersprungen
                continue;
            }
            if (j > 0 && this.coeffs[i] > 0) { // "+" wird erst nach erstem Term eingefügt
                polynomial += " + ";
            } else if (j > 0) polynomial += " "; // Vorzeichen der negativen Zahl dient als Verknüpfungselement

            switch (i) {
                case 0: polynomial += this.coeffs[i]; j++; break;
                case 1: polynomial += this.coeffs[i] == 1 ? "x" : this.coeffs[i] + "x"; j++; break;
                default: polynomial += this.coeffs[i] == 1 ? "x^" + i : this.coeffs[i] + "x^" + i; j++; break;
            }
        }
        return polynomial;
    }

    public double evaluate(double x) { // Horner-Schema abgewandelt aus vorheriger Übungsaufgabe übernommen
        double function = this.coeffs[this.coeffs.length - 1];

        for (int i = this.coeffs.length - 2; i >= 0; i--) {
            function *= x;
            function += this.coeffs[i];
        }
        return function;
    }

    public Polynomial differentiate() { // Ableitung abgewandelt aus vorheriger Übungsaufgabe übernommen
        if (this.coeffs.length == 1) return new Polynomial(new double[] {0}); // Ableitung einer Konstante = 0

        double[] deriv = new double[this.coeffs.length - 1];

        for (int i = 0; i < deriv.length; i++) {
            deriv[i] = this.coeffs[i + 1] * (i + 1);
        }
        return new Polynomial(deriv);
    }

    public static void main(String[] args) {
        double[] test = {2, 4, -3, 0, 1, 0};
        Polynomial testPoly = new Polynomial(test);

        System.out.println(testPoly);
        System.out.println(testPoly.getDegree());
        System.out.println(Arrays.toString(testPoly.getAllCoefficients()));
        System.out.println(testPoly.getCoefficient(5));
        System.out.println(testPoly.evaluate(3));

        Polynomial deriv = testPoly.differentiate();
        System.out.println(deriv);
    }
}