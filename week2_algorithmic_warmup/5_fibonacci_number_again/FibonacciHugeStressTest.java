import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class FibonacciHugeStressTest {
    private static long getFibonacciHugeNaive(long n, long m) {
        
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getPisanoPeriod(long m) {

        long previous = 0;
        long current = 1;

        for (long i = 0; i < m*m; ++i) {
            long tmp = previous;
            previous = current % m;
            current = (tmp + current) % m;
            
            //Trick is that Pisano period always starts with 0 and 1.
            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }

        return current;
    }

    private static long getFibonacciHugeFast(long n, long m) {
        if (n <= 1) return n;
        
        // There is a periodic sequence when we need to find F(n) % m. 
        // Let's find length of periodic sequence
        long pisanoPeriod = getPisanoPeriod(m);
        System.out.printf("pisano period for %d is %d \n", m, pisanoPeriod);
        // Let's find n%pisanoPeriod
        long index = n % pisanoPeriod;
        System.out.printf("index %d \n", index);

        // Values for 0th and 1st index are 0 and 1.
        if (index <= 1) return index;

        long previous = 0;
        long current  = 1;
        for (long i = 2; i < index+1; ++i) {
            long tmp_previous = previous % m;
            previous = current % m;
            current = (tmp_previous + current) % m;
        }

        System.out.printf("current %d \n", current);
        return current;

    }

    
    public static void main(String[] args) {
        int counter = 50;
        while (counter > 0) {
            long n = ThreadLocalRandom.current().nextLong(1, 100);
            long m = ThreadLocalRandom.current().nextInt(1,100);
            System.out.printf("Numbers n:%d m:%d \n", n, m);
            long fastSoluction = getFibonacciHugeFast(n, m);
            long naiveSolution = getFibonacciHugeNaive(n, m);

            System.out.printf("Fast result %d \n", fastSoluction);
            System.out.printf("Naive result %d \n", naiveSolution);
            if (fastSoluction != naiveSolution) {
                System.out.println("Error!");
                break;
            }
            System.out.println();
            counter --;
        }
   }
}

