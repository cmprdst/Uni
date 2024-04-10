/************************************

Übernommen von meinem Kommilitonen Mark

 ************************************/
package Tutorium4;

public class SudokuValidator {

    public static void main(String[] args) {
        // Example of a valid Sudoku
        int[][] validSudoku = {
                {8, 3, 6, 5, 9, 4, 7, 1, 2},
                {2, 5, 7, 3, 6, 1, 4, 8, 9},
                {9, 1, 4, 7, 8, 2, 3, 6, 5},
                {7, 9, 2, 4, 3, 8, 1, 5, 6},
                {1, 6, 8, 2, 5, 7, 9, 3, 4},
                {5, 4, 3, 9, 1, 6, 8, 2, 7},
                {4, 2, 5, 8, 7, 3, 6, 9, 1},
                {6, 8, 9, 1, 4, 5, 2, 7, 3},
                {3, 7, 1, 6, 2, 9, 5, 4, 8}
        };

        // Example of an invalid Sudoku
        int[][] invalidSudoku = {
                {8, 3, 6, 5, 9, 4, 7, 1, 2},
                {2, 5, 7, 3, 6, 1, 4, 8, 9},
                {9, 1, 4, 7, 8, 2, 3, 6, 5},
                {7, 9, 2, 4, 3, 8, 1, 5, 6},
                {1, 6, 8, 2, 5, 7, 9, 3, 4},
                {5, 4, 3, 9, 1, 6, 8, 2, 7},
                {4, 2, 5, 8, 7, 3, 6, 9, 1},
                {6, 8, 9, 1, 4, 5, 2, 7, 3},
                {3, 7, 1, 6, 2, 9, 5, 4, 1}
        };

        System.out.println("Is valid Sudoku: " + isValidSudokuSolution(validSudoku)); // shoukd be valid
        System.out.println("Is valid Sudoku: " + isValidSudokuSolution(invalidSudoku)); // invalid; cause: duplicate 1 bottom right corner
    }

    public static boolean isValidSudokuSolution(int[][] sudoku) {
        return isValidRows(sudoku) && isValidColumns(sudoku) && isValidSubmatrices(sudoku);
    } //checks rows cols subs

    private static boolean isValidRows(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(sudoku[i])) {
                return false;
            }//loops through and checks each row
        }
        return true;
    }

    private static boolean isValidColumns(int[][] sudoku) {
        for (int j = 0; j < 9; j++) {
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = sudoku[i][j];
            }//basically flips the sets on its side, so it can loop through all columns instead; does this by just looping thru and taking xth element and making a new col, then clears and repeats per col
            if (!isValidSet(column)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSubmatrices(int[][] sudoku) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] submatrix = new int[9];
                int index = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        submatrix[index++] = sudoku[x][y];
                    }
                }//same as columns but with submatrices instead; takes a 3x3 and adds it into a set of 9 no.s
                if (!isValidSet(submatrix)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSet(int[] set) {
        boolean[] seen = new boolean[10];
        for (int num : set) {
            if (num != 0 && seen[num]) {
                return false; //basically checks if duplicates exist in the set passed through, returns false if it does
            }
            seen[num] = true;
        }
        return true;
    }
}