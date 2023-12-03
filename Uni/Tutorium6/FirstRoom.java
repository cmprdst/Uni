package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.util.Scanner;

public class FirstRoom extends Room {
    @Override
    public void enter() {
        System.out.println("You are in the first room.");
        System.out.println("You see two doors.");

        Scanner inp = new Scanner(System.in);
        System.out.println("Type 2 To enter the Second room, 3 to enter the Third room.");
        String start = inp.nextLine();
        if (!start.toLowerCase().equals("2") && !start.toLowerCase().equals("3")) {
            do {
                System.out.println("Invalid Input!\nType 2 To enter the Second room, 3 to enter the Third room.");
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("2") && !start.toLowerCase().equals("3"));
        }
        if (start.toLowerCase().equals("2")) {
            nextRoom1.enter();
        } else {
            nextRoom2.enter();
        }
        inp.close();
    }
}