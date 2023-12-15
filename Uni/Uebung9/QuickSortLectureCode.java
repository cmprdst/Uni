package Uebung9;

import java.util.Arrays;

public class QuickSortLectureCode {
    public static void quicksort(int[] a) {
        _quicksort(a, 0, a.length - 1); // [a0,...,an −1]
    }

    static void _quicksort(int[] a, int l, int r) {
        if (r > l) { // [al,...,ar]
            int m = partition(a, l, r); // pivot p = am
            _quicksort(a, l, m - 1);
            _quicksort(a, m + 1, r);
        }
    }

    static int partition(int[] a, int l, int r) {
        assert (l <= r); // l-eft , r-ight
        int p = a[r], t; // pivot
        int i = l - 1, j = r;
        do {
            do ++i; while (a[i] < p); // find
            do --j; while (j > l && a[j] > p);
            t = a[i];
            a[i] = a[j];
            a[j] = t; // swap
        } while (i < j);
        a[j] = a[i];
        a[i] = a[r];
        a[r] = t;
        return i; // new index of pivot
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 4, 8, 7, 1, 2};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }
}
