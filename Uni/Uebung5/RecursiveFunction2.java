package Uebung5;

import java.util.Arrays;

public class RecursiveFunction2 {
   public static int marge(int n) {

      if (n >= 0) {
         return (n == 0) ? 1 : n - homer(marge(n - 1));
      } else {
         System.out.println("Der eingegebene Wert muss >= 0 sein.");
         return 0;
      }
   }

   public static int homer(int n) {

      if (n >= 0) {
         return (n == 0) ? 0 : n - marge(homer(n - 1));
      } else {
         System.out.println("Der eingegebene Wert muss >= 0 sein.");
         return 0;
      }
   }

   public static boolean dispute(int n) {

      if (n >= 0) return !(marge(n) == homer(n));
      else {
         System.out.println("Der eingegebene Wert muss >= 0 sein.");
         return false;
      }
   }

   public static int[] differenceDisputes(int x) {

      try {
         int[] yearOfDispute = new int[x + 1]; // Streitjahre ermitteln (x Differenzen gesucht → x + 1 Werte benötigt)
         int[] differenceDisputes = new int[x]; // Abstand der Streitjahre mittels Differenz in neuem Feld festhalten
         int j = 0;

         for (int i = 0; j <= x; i++) {
            if (dispute(i)) yearOfDispute[j++] = i;
         }

         for (int i = 0; i + 1 < yearOfDispute.length; i++) {
            differenceDisputes[i] = yearOfDispute[i + 1] - yearOfDispute[i];
         }
         return differenceDisputes; // Fibonacci-Zahlen
      }
      catch (Exception e) {
         System.out.println("Der eingegebene Wert muss >= 0 sein.");
         return null;
      }
   }

   public static void main(String[] args) {

      System.out.println(dispute(7)); // Streit
      System.out.println(dispute(25)); // Frieden

      System.out.println(Arrays.toString(differenceDisputes(10)));
      // Abstand zwischen den Streiten nimmt zu → Homer und Marge verstehen sich über die Jahre besser
   }
}