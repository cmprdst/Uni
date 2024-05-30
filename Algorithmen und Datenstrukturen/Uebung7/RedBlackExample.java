package Uebung7;

import aud.AVLTree;
import aud.RedBlackTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

//-----------------------------------------------------------------//
public class RedBlackExample {
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    RedBlackTree<Integer, Object> example = new RedBlackTree<>();
    AVLTree<Integer, Object> exampleAVL = new AVLTree<>();
    SingleStepper stepper = new SingleStepper("Stepper for example tree");
    DotViewer viewer = DotViewer.displayWindow(example, "example tree");
    viewer.setExitOnClose();
    
    Integer[] nums = {6, 7, 3, 4, 2, 1};
    
    stepper.halt("BEGIN RBT");
    
    for (Integer num: nums) {
      example.insert(num, null);
      viewer.display(example);
      stepper.halt("Next integer");
    }
    stepper.halt("QUIT RBT");
    
    stepper.halt("BEGIN AVL");
    
    for (Integer num: nums) {
      exampleAVL.insert(num, null);
      viewer.display(exampleAVL);
      stepper.halt("Next integer");
    }
    stepper.halt("QUIT AVL");
    System.exit(0);
  }
}