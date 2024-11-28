import java.io.*;
import java.util.*;
 
public class Main {
  private static boolean debug = false;
  private static boolean elapsed = false;
 
  private static PrintWriter _err = new PrintWriter(System.err);
 
  private void solve(Scanner sc, PrintWriter out) {
    String s = sc.nextLine();
 
    int score = 0;
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      char hand = (i % 2 == 0 ? 'g' : 'p');
      if (ch == 'g' && hand == 'p') {
        ++score;
      } else if (ch == 'p' && hand == 'g') {
        --score;
      }
    }
    out.println(score);
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