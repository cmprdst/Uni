import java.util.Arrays;

public class PerfectShuffle {
  //---------------------------------------------------------------------------//
  public static int[] interleave(int[] a1, int[] a2) {
    // neues Feld erzeugen mit ausreichend Platz für alle Werte der beiden gegebenen Felder
    int[] interleave = new int[a1.length + a2.length];
    int j = 0;
    // Werte abwechselnd zuweisen
    for (int i = 0; i + 1 < interleave.length; i += 2) {
      interleave[i] = a1[j];
      interleave[i + 1] = a2[j];
      j++;
    }
    return interleave;
  }
  //---------------------------------------------------------------------------//
  public static int[] perfectShuffle(int[] a) {
    // kein Mischen für ungerade Anzahl an Karten
    if (a.length % 2 != 0) return a;
    // erste Hälfte vom originalen Feld in ein separates Feld überführen
    int[] firstHalf = new int[a.length / 2];
    for (int i = 0; i < a.length / 2; i++) {
      firstHalf[i] = a[i];
    }
    // zweite Hälfte vom originalen Feld in ein separates Feld überführen
    int[] secondHalf = new int[a.length / 2];
    int j = 0;
    for (int i = a.length / 2; i < a.length; i++) {
      secondHalf[j] = a[i];
      j++;
    }
    // "interleave" auf die beiden erzeugten Felder anwenden und ausgeben
    return interleave(firstHalf, secondHalf);
  }
  //---------------------------------------------------------------------------//
  public static int shuffleNumber(int n) {
    // für ungerade Zahl Wert -1 ausgeben
    if (n % 2 != 0) return -1;
    // Feld mit der Länge n erzeugen
    int[] numbers = new int[n];
    // Feld mit Beispielwerten füllen
    for (int i = 0; i < n; i++) numbers[i] = i + 1;
    // Ursprungswerte "speichern", einmal zu Beginn mischen (n > 1)
    int[] memory = numbers;
    numbers = perfectShuffle(numbers);
    int j = 1; // wie oft gemischt wurde
    // für jeden Index die Werte abgleichen, sind sie an einer Stelle ungleich, erneut mischen
    for (int i = 0; i < n; i++) {
      while (numbers[i] != memory[i]) {
        numbers = perfectShuffle(numbers);
        j++;
      }
    }
    return j;
  }
  //---------------------------------------------------------------------------//
  public static void main(String[] args) {
    int[] a1 = {1, 2, 3};
    int[] a2 = {4, 5, 6};
    int[] c = interleave(a1, a2);
    System.out.println(Arrays.toString(c));

    int[] b1 = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(perfectShuffle(b1)));
    int[] b2 = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(Arrays.toString(perfectShuffle(b2)));

    System.out.println(shuffleNumber(3));
    System.out.println(shuffleNumber(52));
  }
}