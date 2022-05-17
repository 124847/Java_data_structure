package 练习;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new ita();
    }
    private class ita implements Iterator<T>{
        private Node n;

        public ita() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            return (n = n.next).item;
        }
    }
    private class Node {
        private Node next;
        private T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    private Node head;

    private int N;

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        this.N = 0;
        this.head.next = null;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return this.N;
    }

    public T get(int i) {
        Node n = this.head;
        for (int i1 = 0; i1 <= i; i1++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t, int i) {
        Node n = this.head;
        for (int i1 = 0; i1 < i; i1++) {
            n = n.next;
        }
        n.next = new Node(n.next, t);
        N++;
    }


    public void insert(T t) {
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(null, t);
        N++;
    }

    public T remove(int i) {
        Node n = this.head;
        for (int i1 = 0; i1 < i; i1++) {
            n = n.next;
        }
        T t = n.next.item;
        n.next = n.next.next;
        N--;
        return t;
    }

    public int indexOf(T t) {
        Node n = this.head;
        for (int i = 0; i < length(); i++) {
            if (n.next.item == t) {
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }
    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
        // 注意递归在栈中开辟内存
    }
}
