import java.util.*;

public class SolutionBai5 {

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

    // Hàm chính kiểm tra xem cây có phải là BST hay không
    boolean checkBST(Node root) {
        // Gọi hàm phụ trợ với khoảng giá trị ban đầu là từ âm vô cùng đến dương vô cùng
        return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Hàm đệ quy kiểm tra ràng buộc giá trị của từng nút
    boolean checkBSTUtil(Node node, int min, int max) {
        // Cây rỗng hoặc đã duyệt qua lá là BST hợp lệ
        if (node == null) {
            return true;
        }

        // Giá trị của nút hiện tại phải nằm nghiêm ngặt trong khoảng (min, max)
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Đệ quy kiểm tra:
        // - Cây con bên trái: tất cả giá trị phải nhỏ hơn node.data (max mới = node.data)
        // - Cây con bên phải: tất cả giá trị phải lớn hơn node.data (min mới = node.data)
        return checkBSTUtil(node.left, min, node.data) &&
                checkBSTUtil(node.right, node.data, max);
    }

    // --- Các hàm hỗ trợ dựng cây và test thử chương trình ---
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int data = scan.nextInt();
                root = insert(root, data);
            }

            SolutionBai5 sol = new SolutionBai5();
            if (sol.checkBST(root)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scan.close();
    }
}