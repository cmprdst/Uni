package Uebung1;

public class TailRecursion {

    public static int pow2(int n) {
        if (n < 0) { System.out.print("Method only accepts n >= "); return 0; }
        return pow2_auxiliary(n, 0, 1);
    }

    private static int pow2_auxiliary(int n, int i, int result) {
        return i == n ? result : pow2_auxiliary(n, ++i, 2 * result);
    }

    public static int sumFactors(int n) {
        if (n < 0) { System.out.print("Method only accepts n >= "); return 0; }
        return sumFactors_auxiliary(n, 1, 0);
    }

    private static int sumFactors_auxiliary(int n, int i, int result) {
        if (i > n / 2) return result;
        else if (n % i == 0) result += i;
        return sumFactors_auxiliary(n, ++i, result);
    }

    public static void main(String[] args) {
        System.out.println(pow2(-3));
        System.out.println(pow2(5));
        System.out.println(pow2(10));
        System.out.println();
        System.out.println(sumFactors(-75));
        System.out.println(sumFactors(6));
        System.out.println(sumFactors(36));
    }
}