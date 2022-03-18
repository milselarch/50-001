import static java.lang.Math.sqrt;

public class Triangle extends GeometricObject {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    Triangle() {
        super();
    }
    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        // https://www.cuemath.com/measurement/area-of-triangle-with-3-sides/
        double s = (this.side1 + this.side2 + this.side3) / 2;
        double area = s * (s-this.side1) * (s-this.side2) * (s-this.side3);
        return sqrt(area);
    }

    public double getPerimeter() {
        return (this.side1 + this.side2 + this.side3);
    }

    public static void test() {
        Triangle myTri = new Triangle();
        myTri.setColor("red");
        myTri.setFilled(true);
        System.out.println(myTri);
        System.out.println(myTri.isFilled());

        Triangle myTri2 = new Triangle(2.0, 4.0, 5.5);
        System.out.println(myTri2);
        System.out.println(
            "area : " + myTri2.getArea() +
            " perimeter: " + myTri2.getPerimeter()
        );
    }

    @Override
    public String toString() {
        return (
            "Triangle: " +
            "side1 = " + side1 +
            " side2 = " + side2 +
            " side3 = " + side3
        );
    }
}
