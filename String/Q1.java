package String;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		StringBuilder stb=new StringBuilder();
		stb.append(s);
		System.out.println(stb.reverse());
		

		char[] temp=s.toCharArray();
		for(int i=0,j=temp.length-1;i<j;i++,j--)
		{
			char t=temp[i];
			temp[i]=temp[j];
			temp[j]=t;
		}
		System.out.println(temp);

	}

	

	

}
