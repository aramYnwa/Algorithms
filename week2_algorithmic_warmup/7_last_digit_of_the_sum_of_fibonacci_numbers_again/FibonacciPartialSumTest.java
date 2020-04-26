import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciPartialSumTest {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }


    private static long getFibonacciPartialSumFast(long from, long to) {
        
        if (from >= 60 && to >= 60) {
            from = from % 60;
            to = to % 60;
        }

        long sum = 0;
        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                 sum = (sum + current) % 10;
            }

            long new_current = next % 10;
            next = next + current % 10;
            current = new_current % 10;
        }

        return sum;
    }



    public static void main(String[] args) {
        int counter = 50;
        while (counter > 0) {
            // int firstNumber = ThreadLocalRandom.current().nextInt(0,100);
            // int secondNumber = ThreadLocalRandom.current().nextInt(firstNumber,100);

            int firstNumber = 10;
            int secondNumber = 200;
        
            System.out.printf("Numbers are %d, %d \n", firstNumber, secondNumber); 
            long fastSoluction = getFibonacciPartialSumFast(firstNumber, secondNumber);
            long naiveSolution = getFibonacciPartialSumNaive(firstNumber, secondNumber);

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

