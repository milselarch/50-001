public class MyRectangle2D {
    double x;
    double y;
    double width;
    double height;

    MyRectangle2D() {
        this.setX(0);
        this.setY(0);
        this.setWidth(1);
        this.setHeight(1);
    }

    MyRectangle2D(double x, double y, double width, double height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    double getArea() {
        return this.width * this.height;
    }
    double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    static void test() {
        MyRectangle2D rect1, rect2;
        rect1 = new MyRectangle2D(10, 10, 20, 20);
        rect2 = new MyRectangle2D(11, 11, 18, 18);
        System.out.format("A in rect %b\n", rect1.contains(rect2));
        System.out.format("A in rect %b\n", rect1.overlaps(rect2));
        rect1 = new MyRectangle2D(10, 10, 20, 20);
        rect2 = new MyRectangle2D(11, 11, 20, 20);
        System.out.format("B in rect %b\n", rect1.contains(rect2));
        System.out.format("B in rect %b\n", rect1.overlaps(rect2));
    }

    boolean contains(double x, double y) {
        return (
            (this.width / 2.0 + this.x >= x) &&
            (x >= this.x - this.width / 2) &&
            (this.height / 2.0 + this.y >= y) &&
            (y >= this.y - this.height / 2)
        );
    }
    boolean contains(MyRectangle2D other) {
        return (
            this.contains(
                other.x + other.width / 2.0, other.y + other.height / 2.0
            ) && this.contains(
                other.x - other.width / 2.0, other.y + other.height / 2.0
            ) && this.contains(
                other.x + other.width / 2.0, other.y - other.height / 2.0
            ) && this.contains(
                other.x - other.width / 2.0, other.y - other.height / 2.0
            )
        );
    }
    boolean overlaps(MyRectangle2D other) {
        return (
            this.contains(
                other.x + other.width / 2.0, other.y + other.height / 2.0
            ) || this.contains(
                other.x - other.width / 2.0, other.y + other.height / 2.0
            ) || this.contains(
                other.x + other.width / 2.0, other.y - other.height / 2.0
            ) || this.contains(
                other.x - other.width / 2.0, other.y - other.height / 2.0
            )
        );
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
}
