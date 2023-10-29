public class Permutations {
    public static void main(String[] args) {
        int n = args.length;

        // für n = 1 nur ursprünglichen String ausgeben, kein Tausch möglich
        if (n == 1) for (String arg : args) System.out.print(arg);

        if (n > 1) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 1; i++) {
                    String memory = args[n - 1];
                    args[n - 1] = args[n - 2];
                    args[n - 2] = memory;
                    if (j != 0) System.out.print(" "); // zusätzliches Leerzeichen vor erster Permutation vermeiden
                    for (String arg : args) System.out.print(arg);
                }
                if (n > 2) {
                    for (int k = 0; k < 1; k++) {
                        String memory = args[n - 1];
                        args[n - 1] = args[n - 3];
                        args[n - 3] = memory;
                        System.out.print(" ");
                        for (String arg : args) System.out.print(arg);
                    }
                }
            }
        }
        System.out.println();
    }
}