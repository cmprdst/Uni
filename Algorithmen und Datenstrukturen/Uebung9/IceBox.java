package Uebung9;

//---------------------------------------------------------------//
/**Container that can store food elements.*/
public class IceBox {
  
  //---------------------------------------------------------------//
  private Food[]  iceBox_;
  private int     size_;
  private int     capacity_;
  
  public IceBox(int capacity) {
    if (capacity <= 0) { System.out.println("Given capacity contradicts useful construction of hashtable!"); return; }
    
    iceBox_   = new Food[capacity];
    size_     = 0;
    capacity_ = capacity;
  }

  //---------------------------------------------------------------//
  public void add(Food obj) { // lineares Sondieren trotz geringerer Effizienz → ähnliche Lebensmittel näher beieinander
    if (size_ == capacity_) { System.out.println("Hashtable is full, cannot insert value!"); return; }
    
    if (obj == null) System.out.println("Food must be initialized!");
    else {
      int hash = obj.hashCode() % capacity_;
      
      while (iceBox_[hash] != null) hash = ++hash % capacity_;
      
      iceBox_[hash] = obj;
      size_++;
    }
  }

  //---------------------------------------------------------------//
  public boolean contains(Food obj) {
    if (iceBox_ == null || size_ == 0) return false;
    
    for (Food food : iceBox_) if (food != null && food.equals(obj)) return true;
    return false;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    IceBox fridge = new IceBox(100);
    
    Food banana = new Food("fruit", "banana", 10);
    Food apple = new Food("fruit", "apple", 27);
    Food melon = new Food("fruit", "melon", 3); // geschnitten
    Food leek = new Food("vegetable", "leek", 5);
    Food cabbage = new Food("vegetable", "cabbage", 1);
    Food broccoli = new Food("vegetable", "brokkoli", 4);
    Food hummus = new Food("spread", "hummus", 16);
    Food margarine = new Food("spread", "margarine", 63);
    Food ratatouille = new Food("leftovers", "ratatouille", 2);
    Food porridge = new Food("breakfast", "porridge", 7);
    
    fridge.add(banana);
    fridge.add(apple);
    fridge.add(melon);
    fridge.add(leek);
    fridge.add(cabbage);
    fridge.add(broccoli);
    fridge.add(hummus);
    fridge.add(margarine);
    fridge.add(ratatouille);
    fridge.add(porridge);
    
    for (int i = 0; i < fridge.capacity_; i++) if (fridge.iceBox_[i] != null) {
      System.out.print(i + ": ");
      System.out.print(fridge.iceBox_[i] + "\n");
    }
    
    /*
    - "Unterteilung" der Hashtabelle nach Anzahl der Food-Gruppen (bei neuer Gruppe Rehashing) → Food-Gruppen erhalten
    eigene Bereiche und überschneiden sich nicht mit anderen für leichtere Suche
    - ähnlich zur Hinzunahme von "spoilsInXDays" absolute Verschiebung für bestimmte Food-Gruppen (bspw. vegetable 10,
    fruit 20 usw.) → beabsichtigte Bildung von Clustern für Suche in näherer Umgebung (so wie Fächer im Kühlschrank)
     */
  }
}
