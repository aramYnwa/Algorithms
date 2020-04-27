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
        
        int from = bigFrom.mod(BigInteger.valueOf(60)).intValue();
        int to = bigTo.mod(BigInteger.valueOf(60)).intValue();
    
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
            if (ts < fs) {
                return 10 +ts - fs;
            } else return ts - fs;
        } else {
            for (long i = 0; i < from; ++i) {
                if (i <= to) {
                    fs = (fs + current) % 10;
                } 
                ts = (ts + current) % 10;
                int new_current = next % 10;
                next = next + current % 10;
                current = new_current % 10;
            }
            if (fs < ts) {
                return 10 +fs - ts;
            } else return fs - ts;
        }
        
       
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger from = scanner.nextBigInteger();
        BigInteger to = scanner.nextBigInteger();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}

