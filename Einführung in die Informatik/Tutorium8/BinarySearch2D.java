package Tutorium8;

import java.util.Arrays;

public class BinarySearch2D {
    public static int[] binarySearch2D(int[][] haystack, int needle) {
        if (haystack != null && haystack.length > 0) return FirstValueOfEachRow(haystack, needle);
        else { System.out.println("2D array must not be empty!"); return null; }
    }

    private static int[] FirstValueOfEachRow(int[][] haystack, int needle) {
        int[] rowValue = new int[haystack.length];

        for (int i = 0; i < rowValue.length; i++) {
            rowValue[i] = haystack[i][0];
        }
        return NeedleRow(haystack, rowValue, 0, haystack.length - 1, needle);
    }

    private static int[] NeedleRow(int[][] haystack, int[] row, int topLimit, int bottomLimit, int needle) {
        if (needle < row[0]) return new int[] {-1, -1};

        int middle = (topLimit + bottomLimit) / 2;

        if (needle == row[middle]) return new int[] {middle, 0};
        else if (needle < row[middle]) return NeedleRow(haystack, row, topLimit, middle, needle);
        else if (middle==bottomLimit || needle<row[middle+1]) return ColumnValuesForNeedleRow(haystack, needle, middle);
        else return NeedleRow(haystack, row, middle + 1, bottomLimit, needle); // + 1 → abrunden entgegenwirken
    }

    private static int[] ColumnValuesForNeedleRow(int[][] haystack, int needle, int row) {
        int[] columnValue = new int[haystack[row].length];

        for (int i = 0; i < columnValue.length; i++) {
            columnValue[i] = haystack[row][i];
        }
        return NeedleColumn(columnValue, 0, columnValue.length - 1, needle, row);
    }

    private static int[] NeedleColumn(int[] column, int leftLimit, int rightLimit, int needle, int row) {
        if (needle > column[column.length - 1] || rightLimit < leftLimit) return new int[] {-1, -1};

        int middle = (leftLimit + rightLimit) / 2;

        if (needle == column[middle]) return new int[] {row, middle};
        else if (needle < column[middle]) return NeedleColumn(column, leftLimit, middle - 1, needle, row);
        else return NeedleColumn(column, middle + 1, rightLimit, needle, row);
    }

    public static int[][] generateArray(int k, int m) {
        int fillValue = 1;
        int[][] haystack = new int[k][m];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                haystack[i][j] = fillValue++;
            }
        }
        return haystack;
    }

    public static int[][] generateRandomArray(int k, int m, int low, int high) {
        int[][] haystack;
        if (k <= 0 && m <= 0) { System.out.println("2D array must have at least one row and one column"); return null; }
        else haystack = new int[k][m];

        if (high <= low) { System.out.println("Invalid interval range! (high <= low)"); return null; }
        double ValueRange = (double) (high - low) / (k * m);

        int loopCounter = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                double exactLowerBound = low + ValueRange * loopCounter++;
                int usedlowerBound = (int) exactLowerBound;

                if (low < 0) { // explizite Typumwandlung zu int führt für Werte < 0 zu unerwünschtem Rundungsverhalten
                    if (exactLowerBound - usedlowerBound < 0) usedlowerBound--; // Dezimalstellen != 0? → abrunden
                    if (usedlowerBound < 0) usedlowerBound--; // Aufrunden in folgender Typumwandlung entgegenwirken
                }

                do {
                    haystack[i][j] = (int) (usedlowerBound + Math.random() * ValueRange);
                } while (j != 0 && haystack[i][j - 1] > haystack[i][j] ||
                        i != 0 && j == 0 && haystack[i - 1][m - 1] > haystack[i][j]);
            }
        }
        return haystack;
    }

    public static void main(String[] args) {
        int[][] haystack = generateArray(10, 10);
        System.out.println(Arrays.deepToString(haystack));
        System.out.println(Arrays.toString(binarySearch2D(haystack, 1)));
        System.out.println(Arrays.toString(binarySearch2D(haystack, 45)));
        System.out.println(Arrays.toString(binarySearch2D(haystack, 99)));
        System.out.println();

        int[][] haystackRandom = generateRandomArray(5, 5, -100, 100);
        System.out.println(Arrays.deepToString(haystackRandom));
        System.out.println(Arrays.toString(binarySearch2D(haystackRandom, -73)));
        System.out.println(Arrays.toString(binarySearch2D(haystackRandom, 22)));
        System.out.println(Arrays.toString(binarySearch2D(haystackRandom, 87)));
    }
}