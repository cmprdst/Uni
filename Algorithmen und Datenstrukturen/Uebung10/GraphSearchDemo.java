package Uebung10;

import aud.example.graph.*;
import aud.util.DotViewer;
import aud.util.SingleStepper;

//------------------------------------------------------------------//
public class GraphSearchDemo {
  
  //----------------------------------------------------------------//  
  public static MyGraph createGraph() {
    MyGraph example = new MyGraph(false);
    
    MyNode node8 = example.addNode();
    MyNode node1 = example.addNode();
    MyNode node2 = example.addNode();
    MyNode node3 = example.addNode();
    MyNode node4 = example.addNode();
    MyNode node5 = example.addNode();
    MyNode node6 = example.addNode();
    MyNode node7 = example.addNode();
    
    node1.setLabel("1");
    node2.setLabel("2");
    node3.setLabel("3");
    node4.setLabel("4");
    node5.setLabel("5");
    node6.setLabel("6");
    node7.setLabel("7");
    node8.setLabel("8");
    
    example.addEdge(node1, node2);
    example.addEdge(node1, node3);
    example.addEdge(node1, node6);
    example.addEdge(node1, node7);
    example.addEdge(node1, node8);
    example.addEdge(node2, node8);
    example.addEdge(node3, node8);
    example.addEdge(node4, node5);
    example.addEdge(node4, node6);
    example.addEdge(node5, node6);
    example.addEdge(node5, node7);
    example.addEdge(node5, node8);
    
    return example;
  }
  
  //----------------------------------------------------------------//
  public static void main(String[] args) {
//    MyGraph bfsGraph = createGraph();
//
//    DotViewer bfsViewer = DotViewer.displayWindow(bfsGraph, "bfs viewer");
//    bfsViewer.setExitOnClose();
//
//    BreadthFirstSearch bfs = new BreadthFirstSearch(bfsGraph);
//
//    bfs.singlestepper = new SingleStepper("bfs Stepper") {
//      @Override
//      protected void onHalt() { bfsViewer.display(bfsGraph); }
//    };
//
//    bfs.singlestepper.halt("Begin bfs");
//    bfs.start(bfsGraph.getSomeNode());
//    bfs.singlestepper.halt("End bfs");
//
//
//    MyGraph dfsGraph = createGraph();
//
//    DotViewer dfsViewer = DotViewer.displayWindow(dfsGraph, "dfs viewer");
//    dfsViewer.setExitOnClose();
//
//    DepthFirstSearch dfs = new DepthFirstSearch(dfsGraph);
//
//    dfs.singlestepper = new SingleStepper("dfs Stepper") {
//      @Override
//      protected void onHalt() { dfsViewer.display(dfsGraph); }
//    };
//
//    dfs.singlestepper.halt("Begin dfs");
//    dfs.start(dfsGraph.getSomeNode());
//    dfs.singlestepper.halt("End dfs");
  }
}
