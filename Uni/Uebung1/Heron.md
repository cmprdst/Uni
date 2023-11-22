Algorithmus: Kubik_Wurzel_nach_Heron
Eingabe:
würfelvolumen (Wert, von der Uebung1.Kubikwurzel berechnet werden soll)
€ (Toleranzgrenze / Nachkommastellengenauigkeit)
Ausgabe:
a (~b, ~c) (Seitenlängen des Würfels → Uebung1.Kubikwurzel)
------------
(1) Deklariere und initialisiere die gegebenen Größen Würfelvolumen und Toleranzgrenze als Variable mit dem Dateityp "double"
(2) Deklariere 3 verschiedene Variablen vom Dateityp double für die 3 Seiten eines Würfels, initialisiere 2 davon mit
dem Wert 1 und die letzte mit dem Wert für das Würfelvolumen
(3) Solange die Differenz aus dem Würfelvolumen und der errechneten Uebung1.Kubikwurzel ^ 3 > Toleranzgrenze
(3.1) 1. Seitenlänge = Durchschnitt aus allen dreien
(3.2) 2. Seitenlänge = Durchschnitt = 1. Seitenlänge
(3.3) 3. Seitenlänge = Würfelvolumen / (1. Seitenlänge * 2. Seitenlänge)
(4) Verkünde das Ergebnis, indem eine der 3 Seitenlängen ausgegeben wird

public class cubicroot {
    public static void main(String [] args) {
        double volume = ?; // gegeben, > 0
        double a = 1, b = 1, c = volume; // Seitenlängen gesucht, > 0, Volumen = a * b * c = 1 * 1 * würfelvolumen
        double e = 0.00001; // Toleranzgrenze vorzugsweise im Bereich 0 < € < 1
        while (Math.abs(volume - a * a * a) > e) {
            a = (a + b + c) / 3; // Durchschnitt aus allen 3 Seitenlängen
            b = a; // selber Rechenschritt wie für a, daher abgekürzt
            c = volume / (a * b); // Anpassung von c, damit Ausgangswert für Volumen unverändert bleibt
        }
        System.out.printf("Die Uebung1.Kubikwurzel aus %f beträgt ca. %f", volume, a);
    }
}