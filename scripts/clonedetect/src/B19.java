import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Here your code !
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmpArray = br.readLine().split(" ");
        int m = Integer.parseInt(tmpArray[0]);
        int n = Integer.parseInt(tmpArray[1]);
        
        //System.out.println("m "+m+" n "+n);
        
        if(m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        if(m - n >= 2){
            System.out.println(0);
        }
        else {
            int combination;
            
            if(m == n){
                combination = 2;
            }
            else {
                combination = 1;
            }
            int mod = 1000000007;
            System.out.println((long)(Calc.Fact(m,mod) * Calc.Fact(n,mod) * combination)%mod);
        }
    }
}

class Calc {
    static long Fact(int n){
        long result = 1;
        for(int i = n; i >= 1;i--){
            result *= i;
        }
        
        System.out.println("fact("+n+") = "+result);
        return result;
    }
    
    static long Fact(int n, int mod){
        long result = 1;
        for(int i = n; i >= 1;i--){
            result *= i;
            result %= mod;
        }
        
        //System.out.println("fact("+n+") = "+result);
        return result;
    }
    
    static int combination(int n, int p){
        
        
        int result = 1;
        /*
        if(n - p < p){
            p = n-p;
        }
        
        for(int i = p; i > 1; i--){
            
        }*/
        
        return result;
    }
}