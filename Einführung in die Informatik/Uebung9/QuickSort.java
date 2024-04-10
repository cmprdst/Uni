package Uebung9;

import java.util.Arrays;

/**
 a = {5, 3, 4, 8, 7, 1, 2} (Sortierung nach Algorithmus aus Vorlesung) <p>
 <p>
 <i>1. Wähle ein Pivotelement (bspw. den letzten Wert) → p = 2 </i><p>
 <i>2. Durchsuche das Array von links, sodass a[i] > p </i><p>
 <i>3. Durchsuche das Array von rechts, sodass a[j] < p </i><p>
 <i>4. Vertausche die Werte, falls a[i] < a[j] </i><p>
 <i>5. Wiederhole 2. - 4. und stoppe, nachdem zum 1. Mal i > j </i><p>
 <p>
 a = {5, 3, 4, 8, 7, 1, *2*} // a[i] > 2 für i = 0, a[j] < 2 für j = 5 <p>
 a = {1, 3, 4, 8, 7, 5, *2*} // Tausch, nächstes a[i] > 2 für i = 1, nächstes a[j] < 2 für j = 0 <p>
 a = {3, 1, 4, 8, 7, 5, *2*} // letzter Tausch, da nun i > j <p>
 <p>
 a = {.1., 1, 4, 8, 7, 5, *2*} // a[j] = a[i]; die 1 ist jetzt fest, da einzige Zahl links vom alten Pivotelement <p>
 a = {.1., .2., 4, 8, 7, 5, *2*} // a[i] = letzter Wert; die 2 ist jetzt fest, da nun korrekter Index für altes p <p>
 a = {.1., .2., 4, 8, 7, 5, 3} // letzter Wert = altes a[i] vor dem letzten Tausch welches größer als p war <p>
 <p>
 a = {.1., .2., 4, 8, 7, 5, *3*} // p = letzter Wert; i fängt nun bei 2 an und j weiterhin bei 6, da 1 und 2 fest <p>
 a = {.1., .2., 4, 8, 7, 5, *3*} // kein Tausch, da kein a[j] < 3 gefunden <p>
 <p>
 a = {.1., .2., 4, 8, 7, 5, *3*} // a[j] = a[i] hat keinen Effekt, da i = j = 2 <p>
 a = {.1., .2., .3., 8, 7, 5, *3*} // a[i] = letzter Wert, die 3 ist jetzt fest <p>
 a = {.1., .2., .3., 8, 7, 5, 4} // letzter Wert = altes a[i] > p <p>
 ... <p>
 a = {.1., .2., .3., .4., 7, 5, 8} // selbes Szenario wie oben <p>
 <p>
 a = {.1., .2., .3., .4., 7, 5, *8*} // p = letzter Wert, i = 6, j = 5 <p>
 a = {.1., .2., .3., .4., 7, *8*, 5} // einziger Tausch, da nun i > j <p>
 <p>
 a = {.1., .2., .3., .4., 7, 5, 5} // a[j] = a[i] <p>
 a = {.1., .2., .3., .4., 7, 5, 5} // a[i] = letzter Wert (kein Effekt) <p>
 a = {.1., .2., .3., .4., 7, 5, .8.} // letzter Wert = altes a[i] <p>
 <p>
 a = {.1., .2., .3., .4., 7, *5*, .8.} // p = letzter Wert <p>
 a = {.1., .2., .3., .4., 7, *5*, .8.} // kein Tausch, da kein a[j] < 5 gefunden <p>
 <p>
 a = {.1., .2., .3., .4., 7, *5*, .8.} // a[j] = a[i] hat keinen Effekt, i = j = 4 <p>
 a = {.1., .2., .3., .4., 5, *5*, .8.} // a[i] = (nicht fester) letzter Wert <p>
 a = {.1., .2., .3., .4., 5, 7, .8.} // (nicht fester) letzter Wert = altes a[i] > p <p>
 <p>
 <b> a = {1, 2, 3, 4, 5, 7, 8} </b> // Quicksort abgeschlossen <p>
 <p>
 <p>
 Quicksort gehört im mittleren Fall zur Komplexitätsklasse O(logn), da das Array nach jeder Pivotelementwahl ungefähr
 halbiert wird (log₂n). Die Wahl des Pivotelements hat großen Einfluss auf die Anzahl der Vergleiche, da im besten Fall
 das Array immer genau in der Mitte zerteilt und im schlechtesten Fall nur um eine Stelle kleiner wird.
 <p>
 Ein Extremfall wäre folgendes Szenario, bei dem das Pivotelement immer der letzte freie Wert ist:
 <p>
 a = {7, 6, 4, 5, 3, 2, 1}, <p>
 a = {.1., 6, 4, 5, 3, 2, 7} <p>
 a = {.1., 6, 4, 5, 3, 7, 2} <p>
 a = {.1., 6, 4, 5, 3, 2, .7.} <p>
 a = {.1., .2., 4, 5, 3, 6, .7.} <p>
 a = {.1., .2., 4, 5, 6, 3, .7.} <p>
 a = {.1., .2., 4, 5, 3, .6., .7.} <p>
 a = {.1., .2., .3., 5, 4, .6., .7.} <p>
 a = {.1., .2., .3., .4., .5., .6., .7.}
 <p>
 Es wird mühselig nur ein Wert nach dem anderen korrekt einsortiert.
 */

/*
 Quicksort-Algorithmus aus der Vorlesung
 */

public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] a) { _quicksort(a, 0, a.length - 1); }

    static  <T extends Comparable<T>> void _quicksort(T[] a, int l, int r) {
        if (r > l) {
            int m = partition(a, l, r);
            _quicksort(a, l, m - 1);
            _quicksort(a, m + 1, r);
        }
    }

    static  <T extends Comparable<T>> int partition(T[] a, int l, int r) {
        assert (l <= r);
        T p = a[r], t;
        int i = l - 1, j = r;
        do {
            do ++i; while (a[i].compareTo(p) < 0);
            do --j; while (j > l && a[j].compareTo(p) > 0);
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        } while (i < j);
        a[j] = a[i];
        a[i] = a[r];
        a[r] = t;
        return i;
    }

    public static void main(String[] args) {

        Clock[] ClockArray = {
                new Clock(17, 45), new Clock("20:32"), new Clock(3, 13), new Clock(656),
                new Clock(23, 55), new Clock(7), new Clock(12, 24), new Clock("13:37")
        };

        System.out.println(Arrays.toString(ClockArray));

        QuickSort.quickSort(ClockArray);

        System.out.println(Arrays.toString(ClockArray));
    }
}