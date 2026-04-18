package communityuni.com;

import java.util.Scanner;

public class HocScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double pi = 3.14;//Hang so
		Scanner sc = new Scanner(System.in);//java la ngon ngu lap trinh tren nhieu thiet bi nen can 1 lop scanner de quet cac input
		System.out.print("Nhap kich thuoc hinh vuong:");
		int a =sc.nextInt();
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<a;j++)
			{
				System.out.print(" * ");
			}
			System.out.println();
		}
		sc.close();
	}

}
