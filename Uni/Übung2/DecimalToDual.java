package Übung2;

public class DecimalToDual {
//---------------------------------------------------------------------------//
  public static String transformDual(int dec) {
    // Länge des Arrays für die Dualzahl bestimmen
    int decInit = dec; // originalen Wert speichern
    int i;
    for (i = 1; dec / 2 > 0; i++) dec /= 2;
    int n = i;
    int[] dualArray = new int[n];

    // Sicherstellen, dass die Dualzahl mit "1" beginnt wenn dec > 0
    if (decInit > 0) dualArray[0] = 1;

    // Ermittlung mithilfe des Rests aus der Teilung durch 2, ob an Stelle n - i eine 1 oder 0 steht
    dec = decInit;
    for (i = 1; dec / 2 > 0; i++) {
      dualArray[n - i] = dec % 2;
      dec /= 2;
    }

    // Wandle Array zu int um
    int dualNumber = 0;
    int powerOfTen = 1;
    int j;
    for (i = 0; i < n; i++) {
      if (dualArray[i] == 1) {
        for (j = 0; j < (n - 1) - i; j++) powerOfTen *= 10;
        dualNumber += powerOfTen;
        powerOfTen = 1;
      }
    }
    return "" + dualNumber; // int als String
  }
//---------------------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.println(transformDual(0).equals(Integer.toBinaryString(0)));
    System.out.println(transformDual(1).equals(Integer.toBinaryString(1)));
    System.out.println(transformDual(2).equals(Integer.toBinaryString(2)));
    System.out.println(transformDual(5).equals(Integer.toBinaryString(5)));
    System.out.println(transformDual(13).equals(Integer.toBinaryString(13)));
  }
}