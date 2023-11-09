package Übung1;

public class HappyNumbers {
    public static boolean isHappy(int n) {
        int digitSum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            digit *= digit;
            digitSum += digit;
            n /= 10;
            if (n == 0 && digitSum > 9) {
                n = digitSum;
                digitSum = 0;
            }
        }
        n = digitSum;
        return n == 1;
    }
    public static int nextHappyNumber(int n) {
        int nInit = n;
        int digitSum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            digit *= digit;
            digitSum += digit;
            n /= 10;
            if (n == 0 && digitSum > 9) {
                n = digitSum;
                digitSum = 0;
            } else if (n == 0 && digitSum != 1) {
                n = ++nInit;
                digitSum = 0;
            } else if (n == 0) {
                break;
            }
        }
        return nInit;
    }
    public static void main(String[] args) {
        if (isHappy(1)) {
            System.out.print(isHappy(1));

        } else {
            System.out.print(isHappy(0));
        }
        /* Stichprobe Methode 1 (Testrahmen?):
            -1 → false;
            1 → true;
            4 → false;
            7 → true;
            → ermittelte Resultate entsprechen der Wahrheit
            */
        if (nextHappyNumber(0) < 1) {
            System.out.printf("%nDie fröhlichen Zahlen beginnen erst ab 1.");
        } else {
            System.out.printf("%nDie kleinste fröhliche Zahl <= n lautet %d", nextHappyNumber(0));
        }
        /* Stichprobe Methode 2:
            -1 → Die fröhlichen Zahlen beginnen erst ab 1;
            1 → Die kleinste fröhliche Zahl ≤ n lautet 1;
            4 → Die kleinste fröhliche Zahl ≤ n lautet 7;
            7 → Die kleinste fröhliche Zahl ≤ n lautet 7;
            → ermittelte Resultate entsprechen der Wahrheit
            */
    }
}