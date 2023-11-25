package Tutorium5;

public class Encryption {

    private final char[] lowercaseLetters =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private final char[] capitalLetters =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public String encrypt(String normalText) { return encrypt("rot13", normalText); }

    public String encrypt(String encryptType, String normalText) {

        String encrypted = "";
        int rotationValue; // X in rotX

        // checks for correct syntax of encryptType
        if (encryptType.toLowerCase().startsWith("rot")) {
            try {
                rotationValue = Integer.parseInt(encryptType.substring(3)) % 26;
                if (rotationValue < 0) rotationValue += 26;
            }
            catch (Exception e) {
                return "Could not determine rotation number.";
            }
        } else return "Unknown encryption method or invalid input.";

        if (rotationValue == 0) return normalText;

        // rotation algorithm
        for (int i = 0; i < normalText.length(); i++) {
            boolean capitalLetter = false;
            boolean lowercaseLetter = false;
            // add rotated capital letter to String encrypted
            for (int j = 0; j < capitalLetters.length; j++) {
                if (normalText.charAt(i) == capitalLetters[j]) {
                    encrypted += capitalLetters[(j + rotationValue) % 26];
                    capitalLetter = true;
                    break;
                }
            }
            // add rotated lowercase letter to String encrypted
            for (int j = 0; j < lowercaseLetters.length; j++) {
                if (normalText.charAt(i) == lowercaseLetters[j]) {
                    encrypted += lowercaseLetters[(j + rotationValue) % 26];
                    lowercaseLetter = true;
                    break;
                }
            }
            // if neither familiar capital nor lowercase letter detected -> add unchanged character to String encrypted
            if (!capitalLetter && !lowercaseLetter) encrypted += normalText.charAt(i);
        }
        return encrypted;
    }

    public String decrypt(String encryptedText) {

        int[] charCounter = new int[lowercaseLetters.length];
        int indexWithHighestValue = 0;

        // counts occurrences of characters in String encryptedText (all characters treated as lowercase)
        for (int i = 0; i < encryptedText.length(); i++) {
            for (int j = 0; j < lowercaseLetters.length; j++) {
                if (encryptedText.toLowerCase().charAt(i) == lowercaseLetters[j]) charCounter[j]++;
            }
        }
        // determines most common character in String encryptedText
        for (int i = 0; i < charCounter.length; i++) {
            if (charCounter[i] > charCounter[indexWithHighestValue]) indexWithHighestValue = i;
        }
        // 'e' already most common? -> String encryptedText probably not encrypted, otherwise rotate String
        // encryptedText by deviation of indexWithHighestValue from 4 (index of 'e')
        if (indexWithHighestValue == 4) return encryptedText;
        else return encrypt("rot" + (4 - indexWithHighestValue), encryptedText);
    }

    public static void main(String[] args) {

        Encryption encryption = new Encryption();

        // checks for correct syntax of terminal input, otherwise provides assistance for proper syntax
        if (args.length == 2 && args[0].toLowerCase().equals("encrypt")) {
            System.out.println(encryption.encrypt(args[1]));
        } else if (args.length == 2 && args[0].toLowerCase().equals("decrypt")) {
            System.out.println(encryption.decrypt(args[1]));
        } else if (args.length == 3 && args[0].toLowerCase().equals("encrypt")) {
            System.out.println(encryption.encrypt(args[1], args[2]));
        } else if (args.length == 1 && args[0].toLowerCase().equals("help")) {
            System.out.println("How to access the 'Tutorium5.Encryption' methods via terminal (text in quotation marks!):");
            System.out.println("java Tutorium5.Encryption encrypt 'text' -> encrypts a String with the 'ROT13' method.");
            System.out.println("java Tutorium5.Encryption encrypt 'text' 'rotX' -> encrypts a String with the 'ROTX' " +
                    "method where X can be any whole number but the amount of rotations is constrained by the amount " +
                    "of letters so only X % 26 (or if X < 0, X % 26 + 26) rotations will actually take place.");
            System.out.println("java Tutorium5.Encryption decrypt 'text' -> tries to decrypt a String with the 'ROTX' method " +
                    "by rotating the encrypted text by X (1 <= X <= 25) so that the letter 'e' is the most occurring " +
                    "one in the text (because it is the most frequently appearing one in the German language).");
        } else System.out.println("You can ask for help by typing 'java Tutorium5.Encryption help' when accessed via terminal.");

//         decryption asked for in task
//
//         System.out.println(encryption.decrypt(("Pxgg wn axktnlzxyngwxg atlm, ptl wbxlxk Mxqm uxwxnmxm, atlm wn " +
//                "xgmpxwxk lxak obxex Fhxzebvadxbmxg tnlikhubxkm ngw wbk ynxgyngwsptgsbzfte Fnxee tgzxznvdm. " +
//                "Hwxk wn atlm wbx spxbmx Mxbetnyztux kbvambz zxehxlm.")));
//
//         decryption returns
//
//         "Wenn du herausgefunden hast, was dieser Text bedeutet, hast du entweder sehr viele Moeglichkeiten
//         ausprobiert und dir fuenfundzwanzigmal Muell angeguckt. Oder du hast die zweite Teilaufgabe richtig geloest."
    }
}