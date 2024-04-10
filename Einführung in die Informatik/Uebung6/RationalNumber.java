package Uebung6;

public class RationalNumber implements Comparable<RationalNumber> {
    //---------------------------------------------------------------------------//
    private int num = 0;
    private int denom = 1;
    //---------------------------------------------------------------------------//
    public RationalNumber() {} // use case unklar
    //---------------------------------------------------------------------------//
    public RationalNumber(int n, int d) {
        if (d == 0) this.denom = 0; // Ruft in toString()-Methode Fehlermeldung hervor
        else {
            this.num = (n > 0 && d < 0) || (n < 0 && d < 0) ? -n : n; // für negativen Bruch "-" im Zähler festhalten
            this.denom = d < 0 ? -d : d; // Nenner soll immer positiv sein

            int r = this.num < 0 ? -this.num : this.num; // folgende Schleife setzt positives r voraus
            int s = this.denom;

            while (r != 0) { // Berechnung des größten gemeinsamen Teilers mithilfe des euklidischen Algorithmus
                if (r > s) {
                    int memory = r;
                    r = s;
                    s = memory;
                } else s = s - (s / r) * r;
            }
            this.num /= s; // Bruch kürzen
            this.denom /= s;
        }
    }
    //---------------------------------------------------------------------------//
    public int getNum() { return this.num; }
    //---------------------------------------------------------------------------//
    public int getDenom() { return this.denom; }
    //---------------------------------------------------------------------------//
    public int compareTo(RationalNumber n) {
        if (this.denom != 0 && n.getDenom() != 0) {
            // Brüche durch Multiplikation des Zählers und Nenners mit Nenner des jeweils anderen Bruchs auf gleichen
            // Hauptnenner bringen, Zähler vergleichen, Ergebnis für 2 negative Brüche umkehren
            if (this.num < 0 && n.getNum() < 0) {
                return -Integer.compare(this.num * n.getDenom(), n.getNum() * this.denom);
            } else return Integer.compare(this.num * n.getDenom(), n.getNum() * this.denom);
        } else {
            System.out.print("Undefined value for denominator = ");
            return 0;
        }
    }
    //---------------------------------------------------------------------------//
    public RationalNumber add(RationalNumber r) {
        if (this.denom != 0 && r.getDenom() != 0) {
            // ähnlich zur compareTo()-Methode Brüche angleichen, Zähler addieren
            return new RationalNumber(this.num * r.getDenom() + r.getNum() * this.denom, this.denom * r.getDenom());
        } else return new RationalNumber(0, 0); // Fehlermeldung in toString()-Methode
    }
    //---------------------------------------------------------------------------//
    public RationalNumber div(RationalNumber r) {
        if (this.denom != 0 && r.getDenom() != 0)
            // Division von Brüchen = Multiplikation des Dividenden mit Reziproke des Divisors
            return new RationalNumber(this.num * r.getDenom(), this.denom * r.getNum());
        else return new RationalNumber(0, 0); // Fehlermeldung in toString()-Methode
    }
    //---------------------------------------------------------------------------//
    public String toString() {
        if (this.denom == 0) return "Division by 0 is undefined.";
        else if (this.num == 0) return "0";
        else if (this.num % this.denom == 0) return "" + this.num / this.denom;
        else return this.num + "/" + this.denom;
    }
    //---------------------------------------------------------------------------//
    public static void main(String[] args) {
        RationalNumber test0 = new RationalNumber(0, 0); // returns "Division by 0 is undefined."
        RationalNumber test1 = new RationalNumber(0, 40); // returns 0
        RationalNumber test2 = new RationalNumber(25, 0); // returns "Division by 0 is undefined."
        RationalNumber test3 = new RationalNumber(25, 40); // returns 5/8
        RationalNumber test4 = new RationalNumber(-32, 40); // returns -4/5
        RationalNumber test5 = new RationalNumber(75, -50); // returns -3/2
        RationalNumber test6 = new RationalNumber(-200, -40); // returns 5

        System.out.println(test0.compareTo(test2));
        System.out.println(test3.compareTo(test2));
        System.out.println(test2.compareTo(test3));
        System.out.println(test3.compareTo(test4));
        System.out.println(test3.compareTo(test3));
        System.out.println(test4.compareTo(test5));
        System.out.println();
        System.out.println(test0.add(test2));
        System.out.println(test3.add(test2));
        System.out.println(test2.add(test3));
        System.out.println(test3.add(test4));
        System.out.println(test3.add(test3));
        System.out.println(test4.add(test5));
        System.out.println();
        System.out.println(test0.div(test2));
        System.out.println(test3.div(test2));
        System.out.println(test2.div(test3));
        System.out.println(test3.div(test4));
        System.out.println(test3.div(test3));
        System.out.println(test4.div(test5));
    }
}