package Uebung9;

import java.util.Arrays;
import java.util.Comparator;

/**
 * a = {5, 3, 4, 7, 1, 2} // Array in der Mitte teilen <p>
 * a1 = {5, 3, 4}; a2 = {7, 1, 2} // das erste Array in der Mitte teilen <p>
 * a11 = {5}; a12 = {3, 4} // das zweite Array in der Mitte teilen <p>
 * a121 = {3}; a122 = {4} // Arrays nur noch einelementig → sortieren und in neues Array übernehmen <p>
 * b = {3, 4} // nächsten Wert einsortieren (a11) <p>
 * c = {3, 4, 5} // a1 sortiert → a2 in der Mitte teilen <p>
 * a21 = {7}; a22 = {1, 2} // a22 in der Mitte teilen <p>
 * a221 = {1}; a222 = {2} // Arrays nur noch einelementig → sortieren und in neues Array übernehmen <p>
 * d = {1, 2} // nächsten Wert einsortieren (a21) <p>
 * e = {1, 2, 7} // Verschmelzen der sortierten Teilarrays (c und e) <p>
 * f = {1, 2, 3, 4, 5, 7} ✔
 */

/*
Das "divide and conquer"-Prinzip zielt darauf ab, ein großes Problem in viele Einzelteile zu zerlegen, um den nötigen
Aufwand zu verringern. Im Mergesort findet dies Anwendung, indem ein zu sortierendes Array so lange halbiert wird, bis
die entsprechenden Teilarrays nur noch aus einem Element bestehen, sodass Stück für Stück verglichen werden kann und man
das sortierte Array nach und nach aus teilsortierten Zwischenergebnissen zusammensetzt.
Diese Umsetzung des Mergesort benötigt weniger Speicherplatz als die in der Vorlesung vorgestellte, weil im
ursprünglichen Array selbst die schrittweisen Veränderungen vorgenommen werden, sodass sich die Anzahl der zusätzlich
benötigten Teilarrays auf das "copy"-Hilfsarray beschränkt.

Ja, dieser Mergesort-Algorithmus ist stabil, da die Reihenfolge der Elemente nicht verändert wird.
 */
public class MergeSort {
//-------------------------------------------------------------------//
  public static <T> void mergeSort(T[] a, Comparator<T> c) {
    _mergeSort(a, a.clone(), 0, a.length - 1, c);
  }

  private static <T> void _mergeSort(T[] a, T[] copy, int start, int end, Comparator<T> c) {
    if (start < end) {
      int mid = (start + end) / 2;
      _mergeSort(a, copy, start, mid, c);
      _mergeSort(a, copy, mid + 1, end, c);
      merge(a, copy, start, mid, end, c);
    }
  }

  private static <T> void merge(T[] a, T[] copy, int start, int mid, int end, Comparator<T> c) {
    int i = 0;
    int j = start;
    int k = start;

    while (j <= mid) { copy[i++] = a[j++]; }

    i = 0;

    while (k < j && j <= end) {
      if (c.compare(copy[i], a[j]) <= 0) a[k++] = copy[i++];
      else a[k++] = a[j++];
    }

    while (k < j) { a[k++] = copy[i++]; }
  }

  //-------------------------------------------------------------------//
  public static void main(String[] args) {
    String[] beispiele = {"Glas", "Kasten", "Katze", "Lavendel", "Naseweiß", "Hund", "Schreibtisch", "Maus", "Mauer"};

    System.out.println(Arrays.toString(beispiele));

    mergeSort(beispiele, Comparator.naturalOrder());
    System.out.println(Arrays.toString(beispiele));

    mergeSort(beispiele, Comparator.reverseOrder());
    System.out.println(Arrays.toString(beispiele));

    mergeSort(beispiele, Comparator.comparing(String::length));
    System.out.println(Arrays.toString(beispiele));
  }
}
