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
		firstmethod(a,n); // TC=O(N)  SC=O(1) Using Two Pointer algorithm
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
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
