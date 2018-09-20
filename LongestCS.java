class LongestCS{
	private static int lcs(String x, String y, int m, int n){
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					dp[i][j] = 0;
				}
				else if(x.charAt(i-1)==y.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	private static int lcsNoDP(String x, String y, int i, int j){
		if(i==0 || j==0){
			return 0;
		}
		else if(x.charAt(i-1)==y.charAt(j-1)){
			return 1 + lcsNoDP(x,y,i-1,j-1);
		}
		else{
			return Math.max(lcsNoDP(x,y,i-1,j), lcsNoDP(x,y,i,j-1));
		}
	}
	public static void main(String[] args){
		String x = "AGGTAB";
		String y = "GXTXAYB";
		System.out.println(lcsNoDP(x,y,x.length(),y.length()));
		System.out.println(lcs(x,y,x.length(),y.length()));
	}
}