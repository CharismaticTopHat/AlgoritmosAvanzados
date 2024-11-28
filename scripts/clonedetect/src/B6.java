import java.io.*;
import java.util.*;

public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;

  private static PrintWriter _err = new PrintWriter(System.err);

  private void solve(Scanner sc, PrintWriter out) {
    int N = sc.nextInt();
    long[] count = new long[2];
    for (int i = 0; i < N; ++i) {
      int T = sc.nextInt();
      int A = sc.nextInt();

      if (i == 0) {
        count[0] = T;
        count[1] = A;
        continue;
      }

      long n = Math.max((count[0] + T - 1) / T, (count[1] + A - 1) / A);
      count[0] = T * n;
      count[1] = A * n;
    }

    out.println((count[0] + count[1]));
  }
  private long C(long n, long r) {
    long res = 1;
    for (long i = n; i > n - r; --i) {
      res *= i;
    }
    for (long i = r; i > 1; --i) {
      res /= i;
    }
    return res;
  }
  private long P(long n, long r) {
    long res = 1;
    for (long i = n; i > n - r; --i) {
      res *= i;
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
    PrintWriter out = new PrintWriter(System.out);
    new Main().solve(sc, out);
    out.flush();

    long G = System.currentTimeMillis();
    if (elapsed) {
      _err.println((G - S) + "ms");
    }
    _err.flush();
  }
}