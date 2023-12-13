package Uebung8;

public class TernarySearch {
  static final int UNDEF = -1;
  static int recCallCount = 0;
  static int compareCount = 0;

  // binäre Suche aus der Vorlesung
  public static int find(int[] a, int x) { return _find(a, 0, a.length - 1, x); }

  private static int _find(int[] a, int l, int r, int x) { recCallCount++;
    if (l > r) return UNDEF; compareCount++;

    int m = (l + r) / 2;

    if (x == a[m]) { compareCount++; return m; }

    else if (x < a[m]) { compareCount++; return _find(a, l, m - 1, x); }
    else return _find(a, m + 1, r, x);
  }

  public static int ternaryRec(int[] a, int x) { return _ternaryRec(a, 0, a.length - 1, x); }

  private static int _ternaryRec(int[] a, int outLeft, int outRight, int x) { recCallCount++;
    if (outLeft > outRight) return UNDEF; compareCount++;

    int left = Math.max((outLeft + outRight) / 3, outLeft); // in manchen Fällen wäre ohne "Math.max" left < outLeft
    int right = Math.min((outLeft + outRight) * 2 / 3, outRight); // ähnlich wie oben, right > outRight ausschließen

    if (x == a[left]) { compareCount++; return left; }
    else if (x == a[right]) { compareCount++; return right; }

    else if (x < a[left]) { compareCount++; return _ternaryRec(a, outLeft, left - 1, x); }
    else if (x > a[right]) { compareCount++; return _ternaryRec(a, right + 1, outRight, x); }
    else return _ternaryRec(a, left + 1, right - 1, x);
  }

  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    System.out.println(find(a, -1) + " (" + recCallCount + ", " + compareCount + ")"); recCallCount = 0; compareCount = 0;
    System.out.println(ternaryRec(a, -1) + " (" + recCallCount + ", " + compareCount + ")\n"); recCallCount = 0; compareCount = 0;
    System.out.println(find(a, 2) + " (" + recCallCount + ", " + compareCount + ")"); recCallCount = 0; compareCount = 0;
    System.out.println(ternaryRec(a, 2) + " (" + recCallCount + ", " + compareCount + ")\n"); recCallCount = 0; compareCount = 0;
    System.out.println(find(a, 10) + " (" + recCallCount + ", " + compareCount + ")"); recCallCount = 0; compareCount = 0;
    System.out.println(ternaryRec(a, 10) + " (" + recCallCount + ", " + compareCount + ")\n"); recCallCount = 0; compareCount = 0;
    System.out.println(find(a, 13) + " (" + recCallCount + ", " + compareCount + ")"); recCallCount = 0; compareCount = 0;
    System.out.println(ternaryRec(a, 13) + " (" + recCallCount + ", " + compareCount + ")\n"); recCallCount = 0; compareCount = 0;
    System.out.println(find(a, 21) + " (" + recCallCount + ", " + compareCount + ")"); recCallCount = 0; compareCount = 0;
    System.out.println(ternaryRec(a, 21) + " (" + recCallCount + ", " + compareCount + ")\n");

    /*
    für Testrahmen:
     binär  → best case recCallCount = 1, worst case = 6 → Spannweite = 5, Mittel = 3.5
              best case compareCount = 2, worst case = 8 → Spannweite = 6, Mittel = 5
     ternär → best case recCallCount = 1, worst case = 4 → Spannweite = 3, Mittel = 2.5
              best case compareCount = 2, worst case = 6 → Spannweite = 4, Mittel = 4
    → Die ternäre Suche lieferte in den meisten Fällen in weniger Schritten ein Ergebnis, als die binäre Suche.

    → Die zu erwartende Laufzeit der ternären Suche beträgt im besten Fall auch 1 und sonst durchschnittlich log₃n+1.
      Die Basis des Logarithmus entspricht der Anzahl der Teile, in die das Array "zerlegt" wird. Damit ist sie zwar in
      der Theorie besser, aufgrund ihrer Einfachheit kann es jedoch trotzdem von Vorteil sein, auf die binäre Suche
      zurückzugreifen, außerdem fällt der Unterschied insbesondere für kleine Arrays eher gering aus.
     */

    /*
    Nachtrag aus der Übung:

    Aufwand binäre Suche: 2 * log2n (2 Vergleiche * Anzahl an Teilungen von n bis n = 1)
    Aufwand ternäre Suche: 4 * log3n (4 Vergleiche * Anzahl an Teilungen von n bis n = 1)
    --> 2 * log2n < 4 * log3n --> binäre Suche effizienter
     */
  }
}