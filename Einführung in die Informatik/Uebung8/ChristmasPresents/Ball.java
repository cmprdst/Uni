package Uebung8.ChristmasPresents;

public class Ball extends Present {
    private double radius = 1; // in meters

    Ball(double radius) { this.radius = radius > 0 ? radius : 0; }

    public String toString() {
        return radius == 0 ? "A radius <= 0 is invalid." : "A ball with a " + radius + " meter radius.";
    }

    @Override
    public double surface() { return 4 * Math.PI * radius * radius; }
}