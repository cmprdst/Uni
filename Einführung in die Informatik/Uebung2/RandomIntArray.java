package Uebung2;

import java.util.Arrays;

public class RandomIntArray {
  //---------------------------------------------------------------------------//
  public static int[] createRandom(int n) {
    int[] randomValues = new int[n];
    for (int i = 0; i < n; i++)
      randomValues[i] = (int) (94 * Math.random()) + 5; // gewollter Bereich 5 ≤ n ≤ 99, aber Methode beginnt bei 0 → +5
    return randomValues;
  }
  //---------------------------------------------------------------------------//
  public static String toString(int[] a) {
    String arrayToString = "[" + a[0];
      // da a von außen gegeben, Länge konkret abfragen, um OutOfBoundsException zu verhindern, alternativ try/catch
      for (int i = 1; i < a.length; i++) arrayToString += ", " + a[i];
    arrayToString += "]";
    return arrayToString; // int[] als String
  }
//---------------------------------------------------------------------------//
  public static int posMin(int[] a) {
    int i = 0;
    int smallNumPos = i;
    int smallNumValue = a[i];
    for (i = 0; i < a.length - 1; i++) {
      if (a[i] < a[i + 1] && a[i] < smallNumValue) {
        smallNumValue = a[i];
        smallNumPos = i;
      } else if (a[i + 1] < a[i] && a[i + 1] < smallNumValue) {
        smallNumValue = a[i + 1];
        smallNumPos = i + 1;
      }
    }
    return smallNumPos;
  }
//---------------------------------------------------------------------------//
  public static void swap(int[] a) {
    int memory;
    memory = a[0];
    a[0] = a[a.length - 1];
    a[a.length - 1] = memory;
  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(createRandom(10)));
    System.out.println(toString(new int[]{1, 2, 3, 77, 2, 6}).equals(Arrays.toString(new int[]{1, 2, 3, 77, 2, 6})));
    System.out.println(posMin(new int[]{6, -3, 4, 1}));
    int[] a = {1, 2, 3, 4, 5};
    swap(a);
    System.out.println(Arrays.toString(a));
  }
}
