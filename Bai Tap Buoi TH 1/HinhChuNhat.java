public class HinhChuNhat extends Hinh {
    protected double chieuDai;
    protected double chieuRong;

    public HinhChuNhat(String mau,double chieuDai,double chieuRong)
    {
        super(mau);
        this.chieuDai=chieuDai;
        this.chieuRong=chieuRong;
    }
    @Override
    public double tinhDienTich()
    {
        return chieuDai*chieuRong;
    }
    public double tinhChuVi()
    {
        return (chieuDai+chieuRong)*2;
    }
    @Override
    public String layThongTin()
    {
        return super.layThongTin()+"Chieu dai:"+chieuDai +" Chieu rong:"+chieuRong;
    }
}
