package Uebung3;

import java.util.NoSuchElementException;

/**MySList represents a single linked list, which holds elements of type
   integer.*/
public class MySList implements Iterable<Integer> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    if (empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_;
      if (node.next_ != null)
        rv += ",";
      node = node.next_;
    } while(node != null);
    rv += "]";
    return rv;
  }
  //-----------------------------------------------------------------//
  //---------------- !!Insert your solution below!! -----------------//
  /**Node represents a single element in the list.*/
  class Node {
    int data_;                         //!! Do not change this line !!
    Node next_;

    public Node(int data, Node next) {
      data_ = data;
      next_ = next;
    }
    public Node(int data) {
      data_ = data;
      next_ = null;
    }
  }
  //----------------------------------------------------------------//
  Node head_ = null;
  //----------------------------------------------------------------//
  public MySList() {}
  //----------------------------------------------------------------//
  public boolean empty() { return head_ == null; }
  public int size() {
    Node current = head_; int counter = 0;

    while (current != null) { current = current.next_; counter++; }

    return counter;
  }

  Node check(Node node) {
    if (node == null) throw new NoSuchElementException("Checked node equals null.");
    return node;
  }

  public int front() { return check(head_).data_; }
  public int back() {
    Node current = head_;

    while (current.next_ != null) current = current.next_;

    return check(current).data_;
  }

  public int atIndex(int i) {
    if (i < 0) { System.err.println("Negative index is undefined."); return -1; }
    else if (i >= size()) { System.err.println("Cannot return the value of a node that is out of bounds."); return -1; }

    Node current = head_; int counter = 0;

    while (counter < i) { current = current.next_; i++; }

    return check(current).data_;
  }
  public int atPlace(int i) { return atIndex(--i); }

  public void push_front(int i) { head_ = new Node(i, head_); }
  public void push_back(int i) {
    if (empty()) head_ = new Node(i);
    else {
      Node current = head_;

      while (current.next_ != null) current = current.next_;

      current.next_ = new Node(i);
    }
  }

  public void insertValueAtIndex(int i, int value) { // "list[i] = value", old "list[i]" and rest get pushed back
    if (i < 0) System.err.println("Cannot insert at a negative position.");
    else if (i == 0) push_front(i);
    else if (i >= size()) push_back(i); // index that is too large ensures simple push_back
    else {
      Node current = head_; int counter = 0;

      while (counter < i - 1) { current = current.next_; counter++; }

      check(current).next_ = new Node(value, current.next_); // current.next_ in new Node() is handled first
    }
  }
  public void insertValueAtPlace (int i, int value) { insertValueAtIndex(--i, value); }

  public void pop_front() {
    if (empty()) System.err.println("Cannot remove from an empty list.");
    else if (size() == 1) head_ = null;
    else head_ = head_.next_;
  }
  public void pop_back() {
    if (empty() || size() == 1) pop_front();

    Node current = head_;

    while (current.next_.next_ != null) current = current.next_;

    current.next_ = null;
  }

  public void removeValueAtIndex(int i) {
    if (i < 0) System.err.println("Cannot remove from a negative position.");
    else if (empty() || size() == 1 || i == 0) pop_front();
    else if (i >= size() - 1) pop_back(); // condition ensures that i.e. size() == 2 && ∀i >= 1 simple pop_back suffices
    else {
      Node current = head_; int counter = 0;

      while (counter < i - 1) { current = current.next_; counter++; }

      current.next_ = current.next_.next_;
    }
  }
  public void removeValueAtPlace(int i) { removeValueAtIndex(--i); }

  public void clear() { head_ = null; }
  //----------------------------------------------------------------//
  /**Iterator is used to traverse odd elements in a list.*/
  public class Iterator implements java.util.Iterator<Integer> {
    Node node_ = null;
    Iterator(Node node) { node_ = node; }

    @Override
    public boolean hasNext() {
      while (node_ != null) {
        if (node_.data_ % 2 != 0) return true;
        node_ = node_.next_;
      }
      return false;
    }

    @Override
    public Integer next() {
      if (!hasNext()) throw new NoSuchElementException("There is no next odd integer to iterate over.");

      while (node_ != null) {
        int currentData = node_.data_;
        node_ = node_.next_;
        if (currentData % 2 != 0) return currentData;
      }
      return null;
    }

    @Override
    public void remove() { throw new UnsupportedOperationException(); }
  }
  //----------------------------------------------------------------//
  @Override
  public Iterator iterator() { return new Iterator(head_); }
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    MySList example = new MySList();
    System.out.println(example.empty());

    example.push_back(85);
    example.push_back(72);
    example.push_back(93);
    example.push_back(81);
    example.push_back(74);
    example.push_back(42);
    System.out.println(example);
    System.out.println(example.empty());

    MySList test = new MySList();
    for (int value : example) test.push_back(value);
    System.out.println(test);
  }
}