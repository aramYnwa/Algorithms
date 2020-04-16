import java.util.Scanner;

public class Fibonacci {
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
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_fast(n));
  }
}
