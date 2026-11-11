public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // gốc của BST

    private class Node {
        private Key key;           // khóa
        private Value val;         // giá trị liên kết
        private Node left, right;  // cây con trái và cây con phải
        private int size;          // số lượng nút trong cây con

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
}