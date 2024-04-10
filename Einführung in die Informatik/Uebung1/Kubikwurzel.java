package Uebung1;

public class Kubikwurzel {
    public static void main(String[] args) {
        double volume = 10.123;
        double a = 1, b = 1, c = volume;
        double e = 0.00000001;
        while (Math.abs(volume - a * a * a) > e) {
            a = (a + b + c) / 3;
            b = a;
            c = volume / (a * b);
        }
        System.out.printf("Die Übung1.Kubikwurzel aus %f beträgt ca. %f", volume, a);
    }
}