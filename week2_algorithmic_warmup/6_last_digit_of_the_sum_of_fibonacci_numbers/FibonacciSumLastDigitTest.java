import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciSumLastDigitTest {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciSumFast(long n) {
        
        //There is a period with length 60.
        long index = n % 60;

         if (index <= 1)
            return index;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < index-1; ++i) {
            long tmp = previous;
            previous = current;
            current = (current + tmp);
            sum = (sum + current) % 10;
        } 

        return sum;    
    }

      public static void main(String[] args) {
        int counter = 100;
        long i = 0;
        while (counter > 0) {
            //long n = ThreadLocalRandom.current().nextLong(1, 100);
            long n = i;
            System.out.printf("Number n:%d \n", n);
            long fastSolution = getFibonacciSumFast(n);
            long naiveSolution = getFibonacciSumNaive(n);

            System.out.printf("Fast result %d \n", fastSolution);            
            System.out.printf("Naive result %d \n", naiveSolution);
            if (fastSolution != naiveSolution) {
                System.out.println("Error!");
                break;
            }
            System.out.println();
            counter --;
            i ++;
        }
   }
}

