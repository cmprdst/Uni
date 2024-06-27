package Uebung12;

import java.util.Arrays;

//-----------------------------------------------------------------//
public class KnapsackDyn {
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    class BackPack {
      int space_ = 0;
      
      public BackPack(int space) {
        space_ = space;
      }
      
      public int getSpace() { return space_; }
    }
    
    class Item {
      int size_  = 0;
      int value_ = 0;
      
      public Item(int size, int value) {
        size_  = size;
        value_ = value;
      }
      
      public int getSize()  { return size_; }
      public int getValue() { return value_; }
    }
    
    BackPack backPack = new BackPack(15);
    Item a = new Item(3, 3);
    Item b = new Item(4, 5);
    Item c = new Item(6, 8);
    Item d = new Item(7, 9);
    Item[] items = {a, b, c, d};
    
    int[][] table = new int[items.length + 1][backPack.getSpace() + 1]; // Größe + 1, Anzahl Items + 1
    
    for (int k = 1; k <= items.length; k++) {
      for (int size = 3; size <= backPack.getSpace(); size++) {
        if (items[k - 1].getSize() <= size) {
          int take = table[k - 1][size - items[k - 1].getSize()] + items[k - 1].getValue();
          table[k][size] = Math.max(table[k - 1][size], take);
        }
        else table[k][size] = table[k - 1][size];
      }
    }
    
    for (int i = 0; i <= items.length; i++) {
      System.out.println(Arrays.toString(table[i]));
    }
  }
}
