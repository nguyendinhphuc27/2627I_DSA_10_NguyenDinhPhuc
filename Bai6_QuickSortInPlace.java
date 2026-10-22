import java.util.Scanner;

public class Bai6_QuickSortInPlace {
    public static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + (i == ar.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static int partitionLomuto(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
        }
        int temp = A[i];
        A[i] = A[high];
        A[high] = temp;

        printArray(A); // In mảng sau mỗi lần phân chia thành công
        return i;
    }

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int p = partitionLomuto(A, low, high);
            quickSort(A, low, p - 1);
            quickSort(A, p + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            quickSort(A, 0, n - 1);
        }
        sc.close();
    }
}