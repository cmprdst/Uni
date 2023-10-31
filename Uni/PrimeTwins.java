import java.util.Arrays;

public class PrimeTwins {
//---------------------------------------------------------------------------//
  public static int[][] primeTwins(int amount) {
    int[][] primeTwins = new int[amount][2];
    int[] primes = new int[amount * 10]; // ausreichend großes Feld (Anzahl Primzahlen > Anzahl Primzahlzwillinge)
    int j = 0; // Anzahl Primzahlen im Feld
    // Feld mit Primzahlen auffüllen
    for (int a = 2; j < primes.length; a++) { int i = 0;
      while (i < j && a % primes[i] != 0) i++;
      if (i == j) primes[j++] = a;
    }
    // Matrix mit Primzahlzwillingen füllen
    int k = 0;

    for (int i = 0; i + 1 < primes.length; i++) {
      if (k < amount && primes[i + 1] - primes[i] == 2) {
        primeTwins[k][0] = primes[i];
        primeTwins[k][1] = primes[i + 1];
        k++;
      }
    }
    return primeTwins;
  }
//---------------------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.print(Arrays.deepToString(primeTwins(100)));
  }
}