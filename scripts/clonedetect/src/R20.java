import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
 
public class Main {
 
	public static void main(String[] args) {
		IO io = new IO();
		int n = io.nextInt();
		int m = io.nextInt();
		BIT bit = new BIT(m+2);
		LR[] lr = new LR[n];
		for(int i=0;i<n;i++) {
			lr[i] = new LR(io.nextInt(),io.nextInt());
		}
		Arrays.sort(lr,(p1,p2)->Integer.compare(p1.r-p1.l, p2.r-p2.l));
		int idx = 0;
		for(int d=1;d<=m;d++) {
			while(idx<n && lr[idx].r - lr[idx].l < d) {
				bit.accumulate(lr[idx].l, lr[idx].r+1, 1);
				idx++;
			}
			int ans = n - idx;
			if (idx > 0) {
				for(int i=0;i<=m;i+=d) {
					ans += bit.get(i);
				}
			}
			io.println(ans);
		}
		io.flush();
	}
}
class LR {
	int l,r;
 
	public LR(int l, int r) {
		super();
		this.l = l;
		this.r = r;
	}
	
}
class BIT {
	private int n;
	private long[] bit;
	public BIT(int n) {
		this.n = n;
		bit = new long[n+2];
	}
 
	public void accumulate(int begin,int end,long num) {
		accumulate(begin, num);
		accumulate(end, -num);
	}
 
	private void accumulate(int index,long num) {
		index++;
		while(index<=n+1) {
			bit[index] += num;
			index+=index&-index;
		}
	}
 
	private long sum(int i) {
		long s = 0;
		while(i>0) {
			s+=bit[i];
			i-=i&-i;
		}
		return s;
	}
 
	public long get(int index) {
		return sum(index+1);
	}
 
	public void set(int index,long num) {
		accumulate(index,index+1,num-get(index));
	}
 
	public String toString() {
		long[] value = new long[n];
		for(int i=0;i<n;i++) {
			value[i] = get(i);
		}
		return Arrays.toString(value);
	}
}
 
class IO extends PrintWriter {
	private final InputStream in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;
	
	public IO() { this(System.in);}
	public IO(InputStream source) { super(System.out); this.in = source;}
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		}else{
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}
	private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	private static boolean isNewLine(int c) { return c == '\n' || c == '\r';}
	public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
	public boolean hasNextLine() { while(hasNextByte() && isNewLine(buffer[ptr])) ptr++; return hasNextByte();}
	public String next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public char[] nextCharArray(int len) {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		char[] s = new char[len];
		int i = 0;
		int b = readByte();
		while(isPrintableChar(b)) {
			if (i == len) {
				throw new InputMismatchException();
			}
			s[i++] = (char) b;
			b = readByte();
		}
		return s;
	}
	public String nextLine() {
		if (!hasNextLine()) {
			throw new NoSuchElementException();
		}
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while(!isNewLine(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while(true){
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			}else if(b == -1 || !isPrintableChar(b)){
				return minus ? -n : n;
			}else{
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
			throw new NumberFormatException();
		}
		return (int) nl;
	}
	public char nextChar() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return (char) readByte();
	}
	public double nextDouble() { return Double.parseDouble(next());}
	public int[] nextIntArray(int n) { int[] a = new int[n]; for(int i=0;i<n;i++) a[i] = nextInt(); return a;}
	public long[] nextLongArray(int n) { long[] a = new long[n]; for(int i=0;i<n;i++) a[i] = nextLong(); return a;}
	public double[] nextDoubleArray(int n) { double[] a = new double[n]; for(int i=0;i<n;i++) a[i] = nextDouble(); return a;}
	public void nextIntArrays(int[]... a) { for(int i=0;i<a[0].length;i++) for(int j=0;j<a.length;j++) a[j][i] = nextInt();}
	public int[][] nextIntMatrix(int n,int m) { int[][] a = new int[n][]; for(int i=0;i<n;i++) a[i] = nextIntArray(m); return a;}
	public char[][] nextCharMap(int n,int m) { char[][] a = new char[n][]; for(int i=0;i<n;i++) a[i] = nextCharArray(m); return a;}
	public void close() { super.close(); try {in.close();} catch (IOException e) {}}
}