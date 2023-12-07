package Uebung8.ChristmasPresents;

public abstract class Present {
    static int counter = 0;

    protected Present() { counter++; }

    public static int getCounter() { return counter; }

    abstract double surface();

    double computePaperSize() {
        double paperNeeded = surface() * 1.6;
        double decimalPlaces = paperNeeded - (int) paperNeeded;
        // aufrunden auf den nächsten halben Quadratmeter
        if (decimalPlaces > 0.5) paperNeeded += (1 - decimalPlaces);
        else if (decimalPlaces > 0) paperNeeded += (0.5 - decimalPlaces);

        return paperNeeded;
    }
}