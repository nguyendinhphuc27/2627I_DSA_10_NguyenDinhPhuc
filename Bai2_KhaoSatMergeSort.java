import java.util.Arrays;
import java.util.Random;

public class Bai2_KhaoSatMergeSort {

    // Insertion Sort
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // MergeSort
    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(a, left, L, 0, n1);
        System.arraycopy(a, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    // Sinh dữ liệu
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }

    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 30000};

        System.out.println("=== KHẢO SÁT BÀI 2: MERGESORT vs INSERTION SORT ===");
        for (int n : sizes) {
            System.out.println("\n------------------------------------------------");
            System.out.println("KÍCH THƯỚC MẢNG N = " + n);

            // Ngẫu nhiên
            int[] randArr = generateRandomArray(n);
            runTest("Ngẫu nhiên", randArr);

            // Đã sắp xếp
            int[] sortedArr = generateSortedArray(n);
            runTest("Đã sắp xếp", sortedArr);

            // Ngược
            int[] revArr = generateReverseSortedArray(n);
            runTest("Sắp xếp ngược", revArr);
        }
    }

    private static void runTest(String label, int[] original) {
        int[] a1 = Arrays.copyOf(original, original.length);
        int[] a2 = Arrays.copyOf(original, original.length);

        long start = System.currentTimeMillis();
        insertionSort(a1);
        long end = System.currentTimeMillis();
        long t1 = end - start;

        start = System.currentTimeMillis();
        mergeSort(a2, 0, a2.length - 1);
        end = System.currentTimeMillis();
        long t2 = end - start;

        System.out.printf("[%s] Insertion Sort: %d ms | MergeSort: %d ms\n", label, t1, t2);
    }
}