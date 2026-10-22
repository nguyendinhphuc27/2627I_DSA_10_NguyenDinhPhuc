import java.util.Scanner;

public class Bai2_StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String A = sc.next();

        // Đảo ngược chuỗi A
        String reversed = new StringBuilder(A).reverse().toString();

        // So sánh chuỗi ban đầu và chuỗi đảo ngược
        if (A.equals(reversed)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}