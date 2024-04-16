package Uebung2;

public class LinkedNode<T> {
  T data_ = null;
  LinkedNode<T> next_ = null;

  public LinkedNode(T data, LinkedNode<T> next) {
    data_ = data;
    next_ = next;
  }

  public LinkedNode(T data) { this(data, null); }

  public T getData() { return data_; }
  public LinkedNode<T> getNext() { return next_; }

  public void setData(T data) { data_ = data; }
  public void setNext(LinkedNode<T> next) { next_ = next; }

  @Override
  public String toString() {
    String nodes = "";
    LinkedNode<T> node = this;

    while (node != null) {
      if (node.data_ != null) {
        nodes += node.getData();
        if (node.next_ != null) nodes += " | ";
      }
      node = node.getNext();
    }
    return nodes;
  }

  public static void main(String[] args) {
    LinkedNode<String> Ausschlafen = new LinkedNode<>("Ausschlafen");
    LinkedNode<String> Spieleabend = new LinkedNode<>("Spieleabend");
    LinkedNode<String> SchlafenGehen = new LinkedNode<>("Schlafen gehen");

    Ausschlafen.setNext(Spieleabend);
    Spieleabend.setNext(SchlafenGehen);

    System.out.println(Ausschlafen);

    LinkedNode<String> MensaGehen = new LinkedNode<>("Mensa gehen");
    LinkedNode<String> VorlesungBesuchen = new LinkedNode<>("Vorlesung besuchen");

    Ausschlafen.setNext(VorlesungBesuchen);
    VorlesungBesuchen.setNext(MensaGehen);
    MensaGehen.setNext(Spieleabend);

    System.out.println(Ausschlafen);
    System.out.println(MensaGehen);
  }
}