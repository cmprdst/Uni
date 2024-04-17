package Uebung2;

import aud.SList;
import java.util.function.Predicate;

// This class "wraps" an instance of `SList<Integer>` (attribute `li`): Calls to `toString()` and `push_front()` are
// "delegated" to the instance. The additional method `filter()` applies a predicate and constructs a new list with all
// items for which the predicate evaluates to `true`.

public class IntSList {
  SList<Integer> li;

  public IntSList() { li = new SList<>(); }

  @Override
  public String toString() { return li.toString(); }

  public void push_front(int obj) { li.push_front(obj); }

// Filter list by predicate `p` and return list of all items for which predicate evaluates to `true`. The order of items
// in the returned list may differ from the order in `this` list (because we use always `push_front()`).

  public IntSList filter(Predicate<Integer> p) {
    IntSList filteredList = new IntSList();
    SList<Integer>.Iterator iterator = li.iterator();

    while (iterator.hasNext()) {
      int current = iterator.next();
      if (p.test(current)) filteredList.push_front(current);
    }
    return filteredList;
  }

  public static void main(String[] args) {
    IntSList list = new IntSList();
    int[] test = {85, 72, 93, 81, 74, 42};

    for (int integer : test) list.push_front(integer);

    Predicate<Integer> even = integer -> integer % 2 == 0;
    System.out.println(list.filter(even));

    Predicate<Integer> GreaterThan42 = integer -> integer > 42;
    System.out.println(list.filter(GreaterThan42));

    Predicate<Integer> divisibleByThree = integer -> integer % 3 == 0;
    System.out.println(list.filter(divisibleByThree));
  }
}