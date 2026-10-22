import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bai6_WordCountTreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TreeMap tự động sắp xếp các khóa (key) theo thứ tự từ điển
        Map<String, Integer> wordMap = new TreeMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-z0-9]", "");
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // In danh sách từ kèm số lần xuất hiện
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}