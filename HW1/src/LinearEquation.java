public class LinearEquation {
    private final double a, b, c, d, e, f;

    LinearEquation(
        double a, double b, double c, double d, double e, double f
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    boolean isSolvable() {
        return a * d - b * c != 0;
    }

    double getX() {
        double num = this.e / this.a - (this.b * this.f) / (this.a * this.d);
        double denom = 1.0 - this.b * this.c / (this.a * this.d);
        return num / denom;
    }

    double getY() {
        double x = this.getX();
        return (1 / this.d) * (this.f - this.c * x);
    }

    static void test() {
        double a = 1.0; double b = 2.0; double c = 3.0;
        double d = 5.0; double e = 6.0; double f = 7.0;

        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        if (equation.isSolvable()) {
            System.out.println("x is " +
                    equation.getX() + " and y is " + equation.getY());
        }
        else {
            System.out.println("The equation has no solution");
        }

        LinearEquation equation2 = new LinearEquation(
            1.25, 2.0, 2.0, 4.2, 3.0, 6.0
        );
        if (equation2.isSolvable()) {
            System.out.println(
                "x is " + equation2.getX() + " y is " + equation2.getY()
            );
        }

        LinearEquation equation3 = new LinearEquation(
            1.0, 2.0, 2.0, 4.0, 3.0, 6.0
        );
        System.out.println(equation3.isSolvable());
    }

    double get_a() {
        return this.a;
    }
    double get_b() {
        return this.b;
    }
    double get_c() {
        return this.c;
    }
    double get_d() {
        return this.d;
    }
    double get_e() {
        return this.e;
    }
    double get_f() {
        return this.f;
    }
}
