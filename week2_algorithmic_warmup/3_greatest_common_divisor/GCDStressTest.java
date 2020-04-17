import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GCDStressTest {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  private static int gcd_fast(int a, int b) {
    if (b == 0) return a;
    if (a == 0) return b;
    
    if (a > b) return gcd_fast(a%b, b);
    else return gcd_fast(a, b%a);
  }

  public static void main(String[] args) {
    int counter = 50;
      while (counter > 0) {
        int firstNumber = ThreadLocalRandom.current().nextInt(1,1000000);
        int secondNumber = ThreadLocalRandom.current().nextInt(1,1000000);
        System.out.printf("Numbers %d %d", firstNumber, secondNumber);
        int fastSoluction = gcd_fast(firstNumber, secondNumber);
        int naiveSolution = gcd_naive(firstNumber, secondNumber);

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
