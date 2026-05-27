package test;

import java.util.List;
import java.util.Scanner;

import data.JdbcGIAOVIEN;
import data.JdbdKhoa;
import domain.GIAOVIEN;
import domain.KHOA;

public class TestCT {
	public static void InsertKhoa(JdbdKhoa jdbckhoa) {
		System.out.println("THEM KHOA");
		Scanner sc = new Scanner(System.in);
		String Makhoa;
		String TenKhoa;
		String TrgKhoa;
		System.out.print("Nhập Mã Khoa: ");
		Makhoa = sc.nextLine();
		System.out.print("Nhập Ten Khoa: ");
		TenKhoa = sc.nextLine();
		System.out.print("Nhập Truong Khoa: ");
		TrgKhoa = sc.nextLine();
		jdbckhoa.Insert(new KHOA(Makhoa,TenKhoa,null,TrgKhoa));
		sc.close();
	}
	public static void XuatGiaoVienNam(JdbcGIAOVIEN jdbcGiaoVien) {
		System.out.println("Lay tat ca giao vien la nam : ");
		List<GIAOVIEN> allgv = jdbcGiaoVien.Select();
		for(GIAOVIEN gv : allgv)
		{
			if(gv.getGIOITINH() == 0)
				System.out.println(gv.ToString());
		}
	}
	public static void UpdateKhoa(JdbdKhoa jdbckhoa) {
		System.out.println("Sua Khoa");
		Scanner sc = new Scanner(System.in);
		String Makhoa;
		String TenKhoa;
		String Ngtlap;
		String TrgKhoa;
		System.out.print("Nhập Mã Khoa: ");
		Makhoa = sc.nextLine();
		System.out.print("Nhập Ten Khoa: ");
		TenKhoa = sc.nextLine();
		System.out.print("Nhập Ngay Thanh Lap: ");
		Ngtlap = sc.nextLine();
		System.out.print("Nhập Truong Khoa: ");
		TrgKhoa = sc.nextLine();
		jdbckhoa.update(new KHOA(Makhoa,TenKhoa,Ngtlap,TrgKhoa));
		sc.close();
	}
	public static void XuatKhoa(JdbdKhoa jdbckhoa) {
		List<KHOA> allkhoa = jdbckhoa.Select();
		for(KHOA khoa : allkhoa)
		{
			System.out.println(khoa.ToString());
		}
	}
	public static void XuatGiaoVien(JdbcGIAOVIEN jdbcGiaoVien) {
		List<GIAOVIEN> allgv = jdbcGiaoVien.Select();
		for(GIAOVIEN gv : allgv)
		{
			System.out.println(gv.ToString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbdKhoa jdbckhoa = new JdbdKhoa();
		JdbcGIAOVIEN jdbcGiaoVien = new JdbcGIAOVIEN();
		XuatKhoa(jdbckhoa);
		XuatGiaoVien(jdbcGiaoVien);
		GIAOVIEN gv = new GIAOVIEN("GV13", "KALONG", "THACSI", "GIAOVIEN", 0, 2, 1000000, "CNTT");
		jdbcGiaoVien.Insert(gv);
		//Lay danh sach sau khi them
		XuatGiaoVien(jdbcGiaoVien);
		gv.setTENGV("KALONGTONG");
		jdbcGiaoVien.update(gv);
		//Lay danh sach sau khi sua
		XuatGiaoVien(jdbcGiaoVien);
		jdbcGiaoVien.delete("GV13");
		//Lay danh sach sau khi xoa
		XuatGiaoVien(jdbcGiaoVien);
		//Lay danh sach giao vien co gioi tinh la nam
		XuatGiaoVienNam(jdbcGiaoVien);
		InsertKhoa(jdbckhoa);
		jdbckhoa.delete("Marketing");
		UpdateKhoa(jdbckhoa);
		XuatKhoa(jdbckhoa);
		
	}

}
