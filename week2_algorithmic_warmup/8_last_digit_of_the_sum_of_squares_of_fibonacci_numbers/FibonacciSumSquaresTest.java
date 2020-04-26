import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciSumSquaresTest {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquaresFast(long n) {
        if (n <= 1)
            return  n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n; ++i) {
            int tmp_previous = previous % 10;
            previous = current % 10;
            current = (tmp_previous + current) % 10;
        }

        System.out.printf("res: %d", (previous * current));
        return (previous * current) % 10;    
    }
    
    public static void main(String[] args) {
        int counter = 50;
        while (counter > 0) {
            //int number = ThreadLocalRandom.current().nextInt(1, 100);
            int number = 2;
        
            System.out.printf("Number is %d \n", number); 
            long fastSoluction = getFibonacciSumSquaresFast(number);
            long naiveSolution = getFibonacciSumSquaresNaive(number);

            System.out.println();
            System.out.printf("Fast result %d \n", fastSoluction);
            System.out.printf("Naive result %d \n", naiveSolution);
            if (fastSoluction != naiveSolution) {
                System.out.println("Error!");
                break;
            }

            counter --;
        }
    }
}

