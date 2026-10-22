import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai3_JesseAndCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }

        int operations = 0;

        // Lặp khi phần tử nhỏ nhất vẫn nhỏ hơn K
        while (pq.size() > 0 && pq.peek() < K) {
            // Nếu không còn đủ 2 bánh để kết hợp mà độ ngọt vẫn < K
            if (pq.size() < 2) {
                operations = -1;
                break;
            }

            int m1 = pq.poll(); // Bánh ít ngọt nhất
            int m2 = pq.poll(); // Bánh ít ngọt thứ hai

            int newCookie = m1 + 2 * m2;
            pq.add(newCookie);
            operations++;
        }

        System.out.println(operations);
        scanner.close();
    }
}