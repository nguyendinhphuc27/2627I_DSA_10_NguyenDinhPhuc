import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai5_RunningMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int N = scanner.nextInt();

        // maxPQ lưu nửa phần tử nhỏ, minPQ lưu nửa phần tử lớn
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int val = scanner.nextInt();

            // Thêm vào maxPQ trước
            maxPQ.add(val);
            // Đưa phần tử lớn nhất của maxPQ sang minPQ để đảm bảo thứ tự
            minPQ.add(maxPQ.poll());

            // Cân bằng kích thước: maxPQ luôn chứa nhiều hơn hoặc bằng minPQ
            if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // Tính trung vị
            double median;
            if (maxPQ.size() > minPQ.size()) {
                median = maxPQ.peek();
            } else {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            }

            System.out.printf("%.1f\n", median);
        }

        scanner.close();
    }
}