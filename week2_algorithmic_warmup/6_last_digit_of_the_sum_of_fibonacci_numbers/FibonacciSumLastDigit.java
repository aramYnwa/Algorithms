import java.util.*;

public class FibonacciSumLastDigit {
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
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

