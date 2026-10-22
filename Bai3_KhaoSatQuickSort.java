import java.util.Arrays;
import java.util.Random;

public class Bai3_KhaoSatQuickSort {

    public static void shuffle(int[] a) {
        Random rand = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low + 1;
        int j = high;

        while (true) {
            while (i <= high && a[i] < pivot) i++;
            while (j >= low && a[j] > pivot) j--;
            if (i >= j) break;

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        int temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }

    public static void quickSortNoShuffle(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSortNoShuffle(a, low, p - 1);
            quickSortNoShuffle(a, p + 1, high);
        }
    }

    public static void quickSortWithShuffle(int[] a) {
        shuffle(a);
        quickSortNoShuffle(a, 0, a.length - 1);
    }

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

    public static void main(String[] args) {
        int n = 10000;
        System.out.println("=== KHẢO SÁT BÀI 3: QUICKSORT (SHUFFLE vs KHÔNG SHUFFLE) ===");

        // Mảng ngẫu nhiên
        int[] rand1 = generateRandomArray(n);
        int[] rand2 = Arrays.copyOf(rand1, rand1.length);

        long start = System.currentTimeMillis();
        quickSortNoShuffle(rand1, 0, rand1.length - 1);
        long end = System.currentTimeMillis();
        System.out.printf("Mảng Ngẫu Nhiên - Không Shuffle: %d ms\n", (end - start));

        start = System.currentTimeMillis();
        quickSortWithShuffle(rand2);
        end = System.currentTimeMillis();
        System.out.printf("Mảng Ngẫu Nhiên - Có Shuffle   : %d ms\n", (end - start));

        int[] sorted1 = generateSortedArray(n);
        int[] sorted2 = Arrays.copyOf(sorted1, sorted1.length);

        try {
            start = System.currentTimeMillis();
            quickSortNoShuffle(sorted1, 0, sorted1.length - 1);
            end = System.currentTimeMillis();
            System.out.printf("Mảng Đã Sắp Xếp - Không Shuffle: %d ms\n", (end - start));
        } catch (StackOverflowError e) {
            System.out.println("Mảng Đã Sắp Xếp - Không Shuffle: Bị StackOverflowError (Đệ quy quá sâu $O(N^2)$)");
        }

        start = System.currentTimeMillis();
        quickSortWithShuffle(sorted2);
        end = System.currentTimeMillis();
        System.out.printf("Mảng Đã Sắp Xếp - Có Shuffle   : %d ms\n", (end - start));
    }
}