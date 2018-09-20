class Coinchange{
	private static int findNumberOfWays(int[] arr, int m, int n){
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(m<=0 && n>=1){
			return 0;
		}
		return findNumberOfWays(arr,m-1,n)+findNumberOfWays(arr,m,n-arr[m-1]);

	}
	public static void main(String args[]){
		int[] arr = {1,2,3};
		int n = 10;
		System.out.println(findNumberOfWays(arr,arr.length,n));
	}
}