import java.util.*;

public class SolutionBai3 {

    // Định nghĩa cấu trúc Node bên trong lớp Solution để tránh xung đột với các file khác
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

    // Hàm chèn giá trị vào BST
    public static Node insert(Node root, int data) {
        // Nếu cây/nhánh hiện tại rỗng, tạo và trả về nút mới
        if (root == null) {
            return new Node(data);
        }

        // Nếu giá trị nhỏ hơn hoặc bằng nút hiện tại, chèn vào cây con bên trái
        if (data <= root.data) {
            root.left = insert(root.left, data);
        }
        // Ngược lại, chèn vào cây con bên phải
        else {
            root.right = insert(root.right, data);
        }

        // Trả về gốc của cây sau khi đã chèn
        return root;
    }

    // Hàm in duyệt cây theo thứ tự trước (Pre-order traversal) để kiểm tra kết quả
    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int t = scan.nextInt();
            Node root = null;
            while(t-- > 0 && scan.hasNextInt()) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            preOrder(root);
        }
        scan.close();
    }
}