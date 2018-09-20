import java.util.*;
class MaxSnakeLength{
	private static List<Point> findPath(int[][] dp, int[][] arr, int i, int j){
		List<Point> path = new ArrayList<Point>();
		Point pt = new Point(i,j);
		path.add(pt);
		while(dp[i][j]!=0){
			if(i>0 && dp[i][j]-1 == dp[i-1][j]){
				pt = new Point(i-1,j);
				path.add(pt);
				i--;
			}
			else if(j>0 && dp[i][j]-1==dp[i][j-1]){
				pt = new Point(i,j-1);
				path.add(pt);
				j--;
			}
		}
		return path;
	}
	private static void findLongestSeq(int[][] arr){
		int[][] dp = new int[arr.length][arr[0].length];

		int maxLen = 0;
		int maxRow = 0;
		int maxCol = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(i!=0||j!=0){
					if(i>0 && Math.abs(arr[i-1][j]-arr[i][j])==1){
						dp[i][j] = Math.max(dp[i][j],dp[i-1][j]+1);
						if(maxLen<dp[i][j]){
							maxLen = dp[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
					if(j>0 && Math.abs(arr[i][j-1]-arr[i][j])==1){
						dp[i][j] = Math.max(dp[i][j],dp[i][j-1]+1);
						if(maxLen<dp[i][j]){
							maxLen = dp[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
				}
			}
		}
		System.out.println(maxLen);
		List<Point> path = findPath(dp,arr,maxRow,maxCol);
		for(Point p: path){
			System.out.print(arr[p.x][p.y]+" ");
			System.out.print("("+p.x+", ");
			System.out.println(p.y+")");
		}
	}
	public static void main(String[] args){
		int[][] mat = 
    	{ 
	        {9, 6, 5, 2}, 
	        {8, 7, 6, 5}, 
	        {7, 3, 1, 6}, 
	        {1, 1, 1, 7}, 
    	};
    	findLongestSeq(mat);
	}
}
class Point{
	int x, y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}