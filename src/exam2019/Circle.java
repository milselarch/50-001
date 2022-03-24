package exam2019;

public class Circle {
    private final double x;
    private final double y;
    private final double radius;

    Circle() {
        this(0, 0, 1);
    }

    Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
    public double getPerimeter() {
        return 2.0d * Math.PI * this.radius;
    }

    public boolean contains(double px, double py) {
        double distance = Math.sqrt(
            Math.pow(px - x, 2) + Math.pow(py - y, 2)
        );

        // distance from center less than or equal radius
        return distance <= this.radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
        System.out.println(c.contains(1,0));
        System.out.println(c.contains( new Circle(0.5, 0, 0.3)));
        System.out.println(c.overlaps(new Circle(0,2,0.5)));
        Circle c2 = new Circle(1,1,1);
        System.out.println(c.getArea());
    }

    boolean contains(Circle c) {
        double distance = Math.sqrt(
            Math.pow(c.getX() - this.x, 2) +
            Math.pow(c.getY() - this.y, 2)
        );

        double contain_radius = this.radius - c.getRadius();
        return distance <= contain_radius;
    }

    boolean overlaps(Circle c) {
        double distance = Math.sqrt(
            Math.pow(c.getX() - this.x, 2) +
            Math.pow(c.getY() - this.y, 2)
        );

        double min_radius = Math.min(this.radius, c.getRadius());
        return distance <= min_radius;
    }



    double getX() { return this.x; }
    double getY() { return this.y; }
    double getRadius() { return this.radius; }


}
