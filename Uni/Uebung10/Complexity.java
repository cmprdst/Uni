package Uebung10;

public class Complexity {

	private static String unitOfTime(double x) {
		if (x < 0) return "x must be greater than or equal to 0!";
		else if (x < 1000) return "ns";
		else if (x < 1_000_000) return "μs";
		else if (x < 1_000_000_000) return "ms";
		else return "s";
	}

	private static double timeAdjustment(double x) { while (x > 999) x /= 1000; return x; }

	private static String needsRounding(double x) { return x > 999 ? ".3" : ".0"; }

	public static void main(String[] args) {
		System.out.println("Tabelle der Komplexitäten");
		System.out.println("ein Rechenschritt: 1 Nanosekunde (10^(-9)sec)");
		System.out.printf("%s%10s%10s%10s%13s%13s%20s%n", // %10s → String mit 10 Zeichen, rechtsbündig, links mit Leerzeichen aufgefüllt
            "k", "ldn", "n", "n*ldn", "n^2", "n^3", "2^n");

		final int[] SPACES = {10, 10, 10, 13, 13, 20};

		for (int k = 1; k < 10; k++) {
			System.out.print(k);

			System.out.printf("%" + (SPACES[0] - unitOfTime(k).length()) + "d" + unitOfTime(k), k); // ldn = k

			int n = 1;
			for (int l = 1; l <= k; l++) n *= 2;
			System.out.printf("%" + (SPACES[1] - unitOfTime(n).length()) + "d" + unitOfTime(n), n);

			System.out.printf("%" + (SPACES[2] - unitOfTime(n * k).length()) + needsRounding(n * k) + "f" +
					unitOfTime(n * k), timeAdjustment(n * k));

			System.out.printf("%" + (SPACES[3] - unitOfTime(n * n).length()) + needsRounding(n * n) + "f" +
					unitOfTime(n * n), timeAdjustment(n * n));

			System.out.printf("%" + (SPACES[4] - unitOfTime(n * n * n).length()) + needsRounding(n * n * n) + "f" +
					unitOfTime(n * n * n), timeAdjustment(n * n * n));

			if (k <= 5) {
				long m = 2;
				for (int l = 1; l <= k; l++) m *= m;
				System.out.printf("%" + (SPACES[5] - unitOfTime(m).length()) + needsRounding(m) + "f" +
						unitOfTime(m), timeAdjustment(m));
			}
			if (k > 5) System.out.printf("%" + SPACES[5] + "s", "value too large");

			System.out.println();
		}
	}
}