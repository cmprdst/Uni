package Uebung5.Funct;

/**
 * Kontext: alles, was außerhalb des aktuellen Funktionsaufrufs eine Rolle spielt ("globale Umstände eines Programms")
 * → z. B. globale / Systemvariablen, Dateien ...
 * Seiteneffekt: alles, wodurch das Programm den Kontext beeinflusst
 * → Einfluss auf eigenen oder Kontext anderer Programme durch Veränderung globaler / Systemvariablen, Dateien ...
 */

public class Functional {
	private static String printNumber() {
		return printNumber(0);
	}
	
	private static String printNumber(int number) {
		return printNumber(number, "DEC");
	}
	
	private static String printNumber(int printNumber, String numeralSystem) {
		return switch (numeralSystem) {
			case "BIN" -> "0b" + Integer.toBinaryString(printNumber);
			case "OCT" -> "0o" + Integer.toOctalString(printNumber);
			case "DEC" -> Integer.toString(printNumber);
			case "HEX" -> "0x" + Integer.toHexString(printNumber);
			default -> "???";
		};
	}
	
	public static void main(String[] args) {
		System.out.println(printNumber());
		System.out.println(printNumber(1337, "BIN"));
		System.out.println(printNumber(1337));
		System.out.println(printNumber(1337, "HEX"));
		System.out.println(printNumber(1337, "OCT"));
	}
}
