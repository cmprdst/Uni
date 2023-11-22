package Uebung0;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wie lautet die erste Zahl?: ");
        int x = scan.nextInt();
        System.out.print("Und durch welche Zahl soll sie dividiert werden?: ");
        int y = scan.nextInt();
        int x_initial = x;
        int y_initial = y;
        int rest;
        int times_subtracted;
        if (y == 0) {
            System.out.print("Die Übung0.Division durch 0 ist nicht definiert.");
        } else if (x == 0) {
            System.out.print("Das Ergebnis ist 0.");
        } else if (x < y && x > 0) {
            rest = x;
            System.out.printf("Die Übung0.Division von %d durch %d ergibt 0 mit einem Rest von %d.", x, y, rest);
        } else if (y < x && x < 0) {
            rest = -x;
            System.out.printf("Die Übung0.Division von %d durch %d ergibt 0 mit einem Rest von %d.", x, y, rest);
        } else {
            if (x < 0 && y < 0) {
                x = -x;
                y = -y;
            } else if (x < 0) {
                x = -x;
            } else if (y < 0) {
                y = -y;
            }
            rest = x - y;
            if (rest < y) {
                times_subtracted = 1;
            } else {
                times_subtracted = 0;
            }
            while (rest >= y) {
                rest = x - y;
                x = rest;
                times_subtracted++;
            }
            if (x_initial > 0 && y_initial > 0 || x_initial < 0 && y_initial < 0) {
                System.out.printf("Das Ergebnis der Übung0.Division von %d durch %d lautet %d mit einem Rest von %d.", x_initial, y_initial, times_subtracted, rest);
            } else {
                times_subtracted = -times_subtracted;
                System.out.printf("Das Ergebnis der Übung0.Division von %d durch %d lautet %d mit einem Rest von %d.", x_initial, y_initial, times_subtracted, rest);
            }
        }
    }
}