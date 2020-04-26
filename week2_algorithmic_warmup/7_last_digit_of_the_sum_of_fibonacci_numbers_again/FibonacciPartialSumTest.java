import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.math.BigInteger;

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

    private static long getFibonacciPartialSumFast1(BigInteger bigFrom, BigInteger bigTo) {
        
        int f = bigFrom.mod(BigInteger.valueOf(60)).intValue();
        int t = bigTo.mod(BigInteger.valueOf(60)).intValue();
        int from;
        int to;

        if (f > t) {
            from = f;
            to = t;
        } else {
            from = t;
            to = f;
        }
        
        int sum = 0;
        int current = 0;
        int next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                 sum = (sum + current) % 10;
            }

            int new_current = next % 10;
            next = next + current % 10;
            current = new_current % 10;
        }

        return sum;
    }


    private static long getFibonacciPartialSumFast2(BigInteger bigFrom, BigInteger bigTo) {
        
        int from = bigFrom.mod(BigInteger.valueOf(60)).intValue();
        int to = bigTo.mod(BigInteger.valueOf(60)).intValue();
        // int from;
        // int to;

           int fs = 0;
        int ts = 0;
        int current = 0;
        int next  = 1;


        if (from <= to) {
            for (long i = 0; i <= to; ++i) {
                if (i < from ) {
                    fs = (fs + current) % 10;
                } 
                ts = (ts + current) % 10;
                int new_current = next % 10;
                next = next + current % 10;
                current = new_current % 10;
            }
            System.out.printf("from %d, to %d \n", from, to);
            System.out.printf("fs %d, ts %d \n", fs, ts);
            if (ts < fs) {
                return 10 +ts - fs;
            } else return ts - fs;
        } else {
            System.out.printf("Hellp");
            for (long i = 0; i < from; ++i) {
                if (i <= to) {
                    fs = (fs + current) % 10;
                } 
                ts = (ts + current) % 10;
                int new_current = next % 10;
                next = next + current % 10;
                current = new_current % 10;
            }
            System.out.printf("from %d, to %d \n", from, to);
            System.out.printf("fs %d, ts %d %d \n", fs, ts, fs-ts);
            if (fs < ts) {
                return 10 +fs - ts;
            } else return fs - ts;
        }
        
       
    }

    private  static int fibSum(int n) {
        if (n <= 1)
            return n;

        int prev = 0;
        int cur = 1;
        int sum = 1;


        for (int i = 0; i < n-1; ++i) {
            int tmp = prev;
            prev = cur;
            cur += tmp;
            sum += cur;
        }

        System.out.printf("Sum: %d \n", sum);  
        return sum;  
    }


    public static void main(String[] args) {
        int counter = 50;
        while (counter > 0) {
            // int firstNumber = ThreadLocalRandom.current().nextInt(0,100);
            // int secondNumber = ThreadLocalRandom.current().nextInt(firstNumber,100);

            fibSum(9);  
            fibSum(20);  
            BigInteger firstNumber = BigInteger.valueOf(5618252);
            BigInteger secondNumber = new BigInteger("6583591534156");
        
            System.out.printf("Numbers are %d, %d \n", firstNumber, secondNumber); 
            // long fastSoluction = getFibonacciPartialSumFast(firstNumber, secondNumber);
            // long naiveSolution = getFibonacciPartialSumNaive(firstNumber, secondNumber);
            long fastSoluction1 = getFibonacciPartialSumFast2(firstNumber, secondNumber);

            System.out.println();
            System.out.printf("Fast result %d \n", fastSoluction1);
            //System.out.printf("Naive result %d \n", naiveSolution);
            // if (fastSoluction != naiveSolution) {
            //     System.out.println("Error!");
            //     break;
            // }
            break;
            //counter --;
        }
    }
}

