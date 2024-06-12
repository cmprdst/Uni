package Uebung9;

//-----------------------------------------------------------------//
public class Food {
  //---------------------------------------------------------------//
  private String category_;
  private String name_;
  private int spoilsInXDays_;

  public Food(String category, String name, int spoilsInXDays) {
    if (category == null || name == null || spoilsInXDays < 0) { System.out.println("Invalid argument(s)!"); return; }
    
    category_ = category;
    name_ = name;
    spoilsInXDays_ = spoilsInXDays;
  }
  
  //---------------------------------------------------------------//
  public int hashCode() {
    if (category_ == null || name_ == null) { System.out.println("Invalid Food initialization!"); return -1; }
    
    int code = 0;
    
    for (byte piece : category_.getBytes()) code += Math.abs(piece);
    
    return (code + spoilsInXDays_ / 20) % 2147483647; // 2^31 - 1 nächstkleinere Primzahl für int-Bereich
  }

  //---------------------------------------------------------------//
  public String toString() { return "(" + category_ + ", " + name_ + ", " + spoilsInXDays_ + ")"; }
}
