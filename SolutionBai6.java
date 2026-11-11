import java.util.*;

public class SolutionBai6 {

    // Khai cấu trúc Node cho cây AVL
    static class Node {
        int val;   // Giá trị của nút
        int ht;    // Chiều cao của nút (height)
        Node left; // Cây con trái
        Node right;// Cây con phải

        public Node(int val) {
            this.val = val;
            this.ht = 0; // Nút lá mới sinh ra có chiều cao bằng 0
            this.left = null;
            this.right = null;
        }
    }

    // Lấy chiều cao của một nút (trả về -1 nếu nút rỗng)
    static int height(Node n) {
        if (n == null) return -1;
        return n.ht;
    }

    // Tính hệ số cân bằng (Balance Factor) của nút
    static int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    // Phép xoay phải (Right Rotation)
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Thực hiện xoay
        x.right = y;
        y.left = T2;

        // Cập nhật lại chiều cao
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        // Trả về gốc mới sau khi xoay
        return x;
    }

    // Phép xoay trái (Left Rotation)
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Thực hiện xoay
        y.left = x;
        x.right = T2;

        // Cập nhật lại chiều cao
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        // Trả về gốc mới sau khi xoay
        return y;
    }

    // Hàm chèn một giá trị vào cây AVL và tự cân bằng
    public static Node insert(Node root, int val) {
        // 1. Thực hiện chèn thông thường như BST
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root; // Không cho phép giá trị trùng lặp trong cây
        }

        // 2. Cập nhật lại chiều cao của nút hiện tại
        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        // 3. Lấy hệ số cân bằng để kiểm tra xem nút này có bị mất cân bằng hay không
        int balance = getBalance(root);

        // Xử lý 4 trường hợp mất cân bằng:

        // Trường hợp Left Left (Mất cân bằng lệch trái - trái)
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // Trường hợp Right Right (Mất cân bằng lệch phải - phải)
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // Trường hợp Left Right (Mất cân bằng lệch trái - phải)
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Trường hợp Right Left (Mất cân bằng lệch phải - trái)
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Trả về con trỏ gốc không đổi nếu cây đã cân bằng
        return root;
    }

    // Hàm duyệt cây theo thứ tự trước (Pre-order) kèm in ra chiều cao để kiểm tra
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + "(BF=" + getBalance(root) + ") ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int val = scan.nextInt();
                root = insert(root, val);
            }
            preOrder(root);
        }
        scan.close();
    }
}