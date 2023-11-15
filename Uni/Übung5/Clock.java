package Übung5;

public class Clock {
   private int h;
   private int min;

   public int getMin() { return min; }
   public int getH() { return h; }

   public Clock(int h, int min) { // falls zulässig werden Stunden und Minuten einfach übernommen
      this.h = h;
      this.min = min;
   }

   public Clock(int min) { // falls zulässig Berechnung der h aus min, min aus Rest, andernfalls Übernahme des Wertes
      if (min < 1440) {
         this.h = (min / 60) % 24;
         this.min = min % 60;
      } else this.min = min;
   }

   public boolean invalidTime = false; // falls wahr → Syntaxfehler bei Uhrzeitangabe in "hour:min"-Form

   public Clock(String time) { // zulässige Syntax für Uhrzeitangabe definieren
      if (time.length() == 3 && time.charAt(1) == ':') {
         this.h = Integer.parseInt(time.substring(0, 1));
         this.min = Integer.parseInt(time.substring(2, 3));
      } else if (time.length() == 4 && time.charAt(1) == ':') {
         this.h = Integer.parseInt(time.substring(0, 1));
         this.min = Integer.parseInt(time.substring(2, 4));
      } else if (time.length() == 4 && time.charAt(2) == ':') {
         this.h = Integer.parseInt(time.substring(0, 2));
         this.min = Integer.parseInt(time.substring(3, 4));
      } else if (time.length() == 5 && time.charAt(2) == ':') {
         this.h = Integer.parseInt(time.substring(0, 2));
         this.min = Integer.parseInt(time.substring(3, 5));
      } else invalidTime = true;
   }

   public Clock add(int min) { // aufaddieren von min zu zulässiger Uhrzeit, Überlauf ist erlaubt
      if (min < 0 || this.h < 0 || this.h >= 24 || this.min < 0 || this.min > 60) return new Clock (-1);
      else {
         int newH = (this.h + (this.min + min) / 60) % 24;
         int newMin = (this.min + min) % 60;
         return new Clock(newH, newMin);
      }
   }

   public Clock add(Clock c) { // falls jeweils zulässig zwei Uhrzeiten addieren (min. 0:00, max. 23:58 mit 1x Überlauf)
      if (this.h < 0 || this.h >= 24 || this.min < 0 || this.min >= 60) return new Clock(-1);
      else if (c.getH() < 0 || c.getH() >= 24 || c.getMin() < 0 || c.getMin() >= 60) return new Clock(-1);
      else {
         int hSum = ((this.h + c.getH()) + (this.min + c.getMin()) / 60) % 24;
         int minSum = (this.min + c.getMin()) % 60;
         return new Clock(hSum, minSum);
      }
   }

   public String toString () { // Entscheidung ob und wie ermittelte Uhrzeit ausgegeben wird
      if (this.h < 0 || this.h >= 24 || this.min < 0 || this.min >= 60) {
         return "Die Zeitangabe liegt außerhalb des Darstellungsbereichs einer üblichen Digitaluhr.";
      }
      else if (invalidTime) return "Die Zeitangabe war ungültig. (Verwenden Sie als Trennzeichen ':'.)";
      else if (this.min < 10) return this.h + ":0" + this.min;
      else return this.h + ":" + this.min;
   }

   public static void main (String[]args){
      // Werte für h < 0 oder h >= 24 bzw. min < 0 oder min >= 60 liefern kein Ergebnis
      System.out.println(new Clock(0, 0));
      System.out.println(new Clock(23, 59));
      // Werte für min < 0 oder min >= 1440 liefern kein Ergebnis
      System.out.println(new Clock(0));
      System.out.println(new Clock(1439));
      // Werte für h < 0 oder h >= 24 bzw. min < 0 oder min >= 60 oder wenn Syntax nicht eingehalten → kein Ergebnis
      System.out.println(new Clock("0:1"));
      System.out.println(new Clock("7:34"));
      System.out.println(new Clock("11:5"));
      System.out.println(new Clock("23:59"));
      // Werte für h < 0 oder h >= 24 bzw. min < 0 oder min >= 60 oder wenn aufaddierte min < 0 → kein Ergebnis
      Clock clock1 = new Clock(16, 12);
      System.out.println(clock1.add(1907));
      // Werte für h < 0 oder h >= 24 bzw. min < 0 oder min >= 60 für beide aufaddierten Uhren → kein Ergebnis
      Clock clock2 = new Clock(23, 59);
      Clock clock3 = new Clock(23, 59);
      Clock clock4 = clock2.add(clock3);
      System.out.println(clock4);
   }
}