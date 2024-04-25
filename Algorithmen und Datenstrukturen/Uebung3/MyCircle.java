package Uebung3;

public class MyCircle<T> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  //------------ A Node is a single element int the ring ------------//
  class Node {
    T data_ = null;
    Node next_ = null;
    Node prev_ = null;

    Node(T obj, Node prv, Node nxt) {
      data_ = obj;
      prev_ = prv;
      next_ = nxt;
    }
  }
  //--- class members
  protected Node head_ = null;
  //--- class methods
  public   MyCircle() { head_ = null; }
  public T front()    { return head_.data_; }
  public String toString() {
    if (empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_.toString();
      if (node.next_ != head_)
        rv += ",";
      node = node.next_;
    } while(node != head_);
    rv += "]";
    return rv;
  }
  //-----------------------------------------------------------------//
  //---------------- !!Insert your solution below!! -----------------//
  public int size() {
    if (empty()) return 0;

    int ringSize = 1; Node current = head_.next_;

    while (current != head_) { ringSize++; current = current.next_; }

    return ringSize;
  }
  //-----------------------------------------------------------------//
  public boolean empty() { return head_ == null; }
  //-----------------------------------------------------------------//
  public void push_back(T obj) {
    switch (size()) {
      case 0: {
        head_ = new Node(obj, null, null);
        head_.next_ = head_;
        head_.prev_ = head_;
        break;
      }
      case 1: {
        head_.next_ = new Node(obj, head_, head_);
        head_.prev_ = head_.next_;
        break;
      }
      default: {
        head_.prev_.next_ = new Node(obj, head_.prev_, head_);
        head_.prev_ = head_.prev_.next_;
        break;
      }
    }
  }
  //-----------------------------------------------------------------//
  public void pop_front() {
    switch (size()) {
      case 0: System.err.println("Cannot remove from an empty ring."); break;
      case 1: head_ = null; break;
      case 2: head_ = head_.next_; head_.next_ = head_; head_.prev_ = head_; break;
      default: {
        head_.next_.prev_ = head_.prev_;
        head_.prev_.next_ = head_.next_;
        head_ = head_.next_;
        break;
      }
    }
  }
  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    MyCircle<Integer> example = new MyCircle<>();

    System.out.println(example);
    System.out.println(example.size());
    System.out.println(example.empty());

    example.push_back(1);
    System.out.println(example);
    System.out.println(example.size());
    System.out.println(example.empty());

    example.push_back(2);
    System.out.println(example);
    System.out.println(example.size());

    example.push_back(3);
    System.out.println(example + "\n");

    example.pop_front();
    System.out.println(example);

    example.pop_front();
    System.out.println(example);

    example.pop_front();
    System.out.println(example);

    example.pop_front();
    System.out.println(example);
  }
}