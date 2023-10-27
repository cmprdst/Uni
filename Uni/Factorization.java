public class Factorization {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            n = 0;
            System.out.println("Primfaktorzerlegung nicht möglich, Zahl zu klein.");
        }
        int[] primes = new int[n]; // n garantiert > Anzahl der gefundenen Primzahlen
        int i; // Zählvariable
        int j = 0; // Anzahl der Primzahlen im Array

        for (int a = 2; a <= n; a++) {
            i = 0;
            while (i < j && a % primes[i] != 0) i++;
            if (i == j) primes[j++] = a;
        }
        int k; // Anzahl an Divisionen
        if (n > 1) System.out.print(n + " = ");
        for (i = 0; i < j; i++) {
            k = 0;
            while (n % primes[i] == 0) {
                k++;
                n /= primes[i];
            }
            if (k != 0 && n > 1) {
                System.out.print(primes[i] + "^" + k + " * ");
            } else if (n == 1) { // Ende der Division erreicht → Schlussklausel
                System.out.printf(primes [i] + "^" + k + "%n");
                break;
            }
        }
    }
}