package Uebung3.PGP_Buttons;

import java.sql.Timestamp;

public class PrintClickHistoryPGPButton extends PGPButton {
    public PrintClickHistoryPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        System.out.println("I was clicked at " + new Timestamp(System.currentTimeMillis()));
    }
}
