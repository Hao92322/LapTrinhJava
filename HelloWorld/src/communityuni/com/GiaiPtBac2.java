package communityuni.com;

import java.util.Scanner;

public class GiaiPtBac2 {
	public static void GiaiPtBac2(int a,int b,int c)
	{
		if(a == 0)
		{
			if(b!=0)
				System.out.println("Phuong trinh co nghiem x = "+(-c/b));
			else//b==0
			{
				if(c==0)
					System.out.println("Phuong trinh vo so nghiem");
				else//c!=0
					System.out.println("Phuong trinh vo nghiem");
			}
		}
		else//a!=0
		{
			double delta = (b*b)-(4*a*c);
			if(delta < 0)
				System.out.println("Phuong trinh vo nghiem");
			else if(delta == 0)
				System.out.println("Phuong trinh co nghiem x = "+(-b/2*a));
			else//delta > 0
			{
				double x1 = (-b + Math.sqrt(delta)) / (2*a);
				double x2 = (-b - Math.sqrt(delta)) / (2*a);
				System.out.println("Phuong trinh co 2 nghiem x1 = "+x1+" va x2 = "+x2);
			}
		}
	}
	public static int NhapsoNguyen(Scanner sc,String bien)
	{
		System.out.print("Nhap so nguyen cho bien "+bien + " :");
		int so = sc.nextInt();
		return so;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("---CHUONG TRINH GIAI PT BAC 2 (ax\u00B2+bx+c=0)---");
		int a = NhapsoNguyen(sc,"a");
		int b = NhapsoNguyen(sc,"b");
		int c = NhapsoNguyen(sc,"c");
		GiaiPtBac2(a,b,c);
		sc.close();
	}

}
