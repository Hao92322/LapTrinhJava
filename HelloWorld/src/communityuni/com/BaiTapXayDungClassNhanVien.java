package communityuni.com;

import java.util.Scanner;

public class BaiTapXayDungClassNhanVien {
	public static class NhanVien{
		private String HoTen;
		private String Ten;
		private int SoSP;
		public NhanVien() {
			HoTen =null;
			Ten = null;
			SoSP = 0;
		}
		public NhanVien(String Ho,String Ten,int SoSP) {
			this.HoTen = Ho;
			this.Ten = Ten;
			if(SoSP <= 0)
				this.SoSP = 0;
			else
				this.SoSP = SoSP;
		}
		public String GetHoTen() {
			return this.HoTen;
		}
		public String GetTen() {
			return this.Ten;
		}
		public int GetSoSP() {
			return this.SoSP;
		}
		public void SetHoTen(String HoTen)
		{
			this.HoTen = HoTen;
		}
		public void SetTen(String Ten)
		{
			this.Ten = Ten;
		}
		public void SetSoSp(int SoSP)
		{
			this.SoSP = SoSP;
		}
		public double GetLuong()
		{
			if(this.SoSP <= 0)
				return 0;
			if(this.SoSP>=1 && this.SoSP<=199)
				return this.SoSP*0.5;
			else if(this.SoSP > 199 && this.SoSP <= 399)
				return this.SoSP*0.55;
			else if(this.SoSP > 399 && this.SoSP <= 599)
				return this.SoSP *0.6;
			else
				return this.SoSP*0.65;
		}
		public Boolean LonHon(NhanVien other)
		{
			return this.SoSP > other.GetSoSP();
		}
	}
	public static void NhapNhanVien(NhanVien nv)
	{
		String ho=null,ten = null;
		int sosp=0;
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Nhap Ho Nhan Vien: ");
			sc.nextLine();
			System.out.print("Nhap Ten Nhan Vien: ");
			sc.nextLine();
			System.out.println("Nhap So San Pham cua nhan vien: ");
			sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Ban da nhap sai dinh dang");
		}
		nv.SetHoTen(ho);
		nv.SetTen(ten);
		nv.SetSoSp(sosp);
	}
	public static void Main(String []args)
	{
		NhanVien A = new NhanVien();
		NhanVien B = new NhanVien();
		System.out.println("Nhap nhan vien thu 1");
		NhapNhanVien(A);
		System.out.println("Nhap nhan vien thu 2");
		NhapNhanVien(B);
		System.out.println("Luong Nhan Vien 1 = " + A.GetLuong() + "Luong Nhan Vien 2 = "+B.GetLuong());
		System.out.println("Cach 1 dung ham so sanh");
		if(A.LonHon(B))
			System.out.println("A co so sp lon hon B" + " Lon hon " + (A.GetSoSP() - B.GetSoSP()) + " San pham");
		else
			System.out.println("B co so sp lon hon A"  + " Lon hon " + (B.GetSoSP() - A.GetSoSP()) + " San pham");
		System.out.println("Cach 2 ko dung ham so sanh");
		if(A.GetSoSP() > B.GetSoSP())
			System.out.println("A co so sp lon hon B" + " Lon hon " + (A.GetSoSP() - B.GetSoSP()) + " San pham");
		else
			System.out.println("B co so sp lon hon A" + " Lon hon " + (B.GetSoSP() - A.GetSoSP()) + " San pham");
	}
}
