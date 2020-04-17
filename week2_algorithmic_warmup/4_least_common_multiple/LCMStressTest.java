import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LCMStressTest {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm_fast(int a, int b) {
    long max = (long) a > b ? a : b;
    long min = (long) a < b ? a : b;

    for (long i = 1; i < min; i++) {
      if (max*i % min == 0)
        return max*i;
    }
    return (long) a*b;
  }

  public static void main(String args[]) {
    int counter = 50;
      while (counter > 0) {
        int firstNumber = ThreadLocalRandom.current().nextInt(1,10000);
        int secondNumber = ThreadLocalRandom.current().nextInt(1,10000);
        System.out.printf("Numbers %d %d", firstNumber, secondNumber);
        long fastSoluction = lcm_fast(firstNumber, secondNumber);
        long naiveSolution = lcm_naive(firstNumber, secondNumber);

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
