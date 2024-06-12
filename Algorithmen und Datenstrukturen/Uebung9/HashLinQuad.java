package Uebung9;
//-----------------------------------------------------------------//

/** simple Hashtable with linear/quadratic probing
    capacity is big enough */

public class HashLinQuad {
  //---------------------------------------------------------------//
  private int[] table_;    // array of buckets or slots
  private int   size_;       // current number of elements
  private int   capacity_;
  
  public HashLinQuad(int capacity) {
    if (capacity <= 0) { System.out.println("Given capacity contradicts useful construction of hashtable!"); return; }
    
    table_    = new int[capacity];
    size_     = 0;
    capacity_ = capacity;
  }

  //---------------------------------------------------------------//
  public int addLin(int obj) {
    if (size_ == capacity_) { System.out.println("Hashtable is full, cannot insert value!"); return 0; }
    
    int collisions  = 0;
    int hash        = obj % capacity_; // 1249 ist prim → ggT(obj, capacity) = 1 → im Mittel gleich verteilte Streuung
    
    if (obj == 0) System.out.println("0 functions as placeholder!");
    else {
      while (table_[hash] != 0) {
        collisions++;
        hash = ++hash % capacity_;
      }
      table_[hash] = obj;
      size_++;
    }
    return collisions;
  }

  //---------------------------------------------------------------//
  public int addQuad(int obj) {
    if (size_ == capacity_) { System.out.println("Hashtable is full, cannot insert value!"); return 0; }
    
    int collisions  = 0;
    int hash        = obj % capacity_; // 1249 ist prim → ggT(obj, capacity) = 1 → im Mittel gleich verteilte Streuung
    int i           = 0;
    
    if (obj == 0) System.out.println("0 functions as placeholder!");
    else {
      while (table_[hash] != 0) {
        collisions++; i++;
        hash = (hash + i * i) % capacity_;
      }
      table_[hash] = obj;
      size_++;
    }
    return collisions;
  }

  //---------------------------------------------------------------//
  public String toString() {
    StringBuilder entries = new StringBuilder("[");
    
    for (int i = 0; i < capacity_; i++) {
      if (table_[i] == 0) continue;
      else entries.append("(").append(i).append(", ").append(table_[i]).append("), ");
    }
    if (entries.length() > 1) entries.delete(entries.length() - 2, entries.length());
    entries.append("]");
    
    return entries.toString();
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    HashLinQuad exampleLin = new HashLinQuad(1249);
    HashLinQuad exampleQuad = new HashLinQuad(1249);
    
    int collisionsLin = 0;
    int collisionsQuad = 0;
    
//    for (int i = 0; i < 1000; i++) collisionsLin += exampleLin.addLin((int) (1 + Math.random() * 1e6));
//    for (int i = 0; i < 1000; i++) collisionsQuad += exampleQuad.addQuad((int) (1 + Math.random() * 1e6));
    
    System.out.println(exampleLin);
    System.out.println(exampleQuad);
    
    System.out.println(collisionsLin);
    System.out.println(collisionsQuad);
    
    // Anzahl der Kollisionen für quadratisches Sondieren stets signifikant kleiner (teilweise über die Hälfte)
  }
}
