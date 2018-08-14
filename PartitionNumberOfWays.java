import java.util.*;
import java.io.*;
class PartitionNumberOfWays{
	private static int findNumberOfWays(int n, int k){
		int[][] dp = new int[n+1][n+1];
		for(int i=0;i<=n;i++){
			dp[i][0] = 0;
		}
		for(int i=0;i<=n;i++){
			dp[0][i] = 0;
		}

		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				//One partition or all partitions with single element
				if(j==1||i==j){
					dp[i][j] = 1;
				}
				else{
					dp[i][j] = dp[i-1][j-1]+j*dp[i-1][j];
				}
			}
		}
		return dp[n][k];
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(findNumberOfWays(n,k));
	}
}