// Move all the negative elements to one side of the array 
import java.util.*;
public class Movenegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		//firstmethod(a,n); // TC=O(N)  SC=O(1) Using Two Pointer algorithm Order not maintained
		
		// For maintaing orders
		//secondmethod(a,n);   // TC-O(N2) SC=O(1) Using Modified Insertion sort
		//thirdmethod(a,n);     // TC=O(N) SC-O(1) Using Mergesort logic
		
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
	}

	

	private static void thirdmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		mergesort(a,0,n-1);
		
	}

	private static void mergesort(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		if(low<high)
		{
			int mid=low+(high-low)/2;
			mergesort(a,low,mid);
			mergesort(a,mid+1,high);
			merge(a,low,mid,high);
		}
		
	}

	private static void merge(int[] a, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int n1=mid-low+1;
		int n2=high-mid;
		int []left=new int[n1];
		int[] right=new int[n2];
		for(int i=0;i<n1;i++)
		{
			left[i]=a[low+i];
		}
		for(int j=0;j<n2;j++)
		{
			right[j]=a[mid+1+j];
		}
		int i=0,j=0,k=low;
		while(i<n1 && left[i]<0)
		{
			a[k++]=left[i++];
		}
		while(j<n2 && right[j]<0)
		{
			a[k++]=right[j++];
		}
		while(i<n1)
		{
			a[k++]=left[i++];
		}
		while(j<n2)
		{
			a[k++]=right[j++];
		}
		
	}

	private static void secondmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int i=-1,j=0;
		while(j<n)
		{
			if(a[j]<0)
			{
				i++;
				int t=a[j];
				for(int k=i;k<j;k++)
				{
					a[k+1]=a[k];
				}
				a[i]=t;
			}
			j++;
		}
		
	}

	private static void firstmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int i=0,j=n-1;
		while(i<j)
		{
			if(a[i]<0 && a[j]<0)
			{
				i++;
			}
			else if(a[i]>0 && a[j]<0)
			{
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
			else if(a[i]>0 && a[j]>0)
			{
				j--;
			}
			else
			{
				i++;
				j--;
			}
		}
		
	}
	

}
