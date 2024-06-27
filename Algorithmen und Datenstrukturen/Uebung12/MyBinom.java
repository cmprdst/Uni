package Uebung12;

import java.util.Arrays;

//-----------------------------------------------------------------//
public class MyBinom {
  //---------------------------------------------------------------//
  public static int binom(int n, int k) {
    int[][] table =  new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++) {
      table[i][0] = 1;
      if (i <= k) {
        table[i][i] = 1;
      }
    }
    
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= Math.min(i - 1, k); j++) {
        table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
      }
    }
    
    for (int i = 0; i <= n; i++) { System.out.println(Arrays.toString(table[i])); }
    System.out.println();
    
    return table[n][k];
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.println(binom(7, 5));
  }
}
