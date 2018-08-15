import java.io.*;
import java.util.*;
import java.math.*;

class Goldmine{
	private static int findMaxGold(int n, int[][] mine, int[][] dp){
		for(int col=n-1;col>=0;col--){
			for(int row=0;row<n;row++){
				int right = (col==n-1)? 0 : dp[row][col+1];
				int rightUp = (col==n-1 || row==0)? 0 : dp[row-1][col+1];
				int rightDown = (col==n-1 || row==n-1)? 0 : dp[row+1][col+1];
				dp[row][col] = mine[row][col]+Math.max(right,Math.max(rightUp,rightDown));
			}
		}

		int result = 0;
		for(int i=0;i<n;i++){
			result = Math.max(dp[i][0],result);
		}
		return result;
	}
	private static int findGold(int n, int[][] mine){
		int[][] dp = new int[n][n];
		return findMaxGold(n,mine,dp);
	}
	public static void main(String args[]){
		int n = 3;
		int[][] mine = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				mine[i][j] = i+j+1;
			}
		}

		System.out.println(findGold(n,mine));
	}
}