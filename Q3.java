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
		pair p=usingpredefinedfunction(a,n,kmin,kmax);
		System.out.println(kmin +" minimum is "+p.min+" and "+ kmax +" maximum is " + p.max);
		
		pair p1=heapmethod(a,n,kmin,kmax);
		System.out.println(kmin +" minimum is "+p.min+" and "+ kmax +" maximum is " + p.max);
		

	}

	
	private static pair heapmethod(int[] a, int n, int kmin, int kmax) {
		// TODO Auto-generated method stub
		pair p=new pair();
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
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
