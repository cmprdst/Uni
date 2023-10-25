public class Statistics {

    public static double sqrt(double x) {

        double a = 1;
        double e = 0.00001;
        double b = x / a;

        while (a - b > e || a - b < -e) {
            a = (a + b) / 2;
            b = x / a;
        }
        return a;
    }

    public static void main(String[] args) {
        // Transformiere Eingabe zu int-Array
        int n = args.length;
        int[] ints = new int[n];
        int j;

        for (j = 0; j < n; j++) {
            int i = Integer.parseInt(args[j]);
            ints[j] = i;
        }
        // Ordne die Zahlen im int-Array nach ihrer Größe
        int memory;
        int k;

        for (k = 0; k < n - 1; k++) {
            while (j < n - 1) {
                if (ints[j] > ints[j + 1]) {
                    memory = ints[j + 1];
                    ints [j + 1] = ints[j];
                    ints[j] = memory;
                }
                j++;
            }
            j = 0;
        }
        // Summe
        int sum = 0;
        for (j = 0; j < n; j++) {
            sum += ints[j];
            if (j + 1 == n) {
                System.out.printf("Summe: %d%n", sum);
            }
        }
        // Mittelwert
        double average = (double) sum / n;
        System.out.printf("Mittelwert: %f%n", average);
        // Varianz
        double variance = 0;
        double sumDiffSquare = 0;
        for (j = 0; j < n; j++) {
            sumDiffSquare += (ints[j] - average) * (ints[j] - average);
            if (j == n - 1) {
                variance = sumDiffSquare / (1 - n);
                variance = (variance >= 0 ? variance : -variance);
            }
        }
        System.out.printf("Varianz: %f%n", variance);
        // Standardabweichung
        double stanDev = sqrt(variance);
        System.out.printf("Standardabweichung: %f%n", stanDev);
        // Histogram
        j = 0;
        k = 1;
        while (j < n - 1) {
            while (ints[j] == ints[j+1]) {
                k++;
                if (j < n - 2) j++;
                else break;
            }
            System.out.print(ints[j] + ": ");
            for (int l = 0; l < k; l++) {
                System.out.print('*');
            }
            System.out.println(" ");
            j++;
            k = 1;
        }
        if (ints[n-2] != ints[n-1]) {
            System.out.println(ints[n - 1] + ": *");
        }
    }
}