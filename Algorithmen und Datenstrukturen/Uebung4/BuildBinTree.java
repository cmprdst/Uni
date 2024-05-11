package Uebung4;

import aud.BinaryTree;
import aud.util.DotViewer;

public class BuildBinTree {
  public static void main(String[] args) {
    BinaryTree<Integer> root =
            new BinaryTree<>(-8,
                    new BinaryTree<>(4,
                            new BinaryTree<>(6),
                            new BinaryTree<>(-11)),
                    new BinaryTree<>(1,
                            new BinaryTree<>(5),
                            new BinaryTree<>(7)));

    System.out.println(root.preorder());
    System.out.println(root.inorder());
    System.out.println(root.postorder());
    System.out.println(root.levelorder());

    DotViewer viewer = DotViewer.displayWindow(root, "example tree");
    viewer.setExitOnClose();
  }
}