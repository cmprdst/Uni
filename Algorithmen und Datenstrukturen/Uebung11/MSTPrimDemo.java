package Uebung11;

import aud.example.graph.MyGraph;
import aud.example.graph.MyNode;
import aud.example.graph.PrimMinimumSpanningTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

//------------------------------------------------------------------//
public class MSTPrimDemo {
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    MyGraph given = new MyGraph(false);
    
    MyNode node0 = given.addNode();
    MyNode node1 = given.addNode();
    MyNode node2 = given.addNode();
    MyNode node3 = given.addNode();
    MyNode node4 = given.addNode();
    MyNode node5 = given.addNode();
    
    node0.setLabel("0");
    node1.setLabel("1");
    node2.setLabel("2");
    node3.setLabel("3");
    node4.setLabel("4");
    node5.setLabel("5");
    
    given.addEdge(node0, node1).setWeight(2);
    given.addEdge(node0, node2).setWeight(5);
    given.addEdge(node0, node3).setWeight(3);
    given.addEdge(node1, node5).setWeight(4);
    given.addEdge(node2, node3).setWeight(1);
    given.addEdge(node2, node4).setWeight(7);
    given.addEdge(node2, node5).setWeight(8);
    given.addEdge(node3, node5).setWeight(6);
    given.addEdge(node4, node5).setWeight(9);
    
    DotViewer primViewer = DotViewer.displayWindow(given, "prim viewer");
    primViewer.setExitOnClose();
    
    PrimMinimumSpanningTree prim = new PrimMinimumSpanningTree(given);
    
    prim.singlestepper = new SingleStepper("prim stepper") {
      @Override
      protected void onHalt() { primViewer.display(given); }
    };
    
    prim.singlestepper.halt("Begin prim");
    prim.start(given.getSomeNode());
    prim.singlestepper.halt("End prim");
  }
}
