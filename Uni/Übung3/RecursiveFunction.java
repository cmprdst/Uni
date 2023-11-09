package Übung3;

/**************************************
 x = -3, y = -2 / x = 3, y = -2 → Algorithmus terminiert (allgemein für y < 0) nicht
 x = -3, y = 2 → y = 0 → x = -5 (wenn x < 0 → x < y)
 x = 3, y = 2 → y = 0 → x = 1 (wenn x > 0 → x > y)
 x = 2, y = 2 → y = 0 → x = 0 (wenn x = 0 → x = y)

 → Allgemein gibt der Algorithmus nach Termination für y >= 0 an, ob und um wie viel x kleiner oder größer als y ist.
***********************************************/
public class RecursiveFunction {
    public static int rec(int x, int y) {
        if (x == 0 && y == 0) return 0;
        else if (x != 0 && y == 0) return x; // Terminalbedingung
        else if (y < 0) return rec(x + 1, y + 1);
        else return rec(x - 1, y - 1);
    }
    public static int iter(int x, int y) {
        if (x == 0 && y == 0) return 0;
        while (y != 0) {
            if (y < 0) { x += 1; y += 1; }
            else { x -= 1; y -= 1; }
        }
        return x;
    }
   public static void main(String[] args) {
     System.out.println(rec(-3, -2));
     System.out.println(rec(3, -2));
     System.out.println(rec(-3, 2));
     System.out.println(rec(3, 2));
     System.out.println(rec(2, 2));
     System.out.println();
     System.out.println(iter(-3, -2));
     System.out.println(iter(3, -2));
     System.out.println(iter(-3, 2));
     System.out.println(iter(3, 2));
     System.out.println(iter(2, 2));
   }
}