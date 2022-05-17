package 栈和队列;

import java.util.Iterator;

public class Stack <T> implements Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return new ita();
    }

    private class ita implements Iterator<T> {
        private Node<T> n;

        public ita() {
            n = head;
        }
        @Override
        public boolean hasNext() {
            return (n = n.next) != null;
        }

        @Override
        public T next() {
            return n.item;
        }
    }

    private class Node<T> {
        Node next;
        T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    private Node head;
    private int N;

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return this.N;
    }

    public void push(T t) {
        head.next = new Node(head.next, t);
        N++;
    }

    public T pop() {
        if(head.next == null){
            return null;
        }
        Node<T> t = head.next;
        head.next = head.next.next;
        N--;
        return  t.item;
    }

}
