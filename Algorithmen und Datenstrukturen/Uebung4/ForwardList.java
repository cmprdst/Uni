package Uebung4;

import aud.Stack;
import java.util.NoSuchElementException;

/**ForwardList represents a list with single linked nodes, that do have
   a next-pointer. */
public class ForwardList<T> implements Iterable<T>{
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    if (is_empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_.toString();
      if (node.next_ != head_)
        rv += ",";
      node = node.next_;
    } while(node != null);
    rv += "]";
    return rv;
  }
  //-----------------------------------------------------------------//
  //---------------- !!Insert your solution below!! -----------------//
  // A Node is a single element in the list
  public class Node {
    //---------------------------------------------------------------//
    //    !!! Do not change the existing lines in class Node!!!      //
    //            !!! It is allowed to add new content !!!           //
    //       !!! It is not allowed to add a previous pointer !!!     //
    //---------------------------------------------------------------//
    public T data_;
    public Node next_ = null;

    public Node(T data, Node next) {
      data_ = data;
      next_ = next;
    }
  }
  //-----------------------------------------------------------------//
  public Node head_ = null;
  //-----------------------------------------------------------------//
  public ForwardList() {}
  //-----------------------------------------------------------------//
  public void push_front(T obj) { head_ = new Node(obj, head_); }
  //-----------------------------------------------------------------//
  public boolean is_empty() { return head_ == null; }
  //-----------------------------------------------------------------//
  public void backTraverse() {
    if (!is_empty()) {
      if (head_.next_ == null) System.out.print(head_.data_);
      else {
        T temp = head_.data_;
        head_ = head_.next_;
        backTraverse();
        System.out.print(" " + temp);
      }
    }
  }
  //-----------------------------------------------------------------//
  public class BackIterator implements java.util.Iterator<T> {
    Node node_ = null;
    Stack<T> revListData = new Stack<>();

    BackIterator(Node node) {
      node_ = node;

      while (node_ != null) {
        revListData.push(node_.data_);
        node_ = node_.next_;
      }
    }

    @Override
    public boolean hasNext() { return !revListData.is_empty(); }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException("There is no data left to iterate over!");

      return revListData.pop();
    }
    @Override
    public void remove() { throw new UnsupportedOperationException(); }
  }
  //-----------------------------------------------------------------//
  public BackIterator iterator() { return new BackIterator(head_); }
  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    ForwardList<String> example1 = new ForwardList<>();

    for (int i = 1; i < 6; i++) example1.push_front("word" + i);
    System.out.println(example1);
    example1.backTraverse();

    System.out.println();

    ForwardList<String> example2 = new ForwardList<>();

    for (int i = 6; i < 11; i++) example2.push_front("word" + i);
    System.out.println(example2);

    for (String words : example2) System.out.print(words + " ");
  }
}