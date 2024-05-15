package Uebung5;

import aud.*;               //to use BinaryTree<T>

public class IntBinTree extends BinaryTree<Integer> {
  //---------------------------------------------------------------//
  public IntBinTree(int data) {
    super(data);
  }

  //---------------------------------------------------------------//
  public IntBinTree(int data, IntBinTree left, IntBinTree right) {
    super(data, left, right);
  }

  //---------------------------------------------------------------//
  public int height() { return this.getRoot() == null ? 0 : heightHelper(this.getRoot()); }

  private int heightHelper(BinaryTree<Integer> subTree) {
    if (subTree == null) return 0;
    else {
      int leftHeight = heightHelper(subTree.getLeft());
      int rightHeight = heightHelper(subTree.getRight());
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }

  //---------------------------------------------------------------//
  public int maxSum() {
    if (this.getRoot() == null || this.getRoot().isLeaf()) return 0;
    else return Math.max(maxSumHelper(this.getRoot().getLeft()), maxSumHelper(this.getRoot().getRight()));
  }

  private int maxSumHelper(BinaryTree<Integer> subTree) {
    if (subTree == null) return 0;
    else return subTree.getData() + maxSumHelper(subTree.getLeft()) + maxSumHelper(subTree.getRight());
  }

  //---------------------------------------------------------------//
  public int maxPath() { return this.getRoot() == null ? 0 : maxPathHelper(this.getRoot()); }

  private int maxPathHelper(BinaryTree<Integer> subTree) {
    if (subTree == null) return 0;
    else {
      if (subTree.getLeft() == null) return subTree.getData() + maxPathHelper(subTree.getRight());
      else if (subTree.getRight() == null) return subTree.getData() + maxPathHelper(subTree.getLeft());
      else return subTree.getData() + Math.max(maxPathHelper(subTree.getLeft()), maxPathHelper(subTree.getRight()));
    }
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    IntBinTree root =
            new IntBinTree(-8,
                    new IntBinTree(4,
                            new IntBinTree(6,
                                    new IntBinTree(10),
                                    null),
                            new IntBinTree(-11)),
                    new IntBinTree(1,
                            new IntBinTree(5),
                            new IntBinTree(7)));

    System.out.println(root.height());
    System.out.println(root.maxSum());
    System.out.println(root.maxPath());
  }
}