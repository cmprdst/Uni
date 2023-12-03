package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThirdRoom extends Room {

    @Override
    public void enter() {
        System.out.println("You are in the third room.");
        Scanner inp = new Scanner(System.in);

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
            System.out.println("There is nothing else here.Type 1 to go back to Room 1.");
        } else {
            System.out.println("There is a key on the table. Type \"key\" to pick up the key and go back to room 1. Type 1 to go back to Room 1.");
        }

        String start = inp.nextLine();

        if (!start.toLowerCase().equals("key") && !start.toLowerCase().equals("1")) {
            do {
                if (data.equals("1")) {
                System.out.println("Invalid input!\nThere is nothing else here.Type 1 to go back to Room 1.");
            } else {
                System.out.println("Invalid input!\nThere is a key on the table. Type \"key\" to pick up the key and go back to room 1. Type 1 to go back to Room 1.");
            }
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("key") && !start.toLowerCase().equals("1"));
        }
        if (start.toLowerCase().equals("key")) {

            if (data.equals("0")) {
                System.out.println("You pick up the key.");
                try {
                    FileWriter inv = new FileWriter("keycheck.txt");
                    inv.write("1");
                    inv.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("You already picked the key up!");
            }
            nextRoom1.enter();
        } else {
            nextRoom1.enter();
        }
        inp.close();
    }
}