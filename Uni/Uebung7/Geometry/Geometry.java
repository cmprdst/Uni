package Uebung7.Geometry;

class Geometry {
   public static void main(String[] args) {
      Point testPoint = new Point(-1, 2);
      System.out.println(testPoint);
      System.out.println(testPoint.distance(new Point(3, -1)));
      testPoint.translate(3, 4);
      System.out.println(testPoint);
      System.out.println();

      Line testLine = new Line(new Point(-1, 2), new Point(3, -1));
      Line testLineEqual = new Line(new Point(-1, 2), new Point(-1, 2));
      System.out.println(testLine);
      System.out.println(testLineEqual);
      System.out.println(testLine.length());
      System.out.println(testLineEqual.length());
      testLine.translate(3, 4);
      System.out.println(testLine);
      System.out.println();

      Triangle testTriangle = new Triangle(new Point(-1, 2), new Point(3, -1), new Point(-1, -1));
      Triangle testTriTwoEqual = new Triangle(new Point(-1, 2), new Point(-1, 2), new Point(-1, -1));
      Triangle testTriAllEqual = new Triangle(new Point(-1, 2), new Point(-1, 2), new Point(-1, 2));
      System.out.println(testTriangle);
      System.out.println(testTriTwoEqual);
      System.out.println(testTriAllEqual);
      System.out.println(testTriangle.perimeter());
      System.out.println(testTriTwoEqual.perimeter());
      System.out.println(testTriAllEqual.perimeter());
      testTriangle.translate(3, 4);
      System.out.println(testTriangle);
   }
}