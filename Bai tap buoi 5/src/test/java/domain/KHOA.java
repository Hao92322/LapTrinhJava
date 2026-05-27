package domain;

import java.sql.Date;

public class KHOA {
	private String MAKHOA;
	private String TENKHOA;
	private String NGTLAP;
	private String TRGKHOA;
	public KHOA(String MAKHOA,String TENKHOA,String nGTLKHOA,String TRGKHOA) {
		this.MAKHOA = MAKHOA;
		this.TENKHOA = TENKHOA;
		this.NGTLAP = nGTLKHOA;
		this.TRGKHOA = TRGKHOA;
	}
	public String getMaKhoa() {
		return this.MAKHOA;
	}
	public String getTenKhoa(){
		return this.TENKHOA;
	}
	public String getNgTlap() {
		return this.NGTLAP;
	}
	public String getTrgKhoa() {
		return this.TRGKHOA;
	}
	public void setMaKhoa(String MaKhoa) {
		this.MAKHOA = MaKhoa;
	}
	public void setTenKhoa(String TenKhoa) {
		this.TENKHOA = TenKhoa;
	}
	public void setNgTlap(String NgTlap) {
		this.NGTLAP = NgTlap;
	}
	public void setTrgKhoa(String TrgKhoa) {
		this.TRGKHOA = TrgKhoa;
	}
	public String ToString() {
		return "Ma Khoa : {"+this.MAKHOA+
				"} TenKhoa : {"+this.TENKHOA+
				"} Ngay Thanh Lap : {"+this.NGTLAP.toString()+
				"} Truong Khoa : {"+this.TRGKHOA+"}";
	}
}
