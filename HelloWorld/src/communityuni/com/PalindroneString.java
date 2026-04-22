package communityuni.com;

import java.util.Scanner;

public class PalindroneString {

	public static boolean IsPalindrome(String s)
	{
		int j=s.length()-1;
		for(int i=0;i<s.length()/2;i++)
		{
			char charInPoiterFirst = s.charAt(i);
			char charInPoiterLast = s.charAt(j);
			if(charInPoiterFirst!=charInPoiterLast)
				return false;
			j--;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s =sc.nextLine();
		if(IsPalindrome(s))
			System.out.println("Chuoi tren la chuoi Palidrome");
		else
			System.out.println("Chuoi tren khong phai chuoi Palidrome");

	}

}
