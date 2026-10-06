import java.util.Scanner;

public class Solution_bai3 {

    public static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int val = arr[n - 1]; // Lấy phần tử cuối cùng cần chèn
        int i = n - 2;

        // Duyệt lùi từ phần tử kế cuối
        while (i >= 0 && arr[i] > val) {
            arr[i + 1] = arr[i]; // Dịch phần tử lớn hơn sang phải
            printArray(arr);      // In trạng thái mảng sau mỗi lần dịch
            i--;
        }

        // Đặt phần tử val vào đúng vị trí
        arr[i + 1] = val;
        printArray(arr);          // In trạng thái mảng hoàn chỉnh
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
        insertIntoSorted(ar);
    }
}