package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.util.Scanner;

public class SecondRoom extends Room {
    @Override
    public void enter() {
        System.out.println("You are in the second room.");
        System.out.println("There are two more doors.");

        Scanner inp = new Scanner(System.in);
        System.out.println("Type 1 To go back to the First room, 4 to enter the fourth room and 5 to enter the Fifth room.");
        String start = inp.nextLine();
        if (!start.toLowerCase().equals("1") && !start.toLowerCase().equals("4") && !start.toLowerCase().equals("5")) {
            do {
                System.out.println("Invalid Input!\nType 1 To go back to the First room, 4 to enter the fourth room and 5 to enter the Fifth room.");
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("1") && !start.toLowerCase().equals("4") && !start.toLowerCase().equals("5"));
        }
        if (start.toLowerCase().equals("1")) {
            nextRoom1.enter();
        } else if (start.toLowerCase().equals("4")) {
            nextRoom2.enter();
        } else {
            nextRoom3.enter();
        }
        inp.close();
    }
}