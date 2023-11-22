package Uebung4; /**************************************

 fib1(5) → fib1(3) → fib1(1) →                     +1
                   → fib1(2) → fib1(0) →           +1
                             → fib1(1) →           +1
         → fib1(4) → fib1(2) → fib1(0) →           +1
                             → fib1(1) →           +1
                   → fib1(3) → fib1(1) →           +1
                             → fib1(2) → fib1(0) → +1
                                       → fib1(1) → +1
                                                    8

 ⇒ 15 Methodenaufrufe (= Fibonacci-Zahl * 2 - 1)
 ⇒ 8 Additionen (= Fibonacci-Zahl)

 fib2(5)
 → 1 + 2 = 3
 → 2 + 3 = 5
 → 3 + 5 = 8

 ⇒ 3 Schleifendurchläufe / Additionen (= n - 2 ersten (festgelegten) Fibonacci-Zahlen)

 ⇒ Statt 15 Methodenaufrufen werden nur 3 Schleifendurchläufe und zwei weniger Additionen benötigt.
 ⇒ Mit zunehmendem n steigt die Anzahl der benötigten Methodenaufrufe und Additionen für fib1() exponentiell, die der
   Schleifendurchläufe und Additionen von fib2() lediglich linear. Damit ist fib2() deutlich effizienter.

***********************************************/

import java.math.*;

public class BigIntegerFibonacci {

    public static int Methodenaufrufe = 0;
    public static int Schleifenaufrufe = 0;

    public static BigInteger fib1(int n) {

        Methodenaufrufe++;
        if (n < 0) { System.out.println("Die Eingabe war ungültig."); return null; }
        else if (n == 0 || n == 1) return BigInteger.ONE;
        else return fib1(n - 2).add(fib1(n - 1));
    }

    public static BigInteger fib2(int n){

        if (n < 0) { System.out.println("Die Eingabe war ungültig."); return null; }
        else if (n == 0 || n == 1) return BigInteger.ONE;

        int after = 2;
        int prior = 1;

        for (int i = 2; i < n; i++) {
            Schleifenaufrufe++;
            int memory = after;
            after += prior;
            prior = memory;
        }
        return BigInteger.valueOf(after);
    }
    public static void main(String[] args) {

        System.out.printf("%d%n", fib1(23));
        System.out.println(Methodenaufrufe);
        System.out.printf("%d%n", fib2(23));
        System.out.println(Schleifenaufrufe);
        System.out.println();

        System.out.printf("%d, ", fib1(1));
        System.out.printf("%d, ", fib1(2));
        System.out.printf("%d, ", fib1(3));
        System.out.printf("%d, ", fib1(4));
        System.out.printf("%d, ", fib1(5));
        System.out.printf("%d, ", fib1(6));
        System.out.printf("%d, ", fib1(7));
        System.out.printf("%d, ", fib1(8));
        System.out.printf("%d, ", fib1(9));
        System.out.printf("%d, ", fib1(10));
        System.out.printf("%d, ", fib1(11));
        System.out.printf("%d, ", fib1(12));
        System.out.printf("%d, ", fib1(13));
        System.out.printf("%d, ", fib1(14));
        System.out.printf("%d", fib1(15));

        System.out.printf("%n%d, ", fib2(1));
        System.out.printf("%d, ", fib2(2));
        System.out.printf("%d, ", fib2(3));
        System.out.printf("%d, ", fib2(4));
        System.out.printf("%d, ", fib2(5));
        System.out.printf("%d, ", fib2(6));
        System.out.printf("%d, ", fib2(7));
        System.out.printf("%d, ", fib2(8));
        System.out.printf("%d, ", fib2(9));
        System.out.printf("%d, ", fib2(10));
        System.out.printf("%d, ", fib2(11));
        System.out.printf("%d, ", fib2(12));
        System.out.printf("%d, ", fib2(13));
        System.out.printf("%d, ", fib2(14));
        System.out.printf("%d", fib2(15));
    }
}