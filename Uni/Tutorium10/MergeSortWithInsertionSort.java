package Tutorium10;

import java.util.Arrays;

public class MergeSortWithInsertionSort {
    public static int[] SortArray(int[] unsorted) { return checkArray(unsorted); }

    private static int[] checkArray(int[] unchecked) {
        if (unchecked == null || unchecked.length == 0) {
            System.out.println("Array must be initialised and not empty!");
            return null;
        } else return mergeSort(unchecked);
    }

    private static int[] mergeSort(int[] checked) {
        int leftLength = checked.length / 2;
        int rightLength = checked.length - leftLength;

        int[] leftCopy = new int[leftLength];
        for (int i = 0; i < leftLength; i++) leftCopy[i] = checked[i];

        int[] rightCopy = new int[rightLength];
        for (int j = 0; j < rightLength; j++) rightCopy[j] = checked[j + leftLength];

        if (leftCopy.length > 22) leftCopy = mergeSort(leftCopy);
        else insertionSort(leftCopy);

        if (rightCopy.length > 22) rightCopy = mergeSort(rightCopy); // sort
        else insertionSort(rightCopy);

        return merge(leftCopy, rightCopy, checked);
    }

    private static int[] merge(int[] leftCopy, int[] rightCopy, int[] checked) {
        int i = 0, j = 0;

        for (int k = 0; k < leftCopy.length + rightCopy.length; k++) {
            if (i >= leftCopy.length) checked[k] = rightCopy[j++];
            else if (j >= rightCopy.length) checked[k] = leftCopy[i++];
            else if (leftCopy[i] <= rightCopy [j]) checked [k] = leftCopy [i++];
            else checked[k] = rightCopy[j++];
        }
        return checked;
    }


    private static void insertionSort(int[] mergeSplit) {
        int n = mergeSplit.length;

        for (int i = 1; i < n; i++) {
            int j; int x = mergeSplit[i];

            for (j = i; j > 0 && mergeSplit[j - 1] > x; j--) mergeSplit[j] = mergeSplit[j - 1];

            mergeSplit[j] = x;
        }
    }

    static long time = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            int[] example = new int[10000];
            for (int i = 0; i < example.length; i++) example[i] = (int) (10000 * Math.random());

            long start = System.nanoTime();
            SortArray(example);
            long end = System.nanoTime();
            time += end - start;
        }

        System.out.println(time /= 10000);
        // Zeit für Schwellenwert = 22: 2274202
        // Zeit für Schwellenwert = 23: 2892950
        // Zeit für Schwellenwert = 24: 2983862
        // Zeit für Schwellenwert = 25: 2056938
        // Zeit für Schwellenwert = 26: 2048474
        // Zeit für Schwellenwert = 27: 2821451
    }
}