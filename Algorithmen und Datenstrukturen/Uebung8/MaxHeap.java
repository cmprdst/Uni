package Uebung8;

import java.util.*;

//-----------------------------------------------------------------//
public class MaxHeap<T extends Comparable<T>> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    return heap_.toString(); // don't change because of backend
  }
  
  //---------------------------------------------------------------//
  //--------------- !!Insert your solution below!! ----------------//
  private List<T> heap_;  // or Vector
  
  //---------------------------------------------------------------//
  public MaxHeap() { heap_ = new ArrayList<>(); }
  
  //---------------------------------------------------------------//
  public MaxHeap(T[] arr) {
    if (arr == null || arr.length == 0) return;
    
    heap_ = new ArrayList<>();
    heap_.addAll(Arrays.asList(arr));
    
    for (int i = heap_.size() / 2; i > 0; i--) downHeap(i); // für Kinder der vorletzten Ebene bis Wurzel Tausch möglich
  }
  
  //---------------------------------------------------------------//
  public List<T> getHeap() { return this.heap_; }
  
  //---------------------------------------------------------------//
  public int getSize() { return heap_.size(); }
  
  //---------------------------------------------------------------//
  public boolean isEmpty() { return getHeap().isEmpty(); }
  
  //---------------------------------------------------------------//
  final public void downHeap(int n) {
    // in enger Anlehnung an Vorlesungsfolien
    heap_.addFirst(null); // Platzhalter für korrekte Indexberechnung der Eltern/Kinder → 1. Eintrag hat Index 1
    T entry = heap_.get(n);
    int size = heap_.size() - 1; // null zählt als Platzhalter nicht mit zur Größe
    
    while (n <= size / 2) {
      int j = 2 * n;
      
      if (j + 1 < size && heap_.get(j).compareTo(heap_.get(j + 1)) < 0) j++;
      if (entry.compareTo(heap_.get(j)) >= 0) break;
      
      heap_.set(n, heap_.get(j));
      n = j;
    }
    heap_.set(n, entry);
    heap_.removeFirst(); // null vor Abschluss entfernen
  }
  
  //---------------------------------------------------------------//
  public void insert(T obj) {
    heap_.add(obj);
    upHeap(heap_.size());
  }
  
  //---------------------------------------------------------------//
  private void upHeap(int n) {
    heap_.addFirst(null);
    T entry = heap_.get(n);
    
    while (n > 1 && entry.compareTo(heap_.get(n / 2)) >= 0) {
      heap_.set(n, heap_.get(n / 2));
      n /= 2;
    }
    heap_.set(n, entry);
    heap_.removeFirst();
  }
  
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    MaxHeap<String> example = new MaxHeap<>();
    String[] letters = {"X", "T", "O", "G", "S", "M", "N", "A", "E", "R", "A", "I"};
    for (String letter : letters) example.insert(letter);
    System.out.println(example);
    
    MaxHeap<Integer> example1 = new MaxHeap<>();
    Integer[] test = {8, 3, 7, 1, 5, 6};
    for (Integer inte : test) example1.insert(inte);
    System.out.println(example1);
  }
}
