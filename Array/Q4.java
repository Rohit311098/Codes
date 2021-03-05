import java.util.*;
public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("First Method  TC=O(N)");                      
		a=sortbyfirstmethod(a,n);     
		 displayarray(a,n);                  //In this Approach we are traversing array two times
		System.out.println("Second Method TC=O(N)"); //In this aApproach we only traverse ones
		a=sortbysecondmethod(a,n);
		displayarray(a,n);


	}

	private static int[] sortbysecondmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int low=0,mid=0,high=n-1;
		while(mid<=high)
		{
			if(a[mid]==0)
			{
				int temp=a[low];
				a[low]=a[mid];
				a[mid]=temp;
				low++;
				mid++;
			}
			else if(a[mid]==1)
			{
				mid++;
			}
			else
			{
				int temp=a[high];
				a[high]=a[mid];
				a[mid]=temp;
				high--;
			}
		}
		return a;
	}

	private static void displayarray(int[] a, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		
	}

	private static int[] sortbyfirstmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int zero=0,ones=0,two=0;
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
			else
			{
				two++;
			}
		}
		//System.out.println(zero + " " + ones + " "+two);
		int i=0,j=0,k=0;
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
		while(k<two)
		{
			a[i]=2;
			i++;
			k++;
		}
		return a;
	}

}
