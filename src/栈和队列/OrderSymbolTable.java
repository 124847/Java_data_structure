package 栈和队列;

import java.util.Iterator;
/*
继承Comparable接口  即可获取Comparable的功能
实现接口方法即可获取接口的功能 ，
如果尖括号里的东西不清楚可以不写即可，jvm会根据类的内容填充  即按照哪个对象继承或实现填充为该对象相关内容
私有类如果不写尖括号里的内容会使用外面大类的尖括号的内容
*/
//
/**
 * @author Lenovo
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> implements Iterable{

    @Override
    public Iterator iterator() {
        return new ita();
    }

    private class ita implements Iterator {
        private Node n;

        public ita() {
            n = head;
        }
        @Override
        public boolean hasNext() {
            return (n = n.next) != null;
        }

        @Override
        public Object next() {
            return new String(n.key +":"+ n.value);
        }
    }

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

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }
    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node n = head;
        while (n.next != null && n.next.key.compareTo(key) < 0) {
            n = n.next;
        }

        if (n.next!=null && n.next.key.compareTo(key) == 0) {
            n.next.value = value;
        }
        else{
            n.next = new Node(key, value, n.next);
        }
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
