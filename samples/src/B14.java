import java.util.Scanner;
public class Main{

	public static void main(String[] args){
		//writeInput();
		solve();
		}

	public static void solve(){
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.next());
		int M = Integer.parseInt(sc.next());

		boolean[] isFrom1 = new boolean[N];
		boolean[] isFromN = new boolean[N];

		for(int i = 0;i<M;i++){
			int ai = Integer.parseInt(sc.next());
			int bi = Integer.parseInt(sc.next());
			if(ai==1){
				isFrom1[bi]=true;
			}
			if(bi==N){
				isFromN[ai]=true;
			}
		}
		//System.out.println(M);
		boolean routeExists =false;for(int i=0;i<N;i++)routeExists|=(isFrom1[i]&&isFromN[i]);
		answer(routeExists);
		sc.close();

	}

	public static void answer(boolean b){
		String yes =new String("POSSIBLE");
		String no =new String("IMPOSSIBLE");
		System.out.println(b?yes:no);
	}


/*	public static void writeInput(){
		try{
			File file = new File("c:\\Users\\jugem\\Documents\\pleiades\\input.dat");
			if (checkBeforeWritefile(file)){
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				pw.println("5 5");
				pw.println("1 3");
				pw.println("2 3");
				pw.println("2 4");
				pw.println("4 5");
				pw.println("1 4");
				pw.close();
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public static boolean checkBeforeWritefile(File f){
		return f.exists()?(f.isFile()&&f.canWrite()):false;
	}
*/
}
