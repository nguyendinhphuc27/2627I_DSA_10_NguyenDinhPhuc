import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai5_QuickSort1Partition {
    public static void partition(int[] ar) {
        int pivot = ar[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int x : ar) {
            if (x < pivot) left.add(x);
            else if (x == pivot) equal.add(x);
            else right.add(x);
        }

        for (int x : left) System.out.print(x + " ");
        for (int x : equal) System.out.print(x + " ");
        for (int x : right) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            partition(ar);
        }
        sc.close();
    }
}