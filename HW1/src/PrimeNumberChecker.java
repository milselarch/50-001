import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class PrimeNumberChecker{
    ArrayList<Integer> primes = new ArrayList<Integer>();

    public static void main(String[] args) {
        PrimeNumberChecker.test();
        MyRectangle2D.test();
        LinearEquation.test();
        Triangle.test();
        CheckingAccount.test();
        System.out.println("STRING TESTER");
        StringTester.test();
        Fibonacci.test();
        IteratingExamples.test();
    }

    static void test() {
        for (int i=2; i<20; i++) {
            System.out.format(
                "%d prime = %d\n", i, PrimeNumberChecker.isPrime(i)
            );
        }
    }

    public static int isPrime(int num){
        for (int i=2; i<sqrt(num+1); i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
