
class Node {
    char data;
    Node firstChild;
    Node nextSibling;

    public Node(char data) {
        this.data = data;
        this.firstChild = null;
        this.nextSibling = null;
    }
}

class GeneralTree {
    Node root;

    public GeneralTree(char data) {
        root = new Node(data);
    }

    // Them mot nut con vao nut cha
    public void addChild(char parentData, char childData) {
        Node parent = findNode(root, parentData);

        if (parent == null) {
            System.out.println("Khong tim thay nut cha!");
            return;
        }

        Node child = new Node(childData);

        // Neu chua co con thi them lam con truong
        if (parent.firstChild == null) {
            parent.firstChild = child;
        } else {
            // Them vao cuoi danh sach anh em
            Node temp = parent.firstChild;

            while (temp.nextSibling != null) {
                temp = temp.nextSibling;
            }

            temp.nextSibling = child;
        }
    }

    // Tim mot nut theo gia tri
    public Node findNode(Node node, char data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node;
        }

        Node result = findNode(node.firstChild, data);

        if (result != null) {
            return result;
        }

        return findNode(node.nextSibling, data);
    }

    // 1. Tim bo cua mot nut
    public Node findParent(Node current, char data) {
        if (current == null) {
            return null;
        }

        Node child = current.firstChild;

        while (child != null) {
            if (child.data == data) {
                return current;
            }

            Node result = findParent(child, data);

            if (result != null) {
                return result;
            }

            child = child.nextSibling;
        }

        return null;
    }

    // 2. Tim con truong
    public Node findFirstChild(char data) {
        Node node = findNode(root, data);

        if (node == null) {
            return null;
        }

        return node.firstChild;
    }

    // 3. Tim em lien ke
    public Node findNextSibling(char data) {
        Node node = findNode(root, data);

        if (node == null) {
            return null;
        }

        return node.nextSibling;
    }

    // In ket qua
    public void display() {
        displayTree(root, 0);
    }

    private void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }

        System.out.println(node.data);

        displayTree(node.firstChild, level + 1);
        displayTree(node.nextSibling, level);
    }
}

public class w9_tailop_25021944 {
    public static void main(String[] args) {

        // Tao cay tong quat co goc A
        GeneralTree tree = new GeneralTree('A');

        // Them cac nut vao cay
        tree.addChild('A', 'B');
        tree.addChild('A', 'C');
        tree.addChild('A', 'D');

        tree.addChild('B', 'E');
        tree.addChild('B', 'F');

        tree.addChild('D', 'G');

        // Hien thi cay
        System.out.println("CAY TONG QUAT:");
        tree.display();

        // Tim bo
        char x = 'E';
        Node parent = tree.findParent(tree.root, x);

        System.out.print("\nBo cua nut " + x + ": ");
        System.out.println(parent != null ? parent.data : "Khong co");

        // Tim con truong
        x = 'A';
        Node firstChild = tree.findFirstChild(x);

        System.out.print("Con truong cua nut " + x + ": ");
        System.out.println(firstChild != null ? firstChild.data : "Khong co");

        // Tim em lien ke
        x = 'B';
        Node sibling = tree.findNextSibling(x);

        System.out.print("Em lien ke cua nut " + x + ": ");
        System.out.println(sibling != null ? sibling.data : "Khong co");
    }
}
