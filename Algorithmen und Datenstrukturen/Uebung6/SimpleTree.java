package Uebung6;

//-----------------------------------------------------------------//
public class SimpleTree<T extends Comparable<T>> {
  //---------------------------------------------------------------//
  public class Node {
    T     key_    = null;
    Node  parent_ = null;
    Node  left_   = null;
    Node  right_  = null;

    public Node(T key) { key_ = key; }

    public T    getKey    () { return key_; }
    public Node getParent () { return parent_; }
    public Node getLeft   () { return left_; }
    public Node getRight  () { return right_; }
  }

  //---------------------------------------------------------------//
  private Node root_;

  //---------------------------------------------------------------//
  public SimpleTree() { root_ = null; }

  //---------------------------------------------------------------//
  public void add(T obj) {
      if (root_ == null) root_ = new Node(obj);
      else addHelper(root_, obj);
  }

  private void addHelper(Node current, T obj) {
    if (obj.compareTo(current.key_) < 0) {
      if (current.left_ == null) current.left_ = new Node(obj);
      else addHelper(current.left_, obj);
    }
    else if (obj.compareTo(current.key_) > 0) {
      if (current.right_ == null) current.right_ = new Node(obj);
      else addHelper(current.right_, obj);
    }
  }

  //---------------------------------------------------------------//
  public boolean contains(T obj) {
    if (root_ == null) return false;
    else return containsHelper(root_, obj);
  }

  private boolean containsHelper(Node current, T obj) {
    if (obj.compareTo(current.key_) < 0) {
      if (current.left_ == null) return false;
      else return containsHelper(current.left_, obj);
    }
    else if (obj.compareTo(current.key_) > 0) {
      if (current.right_ == null) return false;
      else return containsHelper(current.right_, obj);
    }
    else return true;
  }

  //---------------------------------------------------------------//
  public String toString() { return toStringHelper(root_);}

  private String toStringHelper(Node current) {
    String output = "";

    if (current != null) {
      output += toStringHelper(current.left_);
      output += current.key_ + " ";
      output += toStringHelper(current.right_);
    }
    return output;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    SimpleTree<Integer> example = new SimpleTree<>();

    example.add(4);
    example.add(2);
    example.add(4);
    example.add(6);
    example.add(10);
    example.add(12);
    example.add(7);

    System.out.println("Inorder Traversal: " + example);
    System.out.println(example.contains(0));
    System.out.println(example.contains(12));
  }
}