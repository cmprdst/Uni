package Uebung8.ChristmasPresents;

public class Cuboid extends Present {
    private double length = 1; // in meters
    private double width = 1; // in meters
    private double height = 1; // in meters

    Cuboid(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) { this.length = 0; this.width = 0; this.height = 0; }
        else { this.length = length; this.width = width; this.height = height; }
    }

    public String toString() {
        if (length == 0 || width == 0 || height == 0) return "Length, width or height of 0 or less is invalid.";
        else return "A Cuboid with a " +length+ " meter length, " +width+ " meter width and " +height+ " meter height.";
    }

    @Override
    public double surface() { return 2 * (length * width + length * height + width * height); }
}