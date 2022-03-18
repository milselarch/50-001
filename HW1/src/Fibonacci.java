import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void test() {
        String fib_sequence = Fibonacci.fibonacci(10);
        System.out.println(fib_sequence);
    }

    public static String fibonacci(int n) {
        ArrayList<Integer> values = new ArrayList<>();
        int value;

        for (int k=0; k<n; k++) {
            if (k == 0) {
                value = 0;
            } else if (k <= 2) {
                value = 1;
            } else {
                value = (
                    values.get(values.size()-1) +
                    values.get(values.size()-2)
                );
            }
            values.add(value);
        }

        StringBuilder result = new StringBuilder();

        for (int k=0; k<n; k++) {
            value = values.get(k);
            if (k != 0) { result.append(","); }
            result.append(value);
        }

        return result.toString();
    }
}