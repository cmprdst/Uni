package Übung4;

public class HornerSchema {
//---------------------------------------------------------------------------//
  public static double evalSimple(double[] a, double x) {

    double powerX = 1;
    double function = 0;

    try {
      function = a[0];

      for (int i = 1; i < a.length; i++) {
        powerX *= x; // ab a1 immer ein x dazu multipliziert, bspw. n = 3 -> a0 + a1 * x + a2(x) * x + a3(x * x) * x
        function += a[i] * powerX; // n-mal multiplizieren (zu a0 wird nichts multipliziert, bspw. n = 3 -> 3 Produkte)
      }
      // powerX Multiplikationen + function Multiplikationen = n + n = 2n
    }
    catch (Exception e) {
      System.out.println("Die Eingabe war fehlerhaft.");
    }
    return function;
  }
//---------------------------------------------------------------------------//
  public static double evalHorner(double[] a, double x) {

    double function = 0;

    try {
      function = a[a.length - 1];

      for (int i = a.length - 2; i >= 0; i--) {
        function *= x; // wie oben n-mal multiplizieren (bspw. n = 3 → 3 Produkte von a3 bis a1, bei a0 kein Produkt)
        function += a[i];
      }
    }
    catch (Exception e) {
      System.out.println("Die Eingabe ist fehlerhaft.");
    }
    return function;
    /* Beim Algorithmus aus 2. müssen im Vergleich zum Algorithmus aus 1. nur halb so viele Multiplikationen
    durchgeführt werden, dementsprechend ist er effizienter.
     */
  }
//---------------------------------------------------------------------------//
  public static double evalHornerRec(double[] a, double x) {

    if (a.length == 0) {
      System.out.println("Die Eingabe ist fehlerhaft.");
      return 0;
    }
    else return evalHornerRecWithI(a, x, a.length - 1, 0);
  }
  public static double evalHornerRecWithI(double[] a, double x, int i, double function) {

    if (i == 0) return function + a[0];
    else {
      function = (function + a[i]) * x;
      return evalHornerRecWithI(a, x, i - 1, function);
    }
  }
//---------------------------------------------------------------------------//
  public static void main (String[] args) {
    double[] a = {1, 2, 3, 4, 5};
    double x = 3;
    System.out.println(evalSimple(a, x));
    System.out.println(evalHorner(a, x));
    System.out.println(evalHornerRec(a, x));
  }
}
