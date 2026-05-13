import java.util.Scanner;

public class DemSoAm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Trong chuoi co " + demSoAm(s) + " số âm");
        sc.close();
    }

    public static int demSoAm(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                count++;
            }
        }
        return count;
    }
}
