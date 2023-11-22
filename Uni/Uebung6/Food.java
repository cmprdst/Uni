package Uebung6;

import java.util.Arrays;

public class Food implements Comparable<Food> {

    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};

    // Zugriff in anderen Methoden ermöglichen aber nicht von außerhalb erlauben
    private String type;
    private int calories;

    public Food(String type, int calories) {
        try {
            int i = 0;
            while (!type.equals(TYPES[i])) { // Falls keine Übereinstimmung gefunden, OutOfBoundsException "hervorrufen"
                i++;
            }
            this.type = type;
            if (calories > 0) this.calories = calories;
            else System.out.println("Calories can't be less than 1.");
        } catch (Exception e) {
            System.out.println("Invalid type!");
        }
    }

    public String toString() { return "'" + getType() + "' with " + getCalories() + " calories"; }

    public int compareTo(Food o) { // Integer.compare: this < o -> -1, this > o -> 1, this = o -> 0
        return Integer.compare(this.type.length() * this.calories, o.type.length() * o.calories);
    }

    public String getType() { return this.type; }

    public int getCalories() { return this.calories; }

    public static Food[] createSortedRandomList(int n) {
        try {
            Food[] randomFoods = new Food[n];
            for (int i = 0; i < randomFoods.length; i++) {
                // zufälliger Typ aus Indizes 0 bis TYPES.length - 1, da Math.random von 0 bis 1 (jeweils exklusiv)
                String randomType = TYPES[(int) (TYPES.length * Math.random())]; // Abrundung durch explizites (int)
                int randomCalories = (int) (500 * Math.random() + 1); // 1 ≤ Kalorien ≤ 500 (500 selbst gewählt)
                randomFoods[i] = new Food(randomType, randomCalories);
            }
            Arrays.sort(randomFoods); // Aus Aufgabenstellung
            return randomFoods;
        }
        catch (Exception e) {
            System.out.println("Input must be greater than or equal to 0."); // minimal leere Liste
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createSortedRandomList(20)));
    }
}