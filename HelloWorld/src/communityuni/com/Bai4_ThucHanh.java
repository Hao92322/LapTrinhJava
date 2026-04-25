package communityuni.com;

import java.util.Scanner;
public class Bai4_ThucHanh {
	public static void LocvaDemSoLeHoacChan(int []arr,boolean lasole)
	{
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] % 2 !=0 && lasole)
			{
				System.out.print(arr[i] + " ");
				count++;
			}
			else if(!lasole && arr[i] % 2 == 0)
			{
				System.out.print(arr[i] + " ");
				count++;
			}
		}
		if(lasole)
		System.out.println("Tong cong co " + count + " so le");
		else
		System.out.println("Tong cong co " + count + " so chan");
	}
	public static boolean LaSoNguyenTo(int a)
	{
		if(a < 0)
			return false;
		if(a <= 3)
			return true;
		for(int i=2;i<=Math.sqrt(a);i++)
		{
			if(a % i ==0)
				return false;
		}
		return true;
	}
	public static void LocSoNguyenToHoacKhong(int [] arr,boolean lasonguyento)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(LaSoNguyenTo(arr[i]) && lasonguyento)
				System.out.print(arr[i] + " ");
			else if(!LaSoNguyenTo(arr[i]) && !lasonguyento)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap kich thuoc cua mang: ");
		int size=0;
		int [] arr = new int[0];
		try
		{
			size = sc.nextInt();
			arr = new int[size];
		}
		catch(Exception e)
		{
			System.out.println("Nhap Khong dung dinh dang chi duoc nhap so > 0");
			
		}
		for(int i = 0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		//dem so le
		LocvaDemSoLeHoacChan(arr, true);
		//So chan
		LocvaDemSoLeHoacChan(arr, false);
		//Dem so nguyen to
		LocSoNguyenToHoacKhong(arr, true);
		//Dem so khong phai la nguyen to
		LocSoNguyenToHoacKhong(arr, false);
		
	}
}
