package Uebung2;// import java.util.Arrays; - Kontrolle

public class MedianOfThree {
//---------------------------------------------------------------------------//
  public static int median(int a, int b, int c) {

    /*
    a = 3;
    b = 2;
    c = 1;
    */

    int median = 0;

    if (a == b && a == c) // alle drei Zahlen identisch
      median = a; // oder = b oder = c
    if (a == b || a == c) // zwei Zahlen identisch, 2 Fälle (3 insgesamt)
      median = a;
    if (b == c) // zwei Zahlen identisch, letzter Fall
      median = b; // oder = c
    if (b < a && a < c || c < a && a < b) // (b < a < c) oder (c < a < b) → Variable a "mittig"
      median = a;
    if (a < b && b < c || c < b && b < a) // (a < b < c) oder (c < b < a) → Variable b "mittig"
      median = b;
    if (a < c && c < b || b < c && c < a) // (a < c < b) oder (b < c < a) → Variable c "mittig"
      median = c;

    return median;
  }

//---------------------------------------------------------------------------//
  public static int median2(int a, int b, int c) {

    /*
    a = 3;
    b = 1;
    c = 2;
     */

    int[] arranged = {a, b, c};
    // System.out.println(Arrays.toString(arranged)); - Kontrolle
    int n = 3; // Anzahl der Elemente in der Menge
    int i = 0; // Index
    int j = 0; // Anzahl abgeschlossener Durchläufe
    int memory; // Damit Ausgangswert für Element nicht verloren geht beim Tausch

    while (j < n - 1) { // Kommentar Zeilen 58 - 59 (hat Leserlichkeit behindert)
      while (i < 2) { // Out of Bounds verhindern (im if-Statement i + 1: (i + 1 < 3) → i < 2
        if (arranged[i] > arranged[i + 1]) { // Zahl aus der Menge größer als die nächste?
          memory = arranged[i + 1]; // tausche die beiden Zahlen → Sortierung der Elemente nach Betrag (aufsteigend)
          arranged[i + 1] = arranged[i];
          arranged[i] = memory;
        }
        i++;
      }
      i = 0;
      j++;
      // System.out.println(Arrays.toString(arranged)); - Kontrolle
    }
    return arranged[1]; // "Mitte" der Menge
  }
  /* Vorgang "n - 1"-mal wiederholen, denn falls der 1. Wert größer als alle anderen oder = ist, muss er bis zur letzten
  Stelle rücken können; n - 1 und nicht n, da Zählung der Indizes ab 0, für n aber ab 1, da Menge sonst leer (null) */
//---------------------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.println(median(0, 0, 0));
    /*
    Ergebnisse für Testeinsetzungen
    {1, 1, 1} → median 1
    {1, 0, 1} → median 1 (für alle Abwandlungen identisch)
    {0, 1, 0} → median 0 -"-
    {1, 2, 3} → median 2 -"-
     */
    System.out.println(median2(0, 0, 0));
    /*
    Ergebnisse für Testeinsetzungen
    {1, 1, 1} → {1, 1, 1} → {1, 1, 1} → median 1
    {1, 1, 0} → {1, 0, 1} → {0, 1, 1} → median 1
    {1, 0, 0} → {0, 0, 1} → {0, 0, 1} → median 0
    {3, 2, 1} → {2, 1, 3} → {1, 2, 3} → median 2
     */
  }
}