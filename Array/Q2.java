import java.util.*;
public class Q2 {

	@SuppressWarnings("resource")
	static class Pair
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
		System.out.println("Linear Method");
		Pair p1=get(a,n);		
		System.out.println(" Minimum element is "+ p1.min +" Maximum element is "+ p1.max);
		System.out.println("Less number of comparisons ");
		System.out.println("Number of comparisons are 2*(n-2)+1");
		System.out.println("Divide and Conquer method");
		Pair p=getmaxmin(a,0,n-1);
		System.out.print("Minimum element is "+ p.min);
		System.out.print("Maximum element is "+p.max);
		System.out.println("Number of comparisons are 3*(n-2)/2 in Even number of elements adn 3*(n-1)/2 in add number of elements");
		System.out.println("Pairwise comparison ");
		Pair p2=getmaxmininpair(a,n);
		System.out.println("Minimum element is "+ p2.min);
		System.out.println("Maximum element is "+p2.max);
		System.out.println("Number of comparisons are 3*(n-2)/2 in Even number of elements adn 3*(n-1)/2 in add number of elements");
	}
	 private static Pair getmaxmininpair(int[] a, int n) {
		// TODO Auto-generated method stub
		 Pair p=new Pair();
		 int min,max,i=0;
		 if(n==1)
		 {
			 p.max=a[0];
			 p.min=a[0];
			 return p;
		 }
		 if(n%2==0)
		 {
			 if(a[0]>a[1])
			 {
				 min=a[1];
				 max=a[0];
			 }
			 else
			 {
				 min=a[0];
				 max=a[1];
			 }
			 i=2;
		 }
		 else
		 {
			 min=a[0];
			 max=a[0];
			 i=1;
		 }
		 while(i<n-1)
		 {
			 if(a[i]<a[i+1])
			 {
				if(a[i+1]>max)
				{
					max=a[i+1];
				}
				if(a[i]<min)
				{
					min=a[i];
				}
			 }
			 else
			 {
				 if(a[i]>max)
				{
					max=a[i];
				}
				if(a[i+1]<min)
				{
					min=a[i+1];
				}
				 
			 }
			 i++;
		 }
		 p.min=min;
		 p.max=max;
		return p;
	}
	private static Pair get(int[] a,int n) {
		// TODO Auto-generated method stub
		 Pair p=new Pair();
		 Integer max=a[0],min=a[0];
			for(int i=1;i<n;i++)
			{
				if(a[i]<min)
				{
					min=a[i];
				}
				else if(max<a[i])
				{
					max=a[i];
				}
			}
			p.min=min;
			p.max=max;
		 
		return p;
	}
	static Pair getmaxmin(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		 Pair p=new Pair();
		 Pair pl=new Pair();
		 Pair pr=new Pair();
		 if(low==high)
		 {
			 p.min=a[low];
			 p.max=a[high];
			 return p;
		 }
		 if(high==low+1)
		 {
			 if(a[high]<a[low])
			 {
				 p.min=a[high];
				 p.max=a[low];
			 }
			 else
			 {
				 p.min=a[low];
				 p.max=a[high];
			 }
			 return p;
		 }
		 int mid=(low+high)/2;
		 pl=getmaxmin(a,low,mid);
		 pr=getmaxmin(a,mid+1,high);
		 if(pl.min<pr.min)
		 {
			 p.min=pl.min;
		 }
		 else
		 {
			 p.min=pr.min;
			 
		 }
		 if(pl.max<pr.max)
		 {
			 p.max=pr.max;
		 }
		 else
		 {
			 p.max=pl.max;
		 }
		return p;
	}

}
