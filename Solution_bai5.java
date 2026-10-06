import java.util.Scanner;

public class Solution_bai5 {

    public static void insertionSortPart2(int[] ar) {
        int n = ar.length;
        // Chèn lần lượt từng phần tử từ vị trí 1 đến n - 1 vào mảng con đã sắp xếp phía trước
        for (int i = 1; i < n; i++) {
            int val = ar[i];
            int j = i - 1;

            // Dịch chuyển các phần tử lớn hơn val sang phải
            while (j >= 0 && ar[j] > val) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = val;

            // In ra trạng thái mảng sau mỗi lần hoàn tất chèn 1 số
            printArray(ar);
        }
    }

    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }
}