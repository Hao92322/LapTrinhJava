package communityuni.com;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class BaiTapVeNha {

	//Bai 1 Mang 1 chieu
	public static void XuatMang1chieu(Integer [] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void Mang1Chieu()
	{
		
		Scanner sc = new Scanner(System.in);
		try
		{
			//Nhap Mang
			int size=0;
			System.out.print("Nhap so luong phan tu cua mang:");
			size = sc.nextInt();
			Integer [] arr = new Integer[size];
			System.out.print("Nhap mang:");
			for(int i=0;i<size;i++)
			{
				arr[i] = sc.nextInt();
			}
			//Xuat Mang
			int sum = 0;
			System.out.print("Mang vua nhap:");
			XuatMang1chieu(arr);
			//Nhap so K tinh tan suat xuat hien tim phan tu lon nhat va tim phan tu nho nhat
			//Tim tong mang
			System.out.print("Nhap so K :");
			int K=sc.nextInt();
			int count = 0;
			int min = arr[0];
			int max = arr[0];
			for(int i=0;i<size;i++)
			{
				sum+=arr[i];
				if(arr[i] == K)
					count++;
				if(arr[i]<min)
					min = arr[i];
				if(arr[i]>max)
					max= arr[i];
			}
			System.out.println("So K = "+K+" xuat hien "+count+" lan trong mang");
			System.out.println("Phan tu lon nhat trong mang = "+max);
			System.out.println("Phan tu nho nhat trong mang = "+min);
			System.out.println("Tong mang = "+sum);
			QuickSort(0,size-1,arr);
			System.out.println("Mang da duoc sap xep tang dan!!");
			XuatMang1chieu(arr);
			Collections.reverse(Arrays.asList(arr));
			System.out.println("Mang da duoc sap xep giam dan!!");
			XuatMang1chieu(arr);
		}
		catch(Exception e)
		{
			throw e;
		}
		finally {
			sc.close();
		}
	}
	public static void ArrayList()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Nhap so luong phan tu cua ArrayList : ");
			int size = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>(size);
			System.out.println("Nhap mang :");
			for(int i=0;i<size;i++)
			{
				arr.add(sc.nextInt());
			}
			int query = -1;
			while(query!=0)
			{
				System.out.println("Chuong trinh ArrayList");
				System.out.println("1.Them");
				System.out.println("2.Sua");
				System.out.println("3.Xoa");
				System.out.println("3.Tim Kiem");
				System.out.println("4.Sap xep");
				System.out.println("5.Xuat Mang");
				System.out.println("0.Thoat Chuong Trinh !!!");
				System.out.println("Nhap thao tac ban muon :");
				query = sc.nextInt();
				switch (query) {
				case 1: {
					System.out.print("Nhap gia tri ban muon them :");
					arr.add(sc.nextInt());
				}
				case 2:
				{
					System.out.println("Nhap chi so cua phan tu ban muon sua :");
					int index = sc.nextInt();
					arr.set(index, null);
				}
				case 3: {
					System.out.println("Nhap chi so cua phan tu ban muon xoa :");
					int index = sc.nextInt();
					arr.remove(index);
				}
				case 4:{
					Collections.sort(arr);
				}
				case 5:
				{
					for(int i=0;i<arr.size();i++)
					{
						System.out.print(arr.get(i) + ' ');
					}
				}
				default:
					System.out.println("Thao Tac Khong Hop Le !!!");
				}
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			sc.close();
		}
	}
	
	public static void QuickSort(int left,int right,Integer[] arr)
	{
		int l = left;
		int r = right;
		int mid= (left+right)/2;
		while(l<r)
		{
			while(arr[l] < arr[mid] && l < mid)
			{
				l++;
			}
			while(arr[r] > arr[mid] && r > mid)
			{
				r--;
			}
			if(l<=r)
			{
				int temp=arr[l];
				arr[l]=arr[r];
				arr[r]=temp;
				l++;
				r--;
			}
		}
		if(l<right)
		{
			QuickSort(l,right,arr);
		}
		if(r>left)
		{
			QuickSort(left,r,arr);
		}
	}
	public static void HashMap()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Nhap so luong phan tu cua ArrayList : ");
			int size = sc.nextInt();
			HashMap<Integer,String> arr = new HashMap<>();
			System.out.println("Nhap mang :");
			for(int i=0;i<size;i++)
			{
				int key = sc.nextInt();
				String value = sc.nextLine();
				arr.put(key,value);
			}
			int query = -1;
			while(query!=0)
			{
				System.out.println("Chuong trinh ArrayList");
				System.out.println("1.Them");
				System.out.println("2.Sua");
				System.out.println("3.Xoa");
				System.out.println("3.Tim Kiem");
				System.out.println("4.Sap xep");
				System.out.println("5.Xuat Mang");
				System.out.println("0.Thoat Chuong Trinh !!!");
				System.out.println("Nhap thao tac ban muon :");
				query = sc.nextInt();
				switch (query) {
				case 1: {
					System.out.print("Nhap gia tri ban muon them :");
					int key = sc.nextInt();
					String value = sc.nextLine();
					arr.put(key,value);
				}
				case 2:
				{
					System.out.print("Nhap key ban muon sua: ");
					if(arr.containsKey(sc.nextInt()))
						System.out.println("Key khong ton tai");
					
				}
				case 3: {
					System.out.println("Nhap ten sach ban muon xoa :");
					String value = sc.nextLine();
					arr.remove(value);
				}
				case 5:
				{
					for(int i=0;i<arr.size();i++)
					{
						System.out.print(arr.get(i) + ' ');
					}
				}
				default:
					System.out.println("Thao Tac Khong Hop Le !!!");
				}
			}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList();
	}

}
