import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Bai1_PriorityQueueDemo {
    public static void main(String[] args) {
        // Ví dụ MinPQ
        MinPQ<Integer> minPQ = new MinPQ<>();
        int[] data = {5, 2, 8, 1, 9, 3};

        for (int x : data) {
            minPQ.insert(x);
        }

        StdOut.println("Các phần tử lấy ra từ MinPQ (tăng dần):");
        while (!minPQ.isEmpty()) {
            StdOut.print(minPQ.delMin() + " ");
        }
        StdOut.println();

        // Ví dụ MaxPQ
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
        for (int x : data) {
            maxPQ.insert(x);
        }

        StdOut.println("Các phần tử lấy ra từ MaxPQ (giảm dần):");
        while (!maxPQ.isEmpty()) {
            StdOut.print(maxPQ.delMax() + " ");
        }
        StdOut.println();
    }
}