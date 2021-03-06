import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProductFast(long[] numbers) {

        long firstMax = -1;
        long secondMax = -1;
        long firstMaxInd = -1;
        long secondMaxInd;

        //Find first biggest element
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] > firstMax) {
                firstMax = numbers[i];
                firstMaxInd = i;    
            }
        }

        //Find the second biggest element
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] > secondMax && i != firstMaxInd) {
                secondMax = numbers[i];
                secondMaxInd = i;    
            }
        }
        
        return firstMax * secondMax;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
