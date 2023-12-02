package Uebung7.Geometry;

class Line implements Movable {
   private Point start;
   private Point end;

   public Point getStart() { return start; }
   public Point getEnd() { return end; }

   public Line(Point start, Point end) { this.start = start; this.end = end; }

   public String toString() {
      if (start.getX() == end.getX() && start.getY() == end.getY())
         return "Both points are equal thus not making up a line. The point is " + this.start + ".";
      else return "The line starts at point " + this.start + " and ends at point " + this.end + ".";
   }

   public double length() { return getStart().distance(getEnd()); }

   @Override
   public void translate(int dx, int dy) {
      this.start = new Point(start.getX() + dx, start.getY() + dy);
      this.end = new Point(end.getX() + dx, end.getY() + dy);
   }
}