package Uebung7.Geometry;

class Point implements Movable {
   private int x;
   private int y;
   
   public int getX() { return this.x; }
   public int getY() { return this.y; }

   public Point(int x, int y) { this.x = x; this.y = y; }

   public String toString() { return "P(" + this.x + ", " + this.y + ")"; }

   public double distance(Point p) {
      return Math.sqrt((p.getX() - this.x) * (p.getX() - this.x) + (p.getY() - this.y) * (p.getY() - this.y));
   }

   @Override
   public void translate(int dx, int dy) { this.x += dx; this.y += dy; }
}