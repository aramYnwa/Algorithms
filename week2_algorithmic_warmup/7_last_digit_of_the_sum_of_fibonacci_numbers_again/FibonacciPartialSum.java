import java.util.*;
import java.math.BigInteger;

public class FibonacciPartialSum {
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

    private static long getFibonacciPartialSumFast(BigInteger bigFrom, BigInteger bigTo) {
        
        BigInteger f = bigFrom.mod(BigInteger.valueOf(60));
        BigInteger t = bigTo.mod(BigInteger.valueOf(60));
        int from;
        int to;
        if (f.compareTo(t) < 1) {
            from = f.intValue();
            to = t.intValue();
        } else {
            from = bigFrom.intValue();
            to = bigTo.intValue();
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger from = scanner.nextBigInteger();
        BigInteger to = scanner.nextBigInteger();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

