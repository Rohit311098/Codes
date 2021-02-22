import java.util.*;

public class Q3 {
	static class pair
	{
		int min;
		int max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int kmin=sc.nextInt();
		int kmax=sc.nextInt();
		
		System.out.println("Using 1st Method");
		  pair p=usingpredefinedfunction(a,n,kmin,kmax); 
		  System.out.println(kmin +" minimum is "+p.min+" and "+ kmax +" maximum is " + p.max);
		  System.out.println("Time complexity is O(nlongn)");
		 
		System.out.println("Using 2nd Method");
		pair p1=heapmethod(a,n,kmin,kmax);
		System.out.println(kmin +" minimum is "+p1.min+" and "+ kmax +" maximum is " + p1.max);
		System.out.println("Time complexity is O(n+klongn)");
		System.out.println("If n-k+1 <k then we can use min heap for finding kth maximum element");
		
		System.out.println("Uisng 3 Method");
		pair p2=quickselectalgorithm(a,n,kmin,kmax);
		System.out.println(kmin +" minimum is "+p2.min+" and "+ kmax +" maximum is " + p2.max);
		System.out.println("Time complexity in best case is O(N)");
		

	}

	
	private static pair quickselectalgorithm(int[] a, int n, int kmin, int kmax) {
		// TODO Auto-generated method stub
		pair p=new pair();
		int max=kthmaxpartition(a,0,n-1,kmax);
		p.max=max;
		p.min=0;
		return p;
	}


	private static int kthmaxpartition(int[] a, int l, int h, int k) {
		// TODO Auto-generated method stub
		if(k>0 && k<=h-l+1)
		{
			int pos=partition(a,l,h);
			if(pos-l+1==k)
			{
				return a[pos];
			}
			else if(pos-l+1>k)
			{
				return kthmaxpartition(a,l,pos-1,k);
			}
			return kthmaxpartition(a,pos+1,h,k-(pos-l+1));
		}
		return Integer.MAX_VALUE;
	}


	private static int partition(int[] a, int l, int h) {
		// TODO Auto-generated method stub
		int pivot=h;
		int i=l,j=l;
		while(j<=h-1)
		{
			if(a[j]>=a[pivot])
			{
				swap(a,i,j);
				i++;
				
			}
			j++;
		}
		swap(a,i,pivot);
		int pos=i;
		return pos;
	}


	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}


	private static pair heapmethod(int[] a, int n, int kmin, int kmax) {
		// TODO Auto-generated method stub
		pair p=new pair();
		int max=0,min=0;
		PriorityQueue<Integer> qmax=new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> qmin=new PriorityQueue<Integer>();

		for(int i=0;i<n;i++) 
		{
			qmax.add(a[i]);
			qmin.add(a[i]);
		}
		int i=1,j=1;
		while(!qmax.isEmpty())
		{
			if(i==kmax)
			{
				max=qmax.peek();
				break;
			}
			i++;
			qmax.poll();
		}
		while(!qmin.isEmpty())
		{
			if(j==kmin)
			{
				min=qmin.peek();
				break;
			}
			j++;
			qmin.poll();
		}
		
		p.max=max;
		p.min=min;
		return p;
	}


	private static pair usingpredefinedfunction(int[] a,int n,int min,int max) {
		// TODO Auto-generated method stub
		pair p=new pair();
		Arrays.sort(a);
		p.min=a[min-1];
		p.max=a[n-max];
		return p;
	}

}
