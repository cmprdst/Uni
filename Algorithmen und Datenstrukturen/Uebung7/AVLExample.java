package Uebung7;

import aud.AVLTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

//-----------------------------------------------------------------//
public class AVLExample {
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    AVLTree<Integer, Object> example = new AVLTree<>();
    SingleStepper stepper = new SingleStepper("Stepper for example tree");
    DotViewer viewer = DotViewer.displayWindow(example, "example tree");
    viewer.setExitOnClose();
    
    Integer[] natNum = {14, 15, 17, 7, 5, 10, 16};
    
    stepper.halt("BEGIN");
    
    for (Integer num: natNum) {
      example.insert(num, null);
      viewer.display(example);
      stepper.halt("Next integer");
    }
    stepper.halt("QUIT");
    System.exit(0);
  }
}