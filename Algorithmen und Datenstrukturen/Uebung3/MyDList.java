package Uebung3;

import aud.DList;

public class MyDList<T> extends DList<T> {
  //-----------------------------------------------------------------//
  public MyDList() { super(); }
  //-----------------------------------------------------------------//
  public void append(MyDList<T> li) {
    if (li == null) return;

    if (head_ == null && tail_ == null) {
      this.head_ = li.head_;
      this.tail_ = li.tail_;
    } else {
      MyDList<T>.ForwardIterator thisIterator = this.iterator();
      MyDList<T>.ForwardIterator liIterator = li.iterator();

      int liInitSize = li.size();

      while (thisIterator.hasNext()) thisIterator.next();
      for (int i = 0; i < liInitSize; i++) this.push_back(liIterator.next()); // O(n)
    }
  }
  //-----------------------------------------------------------------//
  public void insert(int n, MyDList<T> li) {
    if (li == null) return;
    if (n < 0) { System.err.println("Negative insert position is invalid."); return; }
    if (n >= this.size()) { this.append(li); return; }

    if (head_ == null || tail_ == null) {
      this.head_ = li.head_;
      this.tail_ = li.tail_;
    } else {
      MyDList<T>.ForwardIterator thisIterator = this.iterator();
      MyDList<T>.BackwardIterator backThisIterator = this.reverse_iterator();
      MyDList<T>.ForwardIterator liIterator = li.iterator();
      MyDList<T>.BackwardIterator backLiIterator = li.reverse_iterator();

      int liInitSize = li.size();
      int thisInitSize = this.size();

      if (n == 0) {
        while (backThisIterator.hasNext()) backThisIterator.next();
        for (int i = 0; i < liInitSize; i++) this.push_front(backLiIterator.next()); // O(n)
      } else {
        for (int i = 0; i < n; i++) { this.push_back(thisIterator.next()); this.pop_front(); }
        for (int i = 0; i < liInitSize; i++) this.push_back(liIterator.next());
        for (int i = n; i < thisInitSize; i++) { this.push_back(thisIterator.next()); this.pop_front(); } // O(n)
      }
    }
  }
  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    MyDList<Integer> example1 = new MyDList<>();
    for (int i = 0; i < 5; i++) example1.push_back(i);
    System.out.println(example1);

    example1.append(null);
    System.out.println(example1);

    MyDList<Integer> empty1 = new MyDList<>();
    empty1.append(example1);
    System.out.println(empty1);

    example1.append(example1);
    System.out.println(example1 + "\n");

    MyDList<Integer> empty2 = new MyDList<>();

    MyDList<Integer> example2 = new MyDList<>();
    for (int i = 0; i < 5; i++) example2.push_back(i);

    MyDList<Integer> example3 = new MyDList<>();
    for (int i = 5; i < 10; i++) example3.push_back(i);

    example2.insert(0, empty2);
    System.out.println(example2);

    example2.insert(0, example2);
    System.out.println(example2);

    example2.insert(-3, example2);

    example2.insert(897324, example3);
    System.out.println(example2);

    example3.insert(2, example3);
    System.out.println(example3);
  }
}