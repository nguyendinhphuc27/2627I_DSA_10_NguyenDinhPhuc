import java.util.*;

public class Solution_bai7 {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Mảng đếm tần suất các số từ 0 đến 99
        int[] frequency = new int[100];

        // Đếm số lần xuất hiện của mỗi phần tử
        for (int num : arr) {
            frequency[num]++;
        }

        // Chuyển kết quả sang danh sách List<Integer> theo yêu cầu đề bài
        List<Integer> result = new ArrayList<>();
        for (int count : frequency) {
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }

        List<Integer> result = countingSort(arr);

        // In danh sách các số lần xuất hiện từ 0 tới 99
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }
        System.out.println();

        in.close();
    }
}