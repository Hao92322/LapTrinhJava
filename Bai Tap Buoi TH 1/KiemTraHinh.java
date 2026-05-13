public class KiemTraHinh {
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat("Do", 5.0, 3.0);
        HinhTron ht = new HinhTron("Xanh", 2.5);
        HinhVuong hv = new HinhVuong("Vang", 4.0);

        System.out.println("---Hinh Chu Nhat---");
        System.out.println(hcn.layThongTin());
        System.out.println("Dien Tich:" + hcn.tinhDienTich());
        System.out.println("Chu vi:" + hcn.tinhChuVi());

        System.out.println("---Hinh Tron---");
        System.out.println(ht.layThongTin());
        System.out.println("Dien Tich:" + ht.tinhDienTich());
        System.out.println("Chu Vi:" + ht.tinhChuVi());

        System.out.println("---Hinh Vuong---");
        System.out.println("hv.layThongTin");
        System.out.println("Dien tich:" + hv.tinhDienTich());
        System.out.println("Chu vi:" + hv.tinhChuVi());
    }
}
