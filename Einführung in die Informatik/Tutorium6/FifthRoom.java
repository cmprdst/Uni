package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.util.Scanner;

public class FifthRoom extends Room {
    @Override
    public void enter() {
        Scanner inp = new Scanner(System.in);
        System.out.println("You are in the fifth room. There is Nothing here. Type 2 to go back to Room 2.");
        String start = inp.nextLine();
        if (!start.toLowerCase().equals("2")) {
            do {
                System.out.println("Invalid Input!\nYou are in the fifth room. There is Nothing here. Type 2 to go back to Room 2.");
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("2"));
        }
        if (start.toLowerCase().equals("2")) {
            nextRoom1.enter();
        }
        inp.close();
    }
}