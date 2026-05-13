import java.util.Scanner;

public class Perfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap x (so thuc) va n (so nguyen duong):");
        double x = sc.nextDouble(); // Theo đề bài là nhập x, n
        int n = sc.nextInt();

        // 1. Tìm UCLN (Giả sử tìm UCLN của phần nguyên x và n)
        System.out.println("UCLN của " + (int) x + " và " + n + " là: " + timUCLN((int) x, n));

        // 2. Kiểm tra số hoàn thiện
        if (laSoHoanThien(n)) {
            System.out.println(n + " la so hoan thien");
        } else {
            System.out.println(n + " khong la so hoan thien");
        }

        // 3. Kiểm tra toàn chữ số chẵn
        if (laToanChuSoChan(n)) {
            System.out.println(n + " la chu so toan chan");
        } else {
            System.out.println(n + " khong la chu so toan chan");
        }

        // 4. Tính tổng S(x, n)
        System.out.println("Tong S(" + x + ", " + n + ") = " + tinhTongS(n, x));

        sc.close();
    }

    public static int timUCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static boolean laSoHoanThien(int n) {
        if (n <= 1)
            return false;
        int tong = 0;
        // Bắt đầu từ 1 để tránh lỗi chia cho 0
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                tong += i;
            }
        }
        return tong == n;
    }

    public static boolean laToanChuSoChan(int n) {
        if (n == 0)
            return true;
        n = Math.abs(n);
        // Điều kiện dừng là n > 0
        while (n > 0) {
            int chuso = n % 10;
            if (chuso % 2 != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static double tinhTongS(int n, double x) {
        double tong = 0;
        for (int i = 0; i <= n; i++) {
            int mau = 2 * i + 1;
            tong += Math.pow(x, mau) / giaithua(mau);
        }
        return tong;
    }

    public static long giaithua(int k) {
        long gt = 1;
        for (int i = 1; i <= k; i++) {
            gt *= i;
        }
        return gt;
    }
}