import java.util.*;

public class LCM {
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
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
