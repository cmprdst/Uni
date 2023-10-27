public class Sieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] primes = new int[n]; // n garantiert > Anzahl der gefundenen Primzahlen
        int i; // Zählvariable
        int j = 0; // Anzahl der Primzahlen im Array

        for (int a = 2; a <= n; a++) {
            i = 0;
            while (i < j && a % primes[i] != 0) i++;
            if (i == j) primes[j++] = a;
        }
        String Primes = "" + primes[0];
        for (i = 1; i < j; i++) {
            Primes += " " + primes[i]; // "Nullen" im Array bleiben unberücksichtigt
        }
        System.out.println(Primes);
    }
}