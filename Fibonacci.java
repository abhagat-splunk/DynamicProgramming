import java.util.*;
import java.io.*;
class Fibonacci{
	private static int findFibo(int n, int[] fibo){
		if(fibo[n]!=0){
			return fibo[n];
		}
		else{
			fibo[n-1] = findFibo(n-1,fibo);
			fibo[n-2] = findFibo(n-2,fibo);
			return fibo[n] = fibo[n-1] + fibo[n-2];
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fibo = new int[n+1];
		fibo[0] = 1;
		fibo[1] = 1;
		System.out.println(findFibo(n-1,fibo));
	}
}