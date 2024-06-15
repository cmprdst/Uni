package Uebung10;

import java.util.*;

//---------------------------------------------------------------//
public class AdjMatrix{
  //-------------------------------------------------------------//
  public  static int inDegree(int k, int[][] m){
    if (invalidParams(k, m)) return -1;
    
    int deg = 0;
	  
    for (int[] edges : m) if (edges[k] != 0) deg++;
    
    return deg;
  }

  //-------------------------------------------------------------//
  public  static int outDegree(int k, int[][] m){
    if (invalidParams(k, m)) return -1;
    
    int deg = 0;
    
    for (int edge : m[k]) if (edge != 0) deg++;
    
    return deg;
  }

  //-------------------------------------------------------------//
  public  static List<Integer> adjacent(int k, int[][] m){
    if (invalidParams(k, m)) return null;
    
    List<Integer> nodes = new ArrayList<>();
    
    for (int i = 0; i < m[k].length; i++) if (m[k][i] != 0) nodes.add(i);
    
    return nodes;
  }

  //-------------------------------------------------------------//
  public static boolean hasTriangle(int[][] m) {
    // Matrix aus Aufgabe hat nur einen Zyklus = Dreieck 2 → 4 → 3 → 2
    if (invalidParams(0, m)) return false;
    
    int size = m.length;
    
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          if (m[i][j] != 0 && m[j][k] != 0 && m[k][i] != 0) {
            System.out.printf("%d -> %d -> %d -> %d\n", i, j, k, i);
            return true;
          }
        }
      }
    }
    
    return false;
    
    // Falls Zyklen der Länge 1 erlaubt sind, müssen diese Einträge in der Matrix ([i][i]) bei der Bestimmung, ob die
    // Matrix Dreiecke enthält, ausgelassen bzw. auf 0 gesetzt werden, um fehlerhafte Dreieckszyklen auszuschließen,
    // bspw. 1 → 1 → 1 → 1 oder 1 → 1 → 2 → 1 oder → 2 → 1 → 1 → 2 usw.
  }

  public static boolean invalidParams(int k, int[][] m) {
    if (k < 0 || m == null || m.length == 0 || k >= m.length || m.length != m[0].length) {
      System.out.println("Invalid node or matrix!");
      return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------//
  public static void main(String[] args) {
    int[][] example = {
            {0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0}
    };
    
    System.out.println(inDegree(1, example));
    System.out.println(outDegree(0, example));
    System.out.println(adjacent(0, example));
    System.out.println(hasTriangle(example));
  }
}
