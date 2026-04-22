package communityuni.com;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GameDoanSo {

	public static void main(String[] args) {
		while(true)
		{
			Random rand = new Random();
			int songaunhien = rand.nextInt(100);
			boolean winning = false;
			Scanner sc = new Scanner(System.in);
			for(int i=1;i<=7;i++)
			{
				try
				{
					System.out.print("Nhap so ban doan:");
					int songuoichoidoan = sc.nextInt();
					if(songuoichoidoan != songaunhien)
					{
						System.out.print("Ban da doan sai ");
						if(songuoichoidoan > songaunhien)
							System.out.println(songuoichoidoan+" lon hon ket qua");
						else
							System.out.println(songuoichoidoan+" nho hon ket qua");
					}
					else
					{
						System.out.println("Chuc mung ban da doan dung so "+songaunhien);
						winning = true;
						break;
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Sai dinh dang! Chi duoc nhap so");
					break;
				}
			}
			if(!winning)
			{
				System.out.println("Ban da het luot doan !!! ket qua la: "+songaunhien);
			}
			System.out.print("Ban co muon choi lai khong (Neu khong nhan N/Neu co nhan phim bat ky khac N):");
			Scanner sc2 = new Scanner(System.in);
			String query=sc2.nextLine();
			if(query.equalsIgnoreCase("N")==true)//Ham so sanh chuoi equalsIgnoreCase
			{
				System.out.println("Ket Thuc Tro Choi !!! Tam biet");
				break;
			}
		}
	}

}
