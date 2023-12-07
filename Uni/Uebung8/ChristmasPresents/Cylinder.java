package Uebung8.ChristmasPresents;

public class Cylinder extends Present {
    private double height = 1; // in meters
    private double radius = 1; // in meters

    Cylinder(double height, double radius) {
        if (height <= 0 || radius <= 0) { this.height = 0; this.radius = 0; }
        else { this.height = height; this.radius = radius; }
    }
	
    public String toString() {
        if (height == 0 || radius == 0) return "Height or radius of 0 or less is invalid.";
        else return "A cylinder with a " + height + " meter height and a " + radius + " meter radius.";
    }
    
    @Override
    public double surface() { return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height; }
}