package Uebung1.PalindromeStack;

public class Palindrome {

  public static boolean isPalindrome(String text) {
    if (text.isEmpty()) { System.out.println("Empty String cannot be a palindrome."); return false; }

    char[] lowerCaseLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    Stack<Character> baseText = new Stack<>();
    Stack<Character> reversedText = new Stack<>();

    // String ohne Leer-, Sonder- und Satzzeichen als Kleinbuchstaben in Stack überführen
    for (int i = 0; i < text.length(); i++) {
      for (char lowerCaseLetter : lowerCaseLetters) {
        if (text.toLowerCase().charAt(i) == lowerCaseLetter) { baseText.push(text.toLowerCase().charAt(i)); break; }
      }
    }

    if (baseText.is_empty()) { System.out.println("No valid characters (letters) were found."); return false; }

    // String umgekehrt in Stack überführen
    for (int i = text.length() - 1; i >= 0; i--) {
      for (char lowerCaseLetter : lowerCaseLetters) {
        if (text.toLowerCase().charAt(i) == lowerCaseLetter) { reversedText.push(text.toLowerCase().charAt(i)); break; }
      }
    }

    // Vergleich des letzten chars beider Stacks, falls gleich Entfernung und Wiederholung bis Stack leer, sonst Abbruch
    while (!baseText.is_empty() && baseText.top().equals(reversedText.top())) { baseText.pop(); reversedText.pop(); }
    return baseText.is_empty();
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("Reliefpfeiler"));
    System.out.println(isPalindrome("Lagerregal"));
    System.out.println(isPalindrome("Ein Esel lese nie."));
    System.out.println(isPalindrome("Na, Fakir, Paprika-Fan?"));
    System.out.println(isPalindrome("Eine Horde bedrohe nie!"));
    System.out.println(isPalindrome("Madam"));
    System.out.println(isPalindrome("Marktkram"));
    System.out.println(isPalindrome("Gurken hol ohne Krug!"));
    System.out.println(isPalindrome("O, Streit irritiert so!"));
    System.out.println();
    System.out.println(isPalindrome(""));
    System.out.println(isPalindrome("1"));
  }
}