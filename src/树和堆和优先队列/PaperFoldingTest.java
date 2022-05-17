package 树和堆和优先队列;

import 栈和队列.Queue;

public class PaperFoldingTest {
    public static void main(String[] args) {
        Node<String> tree = createTree(2);
        printTree(tree);

    }

    public static Node<String> createTree(int n) {
        Node<String> root = null;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                root = new Node<>("down", null, null);
                continue;
            }
            Queue<Node> nodes = new Queue<>();
            nodes.enqueue(root);

            while (!nodes.isEmpty()) {
                Node<String> node = nodes.dequeue();
                if (node.left != null) {
                    nodes.enqueue(node.left);
                }if (node.right != null) {
                    nodes.enqueue(node.right);
                }
                if (node.left == null && node.right == null) {
                    node.left = new Node("down", null, null);
                    node.right = new Node("up", null, null);
                }
            }
        }
        return root;
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            printTree(root.left);
        }
        System.out.print(root.item + " ");

        if (root.right != null) {
            printTree(root.right);
        }
    }
    public static class Node<T> {
        public T item;
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
