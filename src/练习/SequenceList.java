package 练习;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    private T[] eles;
    private int N;

    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    public int capacity() {
        return eles.length;
    }
    public void clear() {
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        if (i >= N - 1) {
            System.out.println("输出的索引有误");
            return null;
        }
        return (eles[i]);
    }

    public void insert(T t, int i) {
        if (length() == eles.length) {
            resize(2 * eles.length);
        }
        for (int i1 = length() - 1; i1 >= i; i1--) {
            eles[i1 + 1] = eles[i1];
        }
        eles[i] = t;
        N++;
    }

    public void insert(T t) {
        if (length() == eles.length) {
            resize(2 * eles.length);
        }
        eles[length()] = t;
        N++;
    }

    public T remove(int i) {
        T t = eles[i];
        for (int i1 = i; i1 <= length() - 2; i1++) {
            eles[i1] = eles[i1 + 1];
        }
        N--;
        if (length() < eles.length / 4) {
            resize(eles.length / 2);
        }
        return t;

    }

    public int indexOf(T t) {
        for (int i = 0; i < length(); i++) {
            if (t.equals(eles[i])) {
                return i;
            }
        }
        return -1;
    }

    public void resize(int newsize) {
        T[] t = (T[]) new Object[newsize];

        for (int i = 0; i < length(); i++) {
            t[i] = eles[i];
        }
        eles = t;
    }

    @Override
    public Iterator iterator() {
        return new count();
    }

    private class count implements Iterator<T> {
        private int c;

        public count() {
            this.c = 0;
        }

        @Override
        public boolean hasNext() {
            return c < length();
        }

        @Override
        public T next() {
            return eles[c++];
        }
    }
}
