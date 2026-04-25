package communityuni.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyTenSinhVien {
	public static void QuickSort(int left,int right,ArrayList<String> list)
	{
		int l=left;
		int r=right;
		int mid = (l+r)/2;
		while(l<r)
		{
			while(l <= mid && list.get(l).compareToIgnoreCase(list.get(mid)) == -1)
			{
				l++;
			}
			while(r >= mid && list.get(r).compareToIgnoreCase(list.get(mid)) == 1)
			{
				r--;
			}
			if(l<=r)
			{
				String temp=list.get(l);
				list.set(l, list.get(r));
				list.set(r, temp);
				l++;
				r--;
			}
		}
		if(l < right)
			QuickSort(l,right,list);
		if(r > left)
			QuickSort(left,r,list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		ArrayList<String> ListTenSinhVien = new ArrayList<>();
		int query = -1;
		while(query != 0)
		{
			System.out.println("1.Them Sinh Vien");
			System.out.println("2.Xuat danh sach");
			System.out.println("3.Sua Sinh Vien");
			System.out.println("4.Xoa Sinh Vien co ten bat ky");
			System.out.println("5.Tim Sinh Vien");
			System.out.println("6.Sap Xep Sinh Vien");
			System.out.println("7.Xuat ra so luong sinh vien");
			System.out.println("0.Thoat chuong trinh");
			System.out.print("Nhap thao tac (0-7) : ");
			try
			{
				query = sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Nhap khong dung dinh dang chi duoc nhap so");
				query = 0;
			}
			switch (query) {
			case 0:{
				System.out.println("Chuong trinh ket thuc !!!");
				break;
			}
			case 1: {
				System.out.print("Nhap ten sinh vien muon them: ");
				String nameStudent = sc2.nextLine();
				if(ListTenSinhVien.add(nameStudent))
					System.out.println("Them thanh cong !!!");
				break;
			}
			case 2:{
				System.out.println("Danh sach sinh vien :");
				for(int i=0;i<ListTenSinhVien.size();i++)
				{
					System.out.println((i+1)+". "+ListTenSinhVien.get(i) + " ");
				}
				break;
			}
			case 3:{
				System.out.print("Nhap chi so muon sua :");
				int index = sc2.nextInt();
				if(index < 0 || index >= ListTenSinhVien.size())
					System.out.println("Khong ton tai chi so "+index);
				else
				{
					sc2.nextLine();
					System.out.print("Nhap ten moi :");
					String newname = sc2.nextLine();
					ListTenSinhVien.set(index, newname);
				}
				break;
			}
			case 4:{
				System.out.print("Nhap ten sinh vien muon xoa :");
				String name = sc2.nextLine();
				if(ListTenSinhVien.remove(name))
					System.out.println("Xoa Thanh Cong !!");
				else
					System.out.println("Khong tim thay ten sinh vien !!");
				break;
			}
			case 5:{
				System.out.print("Nhap ten muon tim : ");
				String name = sc2.nextLine();
				for(int i=0;i<ListTenSinhVien.size();i++)
				{
					if(ListTenSinhVien.get(i).equalsIgnoreCase(name))
					{
						System.out.println("Tim Thay sinh vien co ten "+ name + " tai vi tri "+i);
						break;
					}
				}
				break;
			}
			case 6:{
				QuickSort(0,ListTenSinhVien.size()-1,ListTenSinhVien);
				System.out.println("Danh sach da duoc sap xep !!!");
				break;
			}
			case 7:{
				System.out.println("So luong sinh vien = "+ListTenSinhVien.size());
				break;
			}
			default:
				System.out.println("Nhap so khong hop le !!");
			}
		}
		sc.close();
		sc2.close();
	}

}
