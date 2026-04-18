package communityuni.com;
public class FirstProgram {

	public static void ptcl(double a,double b)
	{
		if(a==0 && b==0)
			System.out.println("PT vo so nghiem");
		else if (a==0 && b!=0)
		{
			System.out.println("PT vo nghiem");
		}
		else
		{
			System.out.println("Pt co nghiem x = "+(-b/a));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ghi chu 1 dong
		/*ghi chu nhieu dong
		 * 22
		 */
		
	}
	public abstract class ConNguoi
	{
		int tuoi;
		String ten;
		String cccd;
		public ConNguoi()
		{
			tuoi = 0;
			ten = "";
			cccd = "";
		}
		public ConNguoi(int t,String ten,String cccd)
		{
			this.tuoi = t;
			this.ten = ten;
			this.cccd = cccd;
		}
		public int GetAge()
		{
			return tuoi;
		}
		public String GetName()
		{
			return ten;
		}
		public String GetId()
		{
			return cccd;
		}
		public virtu
	}
	public class Male extends ConNguoi
	{
		
	}

}
