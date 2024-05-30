package Uebung7;

import aud.A234Tree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

//-----------------------------------------------------------------//
public class A234Example {
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    A234Tree<Integer> exampleBottomUp = new A234Tree<>(false);
    A234Tree<Integer> exampleTopDown = new A234Tree<>(true);
    SingleStepper stepper = new SingleStepper("Stepper for example tree");
    DotViewer viewer = DotViewer.displayWindow(exampleBottomUp, "example tree");
    viewer.setExitOnClose();
    
    Integer[] nums = {3, 7, 5, 15, 17, 9, 13, 21, 11, 19};
    Integer[] sortedNums = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
    
    stepper.halt("BEGIN TOP DOWN");
    
    for (Integer num : sortedNums) {
      exampleBottomUp.insert(num);
      viewer.display(exampleBottomUp);
      stepper.halt("Next Integer");
    }
    stepper.halt("END TOP DOWN");
    
    stepper.halt("BEGIN BOTTOM UP");
    
    for (Integer num : sortedNums) {
      exampleTopDown.insert(num);
      viewer.display(exampleTopDown);
      stepper.halt("Next Integer");
    }
    stepper.halt("QUIT");
  }
}