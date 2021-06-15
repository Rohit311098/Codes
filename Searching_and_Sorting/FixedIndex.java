package Searchong_and_Sorting;

import java.util.*;

public class FixedIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		ArrayList<Integer> v=new ArrayList<Integer>();
		v=findindex(a,n);
		for(int i:v)
		{
			System.out.print(i+" ");
		}

	}
	public static ArrayList<Integer> findindex(int a[],int n)
	{
		ArrayList<Integer> v=new ArrayList<Integer>();
		int i=binarysearch(a,0,n-1);
		v.add(i);
		return v;
		
	}
	private static int binarysearch(int[] a, int low,int high) {
		// TODO Auto-generated method stub
		if(low<=high)
		{
			int mid=low+(high-low)/2;
			if(a[mid]==mid)
			{
				return mid;
			}
			else if(a[mid]<mid)
			{
				return binarysearch(a,mid+1,high);
			}
			else
			{
				return binarysearch(a,low,mid-1);
			}
		}
		return 0;
	}

}
