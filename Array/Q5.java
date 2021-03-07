//Move all negative numbers to beginning and positive to end with constant extra space
import java.util.*;
public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		
		
		
		
		
		/*
		 * System.out.println("TC=O(N) and SC=O(N) Taking More Space");
		 * firstmethod(a,n);
		 * 
		 * System.out.
		 * println("Two Pointer AlgorithmTC=O(N) and SC=O(1)  But problem is Order of element is Not maintained"
		 * ); secondmethod(a,n);
		 * 
		 * 
		 * System.out.
		 * println("Easy partition approach TC=O(N) and SC=O(1)  Order of element is Maintained"
		 * ); thirdmethod(a,n);
		 * 
		 * 
		 * 
		 * System.out.
		 * println("TC=0(N2) But order is maintained Variant of Insertion sort");
		 * forthmethod(a,n);
		 */
		 
		
		System.out.println("TC=O(nlogn) SC=O(n) But we use array Data structure ");
		mergesort(a,0,n-1);
		
		displayarray(a,n);
		sc.close();
		
	}

	private static void mergesort(int[] a,int l ,int r) {
		// TODO Auto-generated method stub
		if(l<r)
		{
			int mid=l+(r-l)/2;
			mergesort(a,l,mid);
			mergesort(a,mid+1,r);
			merge(a,l,mid,r);
		}
	}

	private static void merge(int[] a, int l, int m, int r) {
		int n1=m-l+1;
		int n2=r-m;
		int[] left=new int[n1];
		int[] right=new int[n2];
		
		for (int i = 0; i < n1; i++)
            left[i] = a[l + i];
        for (int j = 0; j < n2; j++)
            right[j] = a[m + 1 + j];
        
        int i=0,j=0,k=l;
		while(i<n1 && left[i]<0)
		{
			a[k++]=left[i++];
		}
		while(j<n2 && right[j]<0)
		{
			a[k++]=right[j++];
		}
		while(i<n1 )
		{
			a[k++]=left[i++];
		}
		while(j<n2 )
		{
			a[k++]=right[j++];
		}
		
	}



	private static void forthmethod(int[] a, int n) {
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				continue;
			}
			if(a[i]<0)
			{
				
				int tmp=a[i];
				int j=i-1;
			    while(j>=0 && a[j]>0)
			    {
			    a[j+1]=a[j];
			    j=j-1;
			    }
			    a[j+1]=tmp;
			}
		}
	}

	private static void thirdmethod(int[] a, int n) {
		
		int i=-1;
		for(int j=0;j<n;j++)
		{
			if(a[j]>0)
			{
				i++;
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		
	}

	private static void secondmethod(int[] a, int n) {
		// TODO Auto-generated method stub
		int low=0,high=n-1;
		while(low<high)
		{
			while(a[low]<0 && low<high)
			{
				low++;
			}
			while(a[high]>0 && low<high)
			{
				high--;
			}
			if(low<high)
			{
				int temp=a[low];
				a[low]=a[high];
				a[high]=temp;
				high--;
				low++;
			}
		}
	}

	private static void displayarray(int[] a, int n) {
		
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		
	}

	private static void firstmethod(int[] a, int n) {
		int[] temp=new int[n];
		int k=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]<0)
			{
				temp[k]=a[i];
				k++;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				temp[k]=a[i];
				k++;
			}
		}

	}

}
