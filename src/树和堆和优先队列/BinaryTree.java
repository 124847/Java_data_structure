package 树和堆和优先队列;

import java.util.Iterator;

import 栈和队列.Queue;

public class BinaryTree<Key extends Comparable, Value>implements Iterable {
    @Override
    public Iterator iterator() {
        return new ita();
    }

    private class ita implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;
    private int N;

    public BinaryTree() {
        this.root = null;
        N = 0;
    }

    public int size() {
        return this.N;
    }

    public void put(Key key, Value value) {
       root =  put(root,key,value);

    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        }else if (cmp < 0) {
            x.left = put(x.left,key,value);
        }else{
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);

    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        }
        else{
            return x.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        }else{
            N--;
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node rightleft = x.right;
            if (rightleft.left == null) {
                return rightleft;
            }
            while (rightleft.left.left != null) {
                rightleft = rightleft.left;
            }
            Node y = rightleft;
            rightleft = rightleft.left;
            y.left = null;
            rightleft.left = x.left;
            rightleft.right = x.right;
            x = rightleft;
        }
        return x;
    }
    //大写的是递归，小写的是循环
    public Key Min() {
        return Min(root).key;
    }
    private Key Max() {
        return Max(root).key;
    }

    private Node Min(Node x) {
        if (x.left != null) {
            return Min(x.left);
        }else
        {
            return x;
        }
    }

    private Node Max(Node x) {
        if (x.right != null) {
            return Max(x.right);
        }else{
            return x;
        }
    }
    public Key min() {
        return min(root).key;
    }
    private Key max() {
        return max(root).key;
    }

    private Node min(Node x) {
        Node n = x;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    private Node max(Node x) {
        Node n = x;
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node x ,Queue<Key> keys) {
        if (x == null) {
            return;
        }
        keys.enqueue(x.key);
        if (x.left != null) {
            preErgodic(x.left, keys);}
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> Queue = new Queue<>();
        midErgodic(root, Queue);
        return Queue;
    }

    private void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left,keys);
        }
        keys.enqueue(x.key);
        if (x.right != null) {
            midErgodic(x.right,keys);
        }
    }

    public Queue<Key> afterErgodic() {
        Queue<Key> Queue = new Queue<>();
        afterErgodic(root, Queue);
        return Queue;
    }

    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            afterErgodic(x.left,keys);
        }
        if (x.right != null) {
            afterErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> nodes = new Queue<Node>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            keys.enqueue(node.key);
            if (node.left != null) {
                nodes.enqueue(node.left);
            }
            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        int maxl = 0;
        int maxr = 0;
        if (x.left != null) {
            maxl = maxDepth(x.left);
        }
        if (x.right != null) {
            maxr = maxDepth(x.right);
        }
        return  (maxr > maxl ? maxr : maxl) + 1 ;
    }

    public Queue<Node> countnodeleaf() {
        Queue<Node> nodes = new Queue<>();
        countnodeleaf(root, nodes);
        return nodes;
    }

    public void Ergodicleaf() {
        for (Node node : countnodeleaf()) {
            System.out.println(node);
        }
    }

    public int leafsize() {
        return countnodeleaf().size();
    }
    private void countnodeleaf(Node x, Queue<Node> y) {
        if (x == null) {
            return;
        }
        if (x.left == null && x.right == null) {
            y.enqueue(x);
            return;
        }
        if (x.left != null) {
            countnodeleaf(x.left, y);
        }
        if (x.right != null) {
            countnodeleaf(x.right, y);
        }
        return;
    }
}
