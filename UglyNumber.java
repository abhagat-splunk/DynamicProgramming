import java.util.*;
import java.io.*;
class UglyNumber{
	private static int findNthUglyNumber(int n){
		int[] ugly = new int[n];
		int i2=0,i3=0,i5=0;
		int next2 = 2, next3 = 3, next5 = 5;
		int uglyNo = 1;
		ugly[0] = 1;
		for(int i=1;i<n;i++){
			uglyNo = Math.min(next2,Math.min(next3,next5));
			ugly[i] = uglyNo;
			if(uglyNo==next2){
				i2++;
				next2 = ugly[i2]*2;
			}
			if(uglyNo==next3){
				i3++;
				next3 = ugly[i3]*3;
			}
			if(uglyNo==next5){
				i5++;
				next5 = ugly[i5]*5;
			}
		}
		return uglyNo;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findNthUglyNumber(n));
	}
}