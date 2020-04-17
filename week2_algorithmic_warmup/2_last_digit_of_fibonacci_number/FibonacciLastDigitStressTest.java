import java.util.*;
import java.util.stream.IntStream;

public class FibonacciLastDigitStressTest {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n-1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;

    }
    
    public static void main(String[] args) {
        IntStream.range(0, 20).forEach(i -> {
            long fibLastDigfast = getFibonacciLastDigitFast(i);
            long fibLastDig = getFibonacciLastDigitNaive(i); 
            if (fibLastDigfast != fibLastDig) {
                System.out.printf("Error calculating %d number of fib. Result1: %d, Result2: %d \n", i, fibLastDigfast, fibLastDig);
            }
        });
    }

    
}

