import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class IteratingExamples {
    public static void test() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Integer sum = IteratingExamples.Act2Iterator(integers);
        System.out.format("SUM1 = %d\n", sum);
        sum = IteratingExamples.Act2ForEach(integers);
        System.out.format("SUM2 = %d\n", sum);
    }

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        // Insert code here to sum up input using an Iterator ...
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    public static int Act2ForEach(List<Integer> integers) {
        LongAdder sum = new LongAdder();
        integers.forEach((number) -> {
            sum.add(number);
        });
        return (int) sum.sum();
    }
}
