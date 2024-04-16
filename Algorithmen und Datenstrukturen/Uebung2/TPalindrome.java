package Uebung2;

import aud.Stack;

public class TPalindrome {
  public static boolean isTPalindrome(String text) {
    if (text.isEmpty()) return true;

    Stack<Character> textReversed = new Stack<>();
    Stack<Character> base = new Stack<>();

    for (int i = text.length() - 1; i >= 0; i--) textReversed.push(text.charAt(i));

    while (!textReversed.is_empty() && textReversed.top() != '(') base.push(textReversed.pop());

    if (textReversed.is_empty()) return checkWithoutParentheses(base);
    else return checkWithParentheses(base, textReversed);
  }

  private static boolean checkWithParentheses(Stack<Character> base, Stack<Character> appendage) {
    Stack<Character> toBeChecked = new Stack<>();

    if (!appendage.is_empty() && appendage.top() == '(') { // geklammertes Palindrom beginnt
      do base.push(appendage.pop());
      while (!appendage.is_empty() && appendage.top() != '(' && appendage.top() != ')');

      if (!appendage.is_empty() && appendage.top() == ')') { // geklammertes Palindrom endet
        appendage.pop();
        while (!base.is_empty() && base.top() != '(') toBeChecked.push(base.pop());
        base.pop();
        if (!checkWithoutParentheses(toBeChecked)) return false;
        else base.push('*');
      }
    }
    else while (!appendage.is_empty() && appendage.top() != '(') base.push(appendage.pop()); // Überbleibsel zw. ')...('

    if (!appendage.is_empty()) return checkWithParentheses(base, appendage); // appendage noch nicht durchlaufen?

    while (!base.is_empty() && base.top() != ')') toBeChecked.push(base.pop()); // nach Klammer absuchen
    if (base.is_empty()) return checkWithoutParentheses(toBeChecked); // keine Klammern mehr übrig?
    else {
      while (!base.is_empty()) toBeChecked.push(base.pop()); // Rest auch noch übertragen und als neues appendage nutzen
      return checkWithParentheses(base, toBeChecked);
    }
  }

  private static boolean checkWithoutParentheses(Stack<Character> noParentheses) {
    Stack<Character> reversedStack = new Stack<>();
    int stackLength = 0;

    while (!noParentheses.is_empty()) { reversedStack.push(noParentheses.pop()); stackLength++; }

    for (int i = 0; i < stackLength / 2; i++) noParentheses.push(reversedStack.pop());

    if (stackLength % 2 == 1) reversedStack.pop();

    while (!reversedStack.is_empty()) {
      if (reversedStack.top().equals(noParentheses.top())) { reversedStack.pop(); noParentheses.pop(); }
      else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String example1 = "otto";
    System.out.println(isTPalindrome(example1));
    String example2 = "al(otto)la";
    System.out.println(isTPalindrome(example2));
    String example3 = "abc(aha)(u)cba";
    System.out.println(isTPalindrome(example3));
    String example4 = "abc(ah(otto)v(atta)ha)cba";
    System.out.println(isTPalindrome(example4));

    String example5 = "abc";
    System.out.println(isTPalindrome(example5));
    String example6 = "a(b)cca(b)";
    System.out.println(isTPalindrome(example6));
    String example7 = "abc(ah(otto)h)cba";
    System.out.println(isTPalindrome(example7));
  }
}