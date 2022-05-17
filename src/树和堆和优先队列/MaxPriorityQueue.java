package 树和堆和优先队列;

public class MaxPriorityQueue <T extends Comparable<T>>{

    private T[] items;
    private int N;
    public MaxPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public boolean greater(int i, int j) {
        return items[i].compareTo(items[j]) > 0;
    }
    public boolean equal(int i, int j) {
        return items[i].compareTo(items[j]) == 0;
    }

    public void exch(int i, int j) {
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public T delMax() {
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public void swim(int k) {
        while (k >= 2) {
            if (greater(k, k / 2)) {
                exch(k, k / 2);
                k = k / 2;
            }else{
                break;
            }
        }
    }

    public void sink(int k) {
        while (k * 2 <= N) {
            int max;
            if (k * 2 + 1 <= N) {
                max = greater(k * 2, k * 2 + 1) ? k * 2 : k * 2 + 1;
            }
            else{
                max = 2 * k;
            }
            if (greater(max, k)|| equal(max,k)) {
                exch(k, max);
                k = max;
            }else{
                break;
            }
        }
    }
}
