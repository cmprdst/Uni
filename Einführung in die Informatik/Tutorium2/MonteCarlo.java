package Tutorium2;

import java.util.Arrays;

public class MonteCarlo {
    public static double pi(int n) {
        int k = 0; // wie oft war z < 1
        for (int i = 1; i <= n; i++) {
            double x = Math.random();
            double y = Math.random();
            double z = (x * x) + (y * y);
            if (z < 1) k++;
        }
        if (n > 0) return (double) k / n * 4;
        else return 0;
    }
    public static double[] zonk(int n) {
        int j = 0; // Wie oft gewonnen, wenn bei Wahl geblieben
        int k = 0; // Wie oft gewonnen, wenn Wahl gewechselt

        for (int i = 0; i <=n; i++) {
            int zonk1, zonk2;
            int remainChosen = (int) (3 * Math.random() + 1); // Kandidat wählt eine zufällige Tür und bleibt dabei
            int prize = (int) (3 * Math.random() + 1); // Preis einer beliebigen von 3 Türen zuweisen
            // Teile 1 Ziegen auf eine der übrigen 2 Türen auf
            do {
                zonk1 = (int) (3 * Math.random() + 1);
            }
            while (zonk1 == prize); // separate Tür

            int deviateChosen; // Kandidat wählt nach Preisgabe der ersten Ziege die andere Tür
            do {
                deviateChosen = (int) (3 * Math.random() + 1);
            }
            while (deviateChosen == remainChosen || deviateChosen == zonk1);
            // Weise letzter Tür die zweite Ziege zu
            do {
                zonk2 = (int) (3 * Math.random() + 1);
            }
            while (zonk2 == prize || zonk2 == zonk1); // separate Tür vom Preis und der ersten Ziege
            if (remainChosen == prize) j++;
            if (deviateChosen == prize) k++;
        }
        if (n > 0) return new double[] {(double) j / n, (double) k / n};
        else return new double[] {0, 0};
    }
    public static int[] dice(int n) {
        int j = 0; // Wie oft wurde eine 5 gewürfelt
        int k = 0; // Wie oft wurde eine 5 zweimal hintereinander gewürfelt
        for (int i = 1; i < n; i++) {
            int dice = (int) (6 * Math.random() + 1);
            if (dice == 5) {
                j++;
                if (j == 2) {
                    k++;
                    j--;
                }
            } else j = 0;
        }

        int l = 0; // Wie oft wurde eine 6 direkt im Anschluss an eine 5 gewürfelt
        for (int i = 1; i < n; i++) {
            int diceOne = (int) (6 * Math.random() + 1);
            int diceTwo = (int) (6 * Math.random() + 1);
            if (diceOne == 5 && diceTwo == 6) l++;
        }
        if (k > 0 && l > 0) return new int[] {n / k, n / l};
        else return new int[] {0, 0};
    }
    public static void main(String[] args) {
        int input = Integer.parseInt(args[1]);
        if (args[0].equals("pi")) {
            System.out.println(pi(input));
        } else if (args[0].equals("zonk")) {
            System.out.println(Arrays.toString(zonk(input)));
        } else if (args[0].equals("dice")) {
            System.out.println(Arrays.toString(dice(input)));
        }
    }
}