import java.io.*;
import java.util.*;
 
public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;
 
  private static PrintWriter _err = new PrintWriter(System.err);
 
  private long sum;
 
  private void solve(Scanner sc, PrintWriter out) {
    String s = sc.nextLine();
 
    search(0, s, new boolean[s.length() - 1]);
 
    out.println(sum);
  }
  private void search(int d, String s, boolean[] b) {
    if (d == b.length) {
      calc(s, b);
      return;
    }
    for (int j = 0; j < 2; ++j) {
      b[d] = (j == 0);
      search(d + 1, s, b);
      b[d] = false;
    }
  }
  private void calc(String s, boolean[] b) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      sb.append(s.charAt(i));
      if (i < b.length && b[i]) {
        sum += Long.parseLong(sb.toString());
        sb = new StringBuilder();
      }
    }
    sum += Long.parseLong(sb.toString());
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