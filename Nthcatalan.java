import java.util.*;
import java.io.*;
class Nthcatalan{
	private static int findCatalan(int n){
		int[] catalan = new int[n+1];
		catalan[0] = catalan[1] = 1;
		for(int i=2;i<=n;i++){
			catalan[i] = 0;
			for(int j=0;j<i;j++){
				catalan[i] += catalan[j] * catalan[i-j-1];
			}
		}
		return catalan[n];
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findCatalan(n));
	}
}