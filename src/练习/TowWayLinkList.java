package 练习;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new ita();
    }

    private class ita implements Iterator<T> {
        private Node n;

        public ita() {
            this.n = First;
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
    private class Node{
        Node next;
        Node pre;
        T item;

        public Node(T item, Node next, Node pre) {
            this.next = next;
            this.pre = pre;
            this.item = item;
        }
    }

    private Node First;
    private Node Last;
    private int N;

    public TowWayLinkList() {
        this.First = new Node(null, null, null);
        this.Last = new Node(null, null, null);
        this.N = 0;
    }

    public void clear() {
        this.N = 0;
        this.First.next = null;
        this.Last.pre = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return this.N;
    }

    public T getFirst() {
        if (isEmpty()){
            return null;
        }
        return First.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return Last.item;
    }

    public T get(int i) {
        if (i >= this.N) {
            return null;
        }
        Node n = First;
        for (int i1 = 0; i1 <= i; i1++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t) {
        if (isEmpty()) {
            First.next = Last = new Node(t, null, First);
        }else{
            Last = Last.next = new Node(t, null, Last);
        }
        N++;
    }

    public void insert(T t, int i) {
        if (isEmpty() || i == this.N) {
            insert(t);
            return;
        }
        Node n = First;
        for (int i1 = 0; i1 < i; i1++) {
            n = n.next;
        }
        n.next.next.pre = n.next = new Node(t, n.next, n);
        N++;
        }

    public T remove(int i) {
        if (isEmpty() || i > this.N - 1) {
            return null;
        }
        if (i == this.N - 1) {
            (Last = Last.pre).next = null;

        }
        Node n = First;
        for (int i1 = 0; i1 < i; i1++) {
            First = First.next;
        }
        T t = n.next.item;
        n.next.pre = n.next = n.next.next;
        N--;
        return t;
    }

    public int indexOf(T t) {
        Node n = First;
        int i = 0;
        while (n.next != null) {
            if ((n = n.next).item.equals(t)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

