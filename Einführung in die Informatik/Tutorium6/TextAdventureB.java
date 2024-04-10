package Tutorium6;
/*

 Übernommen von meinem Kommilitonen Mark

 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class TextAdventureB {
    public static void main(String[] args) {
        Room firstRoom = new FirstRoom();
        Room secondRoom = new SecondRoom();
        Room thirdRoom = new ThirdRoom();
        Room fourthRoom = new FourthRoom();
        Room fifthRoom = new FifthRoom();

        new File("keycheck.txt");
        try {
            FileWriter inv = new FileWriter("keycheck.txt");
            inv.write("0");
            inv.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        firstRoom.setNextRooms(secondRoom, thirdRoom);
        secondRoom.setNextRooms(firstRoom,fourthRoom, fifthRoom);
        thirdRoom.setNextRoom(firstRoom);
        fourthRoom.setNextRoom(secondRoom);
        fifthRoom.setNextRoom(secondRoom);

        Scanner inp = new Scanner(System.in);
        System.out.println("Type \"start\" to Start");
        String start = inp.nextLine();
        if (!start.toLowerCase().equals("start")) {
            do {
                System.out.println("Type \"start\" to Start");
                start = inp.nextLine();
            } while (!start.toLowerCase().equals("start"));
        }
        firstRoom.enter();
        inp.close();
    }
}