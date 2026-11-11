import java.util.*;

public class SolutionBai4 {

    // Khai báo Node dạng static để tránh đụng độ tên lớp với các file khác
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Hàm chèn giá trị vào BST để dựng cây kiểm thử
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Hàm tìm Tổ tiên chung gần nhất (Lowest Common Ancestor - LCA)
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        // Nếu cả v1 và v2 đều nhỏ hơn root, LCA phải nằm ở cây con bên trái
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        // Nếu cả v1 và v2 đều lớn hơn root, LCA phải nằm ở cây con bên phải
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }

        // Trường hợp v1 và v2 nằm về 2 phía của root (hoặc 1 trong 2 giá trị bằng root)
        // Khi đó, root chính là tổ tiên chung gần nhất
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            Node root = null;

            // Đọc các giá trị để dựng cây BST
            for (int i = 0; i < n; i++) {
                int data = scan.nextInt();
                root = insert(root, data);
            }

            // Đọc 2 giá trị v1 và v2 cần tìm LCA
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();

            // Tìm và in ra giá trị của LCA
            Node ans = lca(root, v1, v2);
            if (ans != null) {
                System.out.println(ans.data);
            }
        }

        scan.close();
    }
}