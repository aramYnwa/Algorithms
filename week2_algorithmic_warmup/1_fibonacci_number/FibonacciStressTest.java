import java.util.Scanner;
import java.util.stream.IntStream;

public class FibonacciStressTest {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_fast(int n) { 
    if (n <= 1)
      return n;
    
    long[] numbers = new long[n+1];
    numbers[0] = 0;
    numbers[1] = 1;
  
    IntStream.range(2, n+1).forEach(
      i -> numbers[i] = numbers[i-1] + numbers[i-2]
    );
    return numbers[n];
  }

  public static void main(String args[]) {
    IntStream.range(0, 20).forEach(i -> {
       long fibfast = calc_fib_fast(i);
       long fib = calc_fib(i); 
       if (fibfast != fib) {
         System.out.printf("Error calculating %d number of fib. Result1: %d, Result2: %d \n", i, fibfast, fib);
       }
    });
  }
}
