package domain;

public class GIAOVIEN {
	private String MAGV;
	private String TENGV;
	private String HOCVI;
	private String HOCHAM;
	private int GIOITINH;
	private int HESO;
	private double MUCLUONG;
	private String MAKHOA;
	public GIAOVIEN(String MAGV, String TENGV, String HOCVI, String HOCHAM, int GIOITINH, int HESO, double MUCLUONG, String MAKHOA) {
        this.MAGV = MAGV;
        this.TENGV = TENGV;
        this.HOCVI = HOCVI;
        this.HOCHAM = HOCHAM;
        this.GIOITINH = GIOITINH;
        this.HESO = HESO;
        this.MUCLUONG = MUCLUONG;
        this.MAKHOA = MAKHOA;
    }
	public String getMAGV() {
        return MAGV;
    }

    public void setMAGV(String MAGV) {
        this.MAGV = MAGV;
    }

    // TENGV
    public String getTENGV() {
        return TENGV;
    }

    public void setTENGV(String TENGV) {
        this.TENGV = TENGV;
    }

    // HOCVI
    public String getHOCVI() {
        return HOCVI;
    }

    public void setHOCVI(String HOCVI) {
        this.HOCVI = HOCVI;
    }

    // HOCHAM
    public String getHOCHAM() {
        return HOCHAM;
    }

    public void setHOCHAM(String HOCHAM) {
        this.HOCHAM = HOCHAM;
    }

    // GIOITINH
    public int getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(int GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    // HESO
    public int getHESO() {
        return HESO;
    }

    public void setHESO(int HESO) {
        this.HESO = HESO;
    }

    // MUCLUONG
    public double getMUCLUONG() {
        return MUCLUONG;
    }

    public void setMUCLUONG(double MUCLUONG) {
        this.MUCLUONG = MUCLUONG;
    }

    // MAKHOA
    public String getMAKHOA() {
        return MAKHOA;
    }

    public void setMAKHOA(String MAKHOA) {
        this.MAKHOA = MAKHOA;
    }
    public String ToString() {
    	return "MAGV : {"+this.MAGV+
    			"} TENGV : {"+this.TENGV+
    			"} HOCVI : {"+this.HOCVI+
    			"} HOCHAM : {"+this.HOCHAM+
    			"} GIOITINH : {" + (this.GIOITINH == 0 ? "{NAM}" : "{NU}")+
    			"} HESO : {"+ this.HESO +
    			"} MUCLUONG : {"+this.MUCLUONG+
    			"} MAKHOA : {"+this.MAKHOA+"}";
    }
}
