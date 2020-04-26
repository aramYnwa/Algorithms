import java.util.*;

public class FibonacciSumSquares {
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
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}

