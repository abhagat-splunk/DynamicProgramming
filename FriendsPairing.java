class FriendsPairing{
	private static int numberOfPairs(int n, int[] dp){
		if(dp[n]!=0){
			return dp[n];
		}
		else if(n<=2){
			return n;
		}
		else{
			return dp[n] = numberOfPairs(n-1,dp) + (n-1)*numberOfPairs(n-2,dp);
		}

	}
	public static void main(String args[]){
		int n = 5;
		int[] dp = new int[n+1];
		System.out.println(numberOfPairs(n,dp));
	}
}