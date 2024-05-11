package Uebung5;

import aud.BinaryTree;    //to use BinaryTree<T>
import aud.Queue;

//------------------------------------------------------------------//
public class MyBinTree<T> extends BinaryTree<T> {
  //----------------------------------------------------------------//
  public MyBinTree(T data) {
    super(data);
  }

  //----------------------------------------------------------------//
  public MyBinTree(T data,MyBinTree<T> left,MyBinTree<T> right) {
    super(data, left, right);
  }

  //----------------------------------------------------------------//
  public int maxWidth() {
    if (this.getRoot() == null) return 0;
    else {
      Queue<BinaryTree<T>> levelElements = new Queue<>();
      levelElements.enqueue(this.getRoot());
      return maxWidthHelper(levelElements, 1, 1);
    }
  }

  private int maxWidthHelper(Queue<BinaryTree<T>> elem, int queueSize, int maxWidth) {
    while (!elem.is_empty()) {
      int counter = 0;
      maxWidth = Math.max(maxWidth, queueSize);

      for (int i = 0; i < queueSize; i++) {
        BinaryTree<T> currentNode = elem.dequeue();

        if (currentNode.getLeft() != null) { elem.enqueue(currentNode.getLeft()); counter++; }
        if (currentNode.getRight() != null) { elem.enqueue(currentNode.getRight()); counter++; }
      }
      if (counter != 0) return maxWidthHelper(elem, counter, maxWidth);
    }
    return maxWidth;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    MyBinTree<Integer> root =
            new MyBinTree<>(-8,
                    new MyBinTree<>(4,
                            new MyBinTree<>(6,
                                    new MyBinTree<>(10),
                                    null),
                            new MyBinTree<>(-11)),
                    new MyBinTree<>(1,
                            new MyBinTree<>(5),
                            new MyBinTree<>(7)));

    System.out.println(root.maxWidth());
  }
}