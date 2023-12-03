package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FourthRoom extends Room {
    @Override
    public void enter() {
        System.out.println("You are in the fourth room.");
        System.out.println("There is a locked door.");

        Scanner inp = new Scanner(System.in);
        System.out.println("Type 2 To go back to the second room, or \"open\" to try and open this door.");
        String start = inp.nextLine();

        if (!start.toLowerCase().equals("2") && !start.toLowerCase().equals("open")) {
            do {
                System.out.println("Invalid Input!\nType 2 To go back to the second room, or \\\"open\\\" to try and open this door.");
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("2") && !start.toLowerCase().equals("open"));
        }
        if (start.toLowerCase().equals("2")) {
            nextRoom1.enter();
        } else {
            String data = "";
            try {
                File myObj = new File("keycheck.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                }
                myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
            if (data.equals("1")) {
                File file2 = new File("keycheck.txt");
                file2.delete();
                System.out.println("You use the key to unlock the door.");
                System.out.println("Congratulations! You have won!");
            } else {
                System.out.println("The door is locked. You need to find a key. Type 2 to go back to the second room.");
                start = inp.nextLine();
                if (!start.toLowerCase().equals("2")) {
                    do {
                        System.out.println("Invalid Input!\nThe door is locked. You need to find a key. Type 2 to go back to the second room.");
                        start = inp.nextLine();
                    } while (!start.toLowerCase().equals("2"));
                }
                nextRoom1.enter();
            }
        }
        inp.close();
    }
}