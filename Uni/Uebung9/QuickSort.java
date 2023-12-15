package Uebung9;

/**
 a = {5, 3, 4, 8, 7, 1, 2} <p>
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
 <b> a = {1, 2, 3, 4, 5, 7, 8} </b> // Quicksort abgeschlossen
 */
public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        // TODO: quicksort-algorithm for generics

    }
}