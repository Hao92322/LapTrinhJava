public class HinhVuong extends HinhChuNhat {
    public HinhVuong(String mau, double canh) {
        super(mau, canh, canh);
    }

    @Override
    public String layThongTin() {
        return "Màu Sắc:" + mau + ", Cạnh: " + chieuDai;
    }
}
