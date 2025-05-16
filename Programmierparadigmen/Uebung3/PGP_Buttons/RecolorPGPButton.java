package Uebung3.PGP_Buttons;

import java.awt.*;

public class RecolorPGPButton extends PGPButton {
    public RecolorPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        float red = (float) Math.random();
        float green = (float) Math.random();
        float blue = (float) Math.random();
        float opacity = (float) Math.random();
        Color buttonColor = new Color(red, green, blue, opacity);
        super.setBackground(buttonColor);
    }
}
