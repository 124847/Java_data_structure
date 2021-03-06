package 栈和队列;

/**
 * @author Lenovo
 */
public class SymbolTable<Key, Value> {

    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int N;

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }
    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        head.next = new Node(key, value, head.next);
        N++;
    }

    public void delete(Key key) {
        if (size() == 0) {
            return;
        }
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head;
        while ((n = n.next) != null) {
            if (n.key.equals(key)) {
                break;
            }
        }
        return n.value;
    }
}
