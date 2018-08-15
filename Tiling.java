class Tiling{
	private static int findTilingWays(int n, int[] dp){
		if(dp[n]!=-1){
			return dp[n];
		}
		else{
			dp[n] = findTilingWays(n-1,dp) + findTilingWays(n-2,dp);
		}
		return dp[n];
	}
	private static int findWays(int n){
		int[] dp = new int[n+1];
		for(int i=0;i<=n;i++){
			dp[i] = -1;
		}
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		return findTilingWays(n,dp);
	}
	public static void main(String args[]){
		int n = 3;
		System.out.println(findWays(n));

	}
}