package communityuni.com;

import java.util.ArrayList;
import java.util.Scanner;


public class Bai4_ThucHang16_5_2026 {
	public static class Invoice{
		private String MaMatHang;
		private String MoTaMatHang;
		private int SoLuongDuocMua;
		private double GiaMatHang;
		public Invoice() {
			MaMatHang = "";
			MoTaMatHang = "";
			SoLuongDuocMua = 0;
			GiaMatHang = 0;
		}
		public Invoice(String MaMatHang,String MoTaMatHang,int SoLuongDuocMua,double GiaMatHang)
		{
			this.MaMatHang = MaMatHang;
			this.MoTaMatHang = MoTaMatHang;
			this.SoLuongDuocMua = SoLuongDuocMua;
			this.GiaMatHang = GiaMatHang;
		}
		//Get
		public String GetMaMatHang() {
			return this.MaMatHang;
		}
		public String GetMoTaMatHang() {
			return this.MoTaMatHang;
		}
		public int GetSoLuongDuocMua() {
			return this.SoLuongDuocMua;
		}
		public double GetGiaMatHang() {
			return this.GiaMatHang;
		}
		//Set
		public void SetMaMatHang(String ma) {
			this.MaMatHang = ma;
		}
		public void SetMoTaMatHang(String mota) {
			this.MoTaMatHang = mota;
		}
		public void SetSoLuongDuocMua(int soluong) {
			this.SoLuongDuocMua=soluong;
		}
		public void GetGiaMatHang(double giamathang) {
			if(giamathang < 0)
				this.GiaMatHang =0.0;
			else
				this.GiaMatHang = giamathang;
		}
		//Ham getInvoiceAmount
		public double GetInvoiceAmount() {
			double InvoiceAmount = this.GiaMatHang*this.SoLuongDuocMua;
			if(InvoiceAmount < 0)
			{
				return 0;
			}
			return InvoiceAmount;
		}
		
	}
	public static class InvoiceTest {
		private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		public int TimKiem(String MaMatHang) {
			for(int i=0;i<invoices.size();i++)
			{
				Invoice invoice = invoices.get(i);
				if(invoice.MaMatHang.equals(MaMatHang))
					return i;
			}
			return -1;
		}
		public void NhapInvoice(Scanner sc) {
			sc.nextLine();
			System.out.print("Nhap ma dat hang:");
			String ma = sc.nextLine();
			System.out.print("Nhap mo ta dat hang:");
			String mota = sc.nextLine();
			System.out.print("Nhap so luong:");
			int soluong = sc.nextInt();
			System.out.print("Nhap gia tien:");
			double gia = sc.nextDouble();
			if(TimKiem(ma) == -1)
			{
				System.out.println("Them Mat Hang Thanh Cong");
				invoices.add(new Invoice(ma,mota,soluong,gia));
			}
			else
			{
				System.out.println("Them That Bai Vi Ma Mat Hang da ton tai");
			}
		}
		public void XuatInvoice(int i) {
			if(i<0 || i> invoices.size())
				System.out.println("Chi so da vuot qua khoi danh sach.Chi nhan(0-"+invoices.size()+")");
			else {
				Invoice invoice = invoices.get(i);
				System.out.println("------------------------------------------");
				System.out.println("Mat hang thu "+(i+1) +" trong danh sach: ");
				System.out.println("Ma mat hang : "+invoice.MaMatHang);
				System.out.println("Mo ta mat hang : "+invoice.MoTaMatHang);
				System.out.println("So Luong Duoc Mua : "+invoice.SoLuongDuocMua);
				System.out.println("Gia Mat Hang : "+invoice.GiaMatHang);
				System.out.println("------------------------------------------");
			}
		}
		public void XoaMatHang(String ma) {
			int chiso = TimKiem(ma);
			if(chiso == -1)
				System.out.println("Xoa That Bai vi khong tim thay ma mat hang");
			else
			{
				invoices.remove(chiso);
				System.out.println("Xoa Thanh Cong !!!");
			}
		}
		public void Swap(int i,int j)
		{
			Invoice temp = invoices.get(i);
			invoices.set(i, invoices.get(j));
			invoices.set(j, temp);	
		}
		//tieu chi 1: theo ma dat hang tieu chi 2: theo so luong
		public void SapXep(int tieuchi) {
			for(int i=0;i<invoices.size();i++)
			{
				for(int j=i+1;j<invoices.size();j++)
				{
					if(tieuchi==1)
					{
						if(invoices.get(i).GetMaMatHang().compareTo(invoices.get(i).GetMaMatHang())>0)
						{
							Swap(i,j);
						}
					}
					else if(tieuchi == 2) {
						if(invoices.get(i).GetSoLuongDuocMua() > invoices.get(j).GetSoLuongDuocMua())
						{
							Swap(i,j);
						}
					}
				}
			}
			System.out.println("Sap xep thanh cong!!!");
		}
		public void XuatToanBoDanhSach() {
			for(int i=0;i<invoices.size();i++)
			{
				XuatInvoice(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query = -1;
		InvoiceTest invoices = new InvoiceTest();
		while(query != 0) {
			System.out.println("Chuong Trinh Quan Ly Danh Sach Mat Hang Phan Cung May Tinh");
			System.out.println("1.Them 1 invoice");
			System.out.println("2.Xuat 1 invoice");
			System.out.println("3.Xuat Toan Bo Danh Sach");
			System.out.println("4.Sap xep danh sach tang dan theo Ma Dat Hang");
			System.out.println("5.Sap xep danh sach tang dan theo So Luong");
			System.out.println("6.Tim kiem mat hang");
			System.out.println("7.Xoa Mat Hang");
			System.out.print("Nhap thao tac: ");
			query = sc.nextInt();
			switch (query) {
			case 0: {
				System.out.println("Tam biet!!");
				break;
			}
			case 1: {
				try {
					invoices.NhapInvoice(sc);
				}
				catch(Exception e)
				{
					System.out.println("Loi nhap sai dinh dang");
				}
				finally {
					break;
				}
			}
			case 2:
			{
				try {
					System.out.print("Nhap chi so cua mat hang ban muon xuat :");
					int chiso = sc.nextInt();
					invoices.XuatInvoice(chiso);
				}
				catch(Exception e)
				{
					System.out.println("Nhap Sai Dinh Dang");
				}
				finally {
					break;
				}
			}
			case 3:{
				invoices.XuatToanBoDanhSach();
				break;
			}
			case 4:{
				invoices.SapXep(1);
				break;
			}
			case 5:{
				invoices.SapXep(2);
				break;
			}
			case 6:{
				System.out.print("Nhap ma mat hang muon tim kiem :");
				sc.nextLine();
				String mamathang = sc.nextLine();
				if(invoices.TimKiem(mamathang) != -1)
					System.out.println("Ma Mat Hang co ton tai trong danh sach tai vi tri "+invoices.TimKiem(mamathang));
				else
					System.out.println("Ma Mat Hang khong ton tai trong danh sach");
				break;
			}
			case 7:{
				System.out.print("Nhap ma mat hang muon xoa:");
				sc.nextLine();
				String mamathang = sc.nextLine();
				invoices.XoaMatHang(mamathang);
				break;
			}
			default:
				System.out.println("Sai cau lenh");
			}
		}
	}

}
