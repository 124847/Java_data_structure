package 树和堆和优先队列;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }


    public void sink(int k) {
        int min;
        while (k * 2 <= N) {
            if (k * 2 + 1 <= N) {
                min = greater(2 * k, 2 * k + 1) ? 2 * k + 1 : 2 * k;
            }else{
               min  = 2 * k ;
            }
            if (greater(k, min) || equalter(min, k)) {
                exch(min, k);
                k = min;
            }else{
                break;
            }
        }
    }

    public void swim(int k) {
        while (k >= 2) {
            if (greater(k/2, k )) {
                exch(k, k / 2);
                k = k / 2;
            }else{
                break;
            }
        }
    }

    public void exch(int i, int j) {
        T t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public boolean greater(int i, int j) {
        return items[i].compareTo(items[j]) > 0;
    }

    public boolean equalter(int i, int j) {
        return items[i].compareTo(items[j]) == 0;
    }

    public static void sort(Comparable[] source){

    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T deletemin() {
        T min = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return min;
    }

    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }
}
