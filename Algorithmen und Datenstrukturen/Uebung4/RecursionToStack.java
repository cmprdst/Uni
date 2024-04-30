package Uebung4;

import aud.Stack;

public class RecursionToStack {
  //-----------------------------------------------------------------//
  public static int whatStack(int n) {
    if (n < 0) { System.out.print("Sum of digits is only defined for natural numbers and "); return 0; }

    int number = n; int digitSum = 0; Stack<Integer> digits = new Stack<>();

    while (number != 0) { digits.push(number % 10); number /= 10; }

    while (!digits.is_empty()) digitSum += digits.pop();

    return digitSum;
  }
  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.println(whatStack(47142));
    System.out.println(whatStack(0));
    System.out.println(whatStack(-47142));
  }
}