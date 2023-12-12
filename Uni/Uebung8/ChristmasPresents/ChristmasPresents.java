package Uebung8.ChristmasPresents;

public class ChristmasPresents {

	static final double price = 1.67; // € / m²

	public static void main(String[] args) {
		Present BottleOfWine1 = new Cylinder(0.3, 0.03);
		Present BottleOfWine2 = new Cylinder(0.7, 0.07);
		Present GiftBasket1 = new Ball(0.4);
		Present GiftBasket2 = new Ball(0.45);
		Present GardenGnome = new Cylinder(0.1, 0.1);
		Present TeddyBear = new Cylinder(1.2, 0.3);
		Present ComputerGame1 = new Cuboid(0.2, 0.1, 0.01);
		Present ComputerGame2 = new Cuboid(0.25, 0.15, 0.015);
		Present ComputerGame3 = new Cuboid(1, 0.6, 0.1);

		System.out.println(BottleOfWine1.computePaperSize() + "m², " + BottleOfWine1.computePaperSize() * price + "€");
		System.out.println(BottleOfWine2.computePaperSize() + "m², " + BottleOfWine2.computePaperSize() * price + "€");
		System.out.println(GiftBasket1.computePaperSize() + "m², " + GiftBasket1.computePaperSize() * price + "€");
		System.out.println(GiftBasket2.computePaperSize() + "m², " + GiftBasket2.computePaperSize() * price + "€");
		System.out.println(GardenGnome.computePaperSize() + "m², " + GardenGnome.computePaperSize() * price + "€");
		System.out.println(TeddyBear.computePaperSize() + "m², " + TeddyBear.computePaperSize() * price + "€");
		System.out.println(ComputerGame1.computePaperSize() + "m², " + ComputerGame1.computePaperSize() * price + "€");
		System.out.println(ComputerGame2.computePaperSize() + "m², " + ComputerGame2.computePaperSize() * price + "€");
		System.out.println(ComputerGame3.computePaperSize() + "m², " + ComputerGame3.computePaperSize() * price + "€");
		System.out.println(Present.getCounter());
	}
}