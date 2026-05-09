package communityuni.com;

import java.util.ArrayList;

public class BaiTap9_5_2026 {
	//class Staff
	public static class Staff{
		ArrayList<StaffMember> staffList;
		public void payday() {
			
		}
	}
	//class StaffMember
	public static abstract class StaffMember{
		String name;
		String address;
		String phone;
		public StaffMember() {
			this.name = "";
			this.address = "";
			this.phone = "";
		}
		public String toString()
		{
			return "";
		}
		public double pay() {
			return 0;
		}
	}
	//class Volunteer ke thua tu StaffMember
	public static class Volunteer extends StaffMember{
		@Override
		public double pay() {
			return 1;
		}
	}
	//class Employee ke thua tu StaffMember
	public static class Employee extends StaffMember{
		String socialSecurityNumber;
		double payRate;
		@Override
		public String toString() {
			return "Employee";
		}
		@Override
		public double pay() {
			return 2;
		}
	}
	//Lop Executive ke thua tu Employee 
	public static class Executive extends Employee{
		double bonus;
		public void AwardBonus(double execBonus) {
			
		}
		@Override
		public double pay() {
			return 1;
		}
	}
	//Lop Hourly ke thua tu Employee
	public static class Hourly extends Employee{
		int hourWorker;
		public void AddHour(int MoreHour) {
			
		}
		@Override
		public double pay() {
			return 3;
		}
		@Override
		public String toString() {
			return "Hourly";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
