package org.hrm.HrHead;

public class TwoDimensionalarray {

	public static void main(String[] args) {
		String arr[][]=new String [2][2];
		
		arr[0][0]="A1";
		arr[0][1]="A2";
		arr[1][0]="B1";
		arr[1][1]="B2";
		
		for(int i=0;i<=arr.length;i++)
		{
			for(int j=0;j<=i+1;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();			
		}	
		}
}
