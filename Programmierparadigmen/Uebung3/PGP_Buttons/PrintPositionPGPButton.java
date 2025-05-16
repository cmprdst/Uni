package Uebung3.PGP_Buttons;

public class PrintPositionPGPButton extends PGPButton {
	public PrintPositionPGPButton(String label) {
		super(label);
	}
	
	@Override
	public void click() {
		System.out.println("I'm the button at (" + super.getLocation().getX() + ", " + super.getLocation().getY() + ").");
	}
}

