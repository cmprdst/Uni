package Übung5;

import java.util.Arrays;

public class DifferentialPolynom {
   public static double[] diffPoly(double[] coeffs) {

      try {
         if (coeffs.length == 1) return new double[0];

         double[] deriv = new double[coeffs.length - 1];

         for (int i = 0; i < deriv.length; i++) {
            deriv[i] = coeffs[i + 1] * (i + 1);
         }
         return deriv;
      }
      catch (Exception e) {
         System.out.println("Entweder war der Input ungültig oder das angegebene Feld leer.");
         return null;
      }
   }

   public static void main(String[] args) {
      double[] test = {7, 5, 3};
      System.out.println(Arrays.toString(diffPoly(test)));
   }
}