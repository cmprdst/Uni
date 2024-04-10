package Uebung7.Geometry;

class Triangle implements Movable {
    private Point a;
    private Point b;
    private Point c;

    private Point getA() { return a; }
    private Point getB() { return b; }
    private Point getC() { return c; }

    private Point[] getPoints() { return new Point[]{a, b, c}; }

    public Triangle(Point a, Point b, Point c) { this.a = a; this.b = b; this.c = c; }

    public String toString() {
        if (a.getX() == b.getX() && a.getY() == b.getY() && a.getX() == c.getX() && a.getY() == c.getY())
            return "All points are equal and do not make up a triangle. The point is " + getPoints()[0] + ".";
        if (a.getX() == b.getX() && a.getY() == b.getY() || b.getX() == c.getX() && b.getY() == c.getY())
            return "Two points are equal and only make up a line. " + new Line(getPoints()[0], getPoints()[2]);
        else if (a.getX() == c.getX() && a.getY() == c.getY())
            return "Two points are equal and only make up a line. " + new Line(getPoints()[0], getPoints()[1]);
        else return "The three points make up a triangle with the corners on the following coordinates: "
            + getPoints()[0] + ", " + getPoints()[1] + ", " +  getPoints()[2] + ".";
    }

    public double perimeter() { return getA().distance(getB()) + getB().distance(getC()) + getC().distance(getA()); }

    @Override
    public void translate(int dx, int dy) {
        this.a = new Point(a.getX() + dx, a.getY() + dy);
        this.b = new Point(b.getX() + dx, b.getY() + dy);
        this.c = new Point(c.getX() + dx, c.getY() + dy);
    }
}