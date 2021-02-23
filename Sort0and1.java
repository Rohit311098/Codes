import java.util.Scanner;

public class Sort0and1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		  System.out.println("First Method  TC=O(N) We are traversing two times"); 
		  //In this approach we are traversing array 2 times
		  a=sortbyfirstmethod(a,n);      
		  displayarray(a,n);
		System.out.println("Second Method TC=O(N) But we are traversing only ones");
		a=sortbysecondmethod(a,n);
		displayarray(a,n);

	}
	private static void displayarray(int[] a, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		
	}
	private static int[] sortbysecondmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int left=0,right=n-1;
		int i=0;
		while(left<right)
		{
			while(a[left]==0 && left<right)
			{
				left++;
			}
			while(a[right]==1 && left<right)
			{
				right--;
			}
			if(left<right)
			{
				a[left]=0;
				a[right]=1;
				left++;
				right--;
			}
		}
		return a;
	}
	private static int[] sortbyfirstmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int zero=0,ones=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
			{
				zero++;
			}
			else if(a[i]==1)
			{
				ones++;
			}
		}
		//System.out.println(zero + " " + ones + " "+two);
		int i=0,j=0;
		while(i<zero)
		{
			a[i]=0;
			i++;
		}
		while(j<ones)
		{
			a[i]=1;
			i++;
			j++;
		}
		return a;
	}


}

