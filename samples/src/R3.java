import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ManyFormulas game = new ManyFormulas();
		game.run();
	}
}

class ManyFormulas {
	
	String S;
	String[] nums;
	
	ManyFormulas() {
		Scanner cin = new Scanner(System.in);
		this.S = cin.nextLine();
		this.nums = new String[S.length()];
		char[] tmp = S.toCharArray();
		for (int i = 0; i < S.length(); i++) {
			nums[i] = String.valueOf(tmp[i]);
		}
	}
	
	void run() {
		boolean[] contained = new boolean[nums.length];
		long allSum = dfs(0, contained);
		System.out.println(allSum);
	}
	
	long dfs(int depth, boolean[] contained) {
		if (depth == nums.length - 1) {
//			contained[contained.length - 1] = false;
			return calculateSum(contained);
		}
		return dfs(depth + 1, copyArray(contained)) + dfs(depth + 1, setFlagAtIndex(contained, depth)); 
	}
	
	long calculateSum(boolean[] contained) {
		long sum = 0;
		long tmpNum = 0;
		int digit = 1;
	
		for (int i = contained.length - 1; i >= 0; i--) {
			if (contained[i]) {
				sum += tmpNum;
				digit = 1;
				tmpNum = 0;
			} 
			tmpNum += Long.valueOf(nums[i]) * digit;
			digit *= 10;
		}
		sum += tmpNum;
		return sum;
	}
	
	boolean[] setFlagAtIndex(boolean[] arr, int index) {
		boolean[] newArr = copyArray(arr);
		newArr[index] = true;
		return newArr;
	}
	
	boolean[] copyArray(boolean[] arr) {
		boolean[] newArr = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	void printArray(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
