package Searchong_and_Sorting;

import java.util.*;

public class Firstandlastindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int x=sc.nextInt();
		Vector<Integer> v=new Vector<Integer>();
		//v=firstmethod(a,n,x);  //TC=O(N) SC=O(1);
		v=secondmethod(a,n,x);
		for(int i:v)
		{
			System.out.print(i+" ");
		}

	}
   private static Vector<Integer> secondmethod(int[] a, int n, int x) {
		// TODO Auto-generated method stub
	   Vector<Integer> v=new Vector<Integer>();
	   int first=firstbinarysearch(a,0,n-1,x);
	   int last=lastbinarysearch(a,0,n-1,x,n);
	   v.add(first);
	   v.add(last);
		return v;
	}
private static int lastbinarysearch(int[] a, int low, int high, int x,int n) {
	// TODO Auto-generated method stub
	if(low<=high)
	 {
		 int mid=low+(high-low)/2;
		 if((mid==n-1 || a[mid+1]>x) && a[mid]==x)
		 {
			 return mid;
		 }
		 else if(a[mid]>x)
		 {
			 return lastbinarysearch(a,low,mid-1,x,n);
		 }
		 else 
		 {
			 return lastbinarysearch(a,mid+1,high,x,n);
		 }
	 }
	return -1; 
	
}
private static int firstbinarysearch(int[] a, int low, int high, int x) {
	// TODO Auto-generated method stub
	if(low<=high)
	 {
		 int mid=low+(high-low)/2;
		 if((mid==0 || a[mid-1]<x) && a[mid]==x)
		 {
			 return mid;
		 }
		 else if(a[mid]<x)
		 {
			 return firstbinarysearch(a,mid+1,high,x);
		 }
		 else
		 {
			 return firstbinarysearch(a,low,mid-1,x);
		 }
	 }
	return -1;
}
public static Vector<Integer> firstmethod(int[]a,int n,int x)
   {
	   Vector<Integer> v=new Vector<Integer>();
	   int first=-1,last=-1;
	   for(int i=0;i<n;i++)
	   {
		  if(a[i]==x &&first==-1)
		  {
			  first=i;
		  }
		  if(a[i]==x &&first!=-1)
		  {
			  last=i;
		  }
	   }
	   v.add(first); 
	   v.add(last);
	return v;
	   
   }
}
