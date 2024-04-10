package Uebung7;

/********************************************************
 x = 2, n = 13
 2^13 = 2 * 2^(12) = 2 * 4^6 = 2 * 16^3 = 2 * 16 * 16^2 = 2 * 16 * 256 = 8192 ✔
 ********************************************************/

public class FastExponentiation {

   static int recCallCounter = 0;
   static int iterCallCounter = 0;

   static boolean validN(int n) {

      if (n >= 0) return true;
      else {
         System.out.println("n must be >= 0!");
         return false;
      }
   }

   public static double fastPotRek(double x, int n) {

      recCallCounter++;

      if (validN(n)) {
         if (n == 0) return 1;
         else if (n > 1 && n % 2 == 0) return fastPotRek(x * x, n / 2);
         else return x * fastPotRek(x, n - 1);
      } else return 0;
   }

   public static double fastPotIter(double x, int n){

      double solution = 1; // mindestens ^0 = 1, neutrales Element der Multiplikation

      if (validN(n)) {
         while (n > 0) {
            iterCallCounter++;
            if (n % 2 != 0) {
               solution *= x;
               n--;
            }
            x *= x;
            n /= 2;
         }
         return solution;
      } return 0;
   }

   public static void main(String[] args) {
      System.out.println(fastPotRek(2, -1));
      System.out.println(recCallCounter); // in allen Fällen mindestens 1
      System.out.println(fastPotIter(2, -1));
      System.out.println(iterCallCounter); // für n < 1 = 0

      System.out.println(fastPotRek(2, 13));
      System.out.println(recCallCounter); // 8
      System.out.println(fastPotIter(2, 13));
      System.out.println(iterCallCounter); // 4 (halb so viele wie rekursiv?)

      System.out.println(fastPotRek(1.0000001, 1000000000));
      System.out.println(recCallCounter); // 51 → extrem niedriger (logarithmischer) Anstieg in Abhängigkeit von n
      System.out.println(fastPotIter(1.0000001, 1000000000));
      System.out.println(iterCallCounter); // 34 → Anstieg sogar noch geringer als bei rekursiver Methode
   }
}