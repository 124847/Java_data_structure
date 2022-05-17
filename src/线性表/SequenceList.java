package 线性表;

import java.util.Iterator;
//ArrayList底层就是数组实现
public class SequenceList<T>implements Iterable<T> {
    private T[] eles;
    private int N;

    public SequenceList(int Capacity) {
        this.eles = (T[]) new Object[Capacity];
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

    public void insert(T t) {
        if (N == capacity()) {
            resize(capacity()*2);
        }
        eles[N++] = t;
    }

    public void insert(T t, int i) {
        if (N == capacity()) {
            resize(capacity()*2);
        }
        for (int index = N ; index > i ; index--) {
            eles[index] = eles[index - 1];
        }
        eles[i] = t;
        N++;
    }

    public T remove(int i) {
        T x = eles[i];
        for (int index = i; index < N -1; index++) {
            eles[i] = eles[i + 1];
        }
        N--;
        if (N < capacity() / 4) {
            resize(capacity()/2);
        }
        return x;
    }

    public T get(int i) {
        return eles[i];
    }
    public void resize(int newsize) {
        T[] temp = eles;
        eles = (T[]) new Object[newsize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }
        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public T next() {
            return eles[cusor++];
        }
    }
}
