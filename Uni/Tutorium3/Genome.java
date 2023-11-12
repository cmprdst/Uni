package Tutorium3;

import java.io.File;
import java.util.Scanner;

public class Genome {
    public static void main(String[] args) {

        String DNA = ""; // String zu Beginn deklarieren, um globalen Zugriff innerhalb der main-Methode zu gewähren.
        boolean validDNA = true; // Gensequenzierung nur durchführen, falls keine unerlaubten Zeichen gefunden werden

        try {
            if (args.length == 1) {
                // Textdatei auslesen und mit Scanner in String "DNA" überführen, falls möglich
                File ecoli = new File(args[0]);
                Scanner ecoliDNA = new Scanner(ecoli);
                DNA = ecoliDNA.nextLine();

                while (ecoliDNA.hasNextLine()) DNA += ecoliDNA.nextLine(); // Zeilenumbrüche berücksichtigen

            } else System.out.println("Bitte geben Sie lediglich das Verzeichnis mit der Textdatei an.");

        } catch (Exception e) {
            System.out.println("Geben Sie bitte das Verzeichnis mit der Textdatei an, die die DNA beinhält.");
        }

        for (int i = 0; i < DNA.length(); i++) {
            if (DNA.charAt(i) != 'a' && DNA.charAt(i) != 'c' && DNA.charAt(i) != 'g' && DNA.charAt(i) != 't') {
                System.out.println("In der DNA-Sequenz wurde mindestens ein ungültiges Zeichen gefunden oder nicht " +
                        "alle Buchstaben sind kleingeschrieben");
                System.out.printf("Min. eins der problematischen Zeichen ist '%s' an der Stelle %d.", DNA.charAt(i), i);
                validDNA = false;
                break;
            }
        }

        boolean geneFinished = true; // Festhalten, wann Genkodierung beendet wurde und ein Neues angefangen werden kann

        if (validDNA) {
            for (int i = 0; i + 3 < DNA.length(); ) {
                // Codon besteht immer aus 3 Buchstaben, obere Grenze i + 3 ist exklusiv, gehört also nicht dazu
                String Codon = DNA.substring(i, i + 3);

                if (geneFinished && Codon.equals("atg")) {
                    System.out.print("atg");
                    i += 3; // Indizes von "atg" werden übersprungen, da bei "print"-Befehl bereits berücksichtigt
                    geneFinished = false;
                } else i++; // Versuch nächstes Startcodon zu finden

                if (!geneFinished) {
                    switch (Codon) { // Startcodon da → 4 mögliche Fälle: 3 Stopcodons oder Erweiterung der Gensequenz
                        case "tag":
                            System.out.printf("tag%n");
                            i += 3; // siehe "atg"
                            geneFinished = true;
                            break;
                        case "tga":
                            System.out.printf("tga%n");
                            i += 3;
                            geneFinished = true;
                            break;
                        case "taa":
                            System.out.printf("taa%n");
                            i += 3;
                            geneFinished = true;
                            break;
                        default:
                            System.out.print(DNA.charAt(i++)); // Ausgabe der nächsten Base bis Stopcodon gefunden wird
                            break; // trotz fehlendem Stopcodon, da Codon mit neuen Indizes aktualisiert werden muss
                    }
                }
            }
        }
    }
}