import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    private static boolean debug = false;
    private static boolean elapsed = false;

    private static PrintWriter _out = new PrintWriter(System.out);
    private static PrintWriter _err = new PrintWriter(System.err);

    private void solve(Scanner sc) {
        int N = sc.nextInt();
        int[] a = new int[3 * N];
        for (int i = 0; i < 3 * N; ++i) {
            a[i] = sc.nextInt();
        }

        Queue<Integer> q1 = new PriorityQueue<>();
        long[] sum1 = new long[N + 1];
        for (int i = 0; i < N; ++i) {
            q1.offer(a[i]);
            sum1[0] += a[i];
        }

        Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        long[] sum2 = new long[N + 1];
        for (int i = 2 * N; i < 3 * N; ++i) {
            q2.offer(a[i]);
            sum2[0] += a[i];
        }

        for (int k = N; k < 2 * N; ++k) {
            q1.offer(a[k]);
            int t1 = q1.poll();
            sum1[k - N + 1] = sum1[k - N] + a[k] - t1;

            q2.offer(a[3 * N - k - 1]);
            int t2 = q2.poll();
            sum2[k - N + 1] = sum2[k - N] + a[3 * N - k - 1] - t2;
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i <= N; ++i) {
            max = Math.max(max, sum1[i] - sum2[N - i]);
        }
        _out.println(max);
    }
    private static BigInteger C(long n, long r) {
        BigInteger res = BigInteger.ONE;
        for (long i = n; i > n - r; --i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        for (long i = r; i > 1; --i) {
            res = res.divide(BigInteger.valueOf(i));
        }
        return res;
    }
    private static BigInteger P(long n, long r) {
        BigInteger res = BigInteger.ONE;
        for (long i = n; i > n - r; --i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
    /*
     * 10^10 > Integer.MAX_VALUE = 2147483647 > 10^9
     * 10^19 > Long.MAX_VALUE = 9223372036854775807L > 10^18
     */
    public static void main(String[] args) {
        long S = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        new Main().solve(sc);
        _out.flush();

        long G = System.currentTimeMillis();
        if (elapsed) {
            _err.println((G - S) + "ms");
        }
        _err.flush();
    }
}