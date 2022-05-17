package 练习;

public class quick {
    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[]a ,int i, int j) {
        if (j <= i) {
            return;
        }
        int partition = partition(a, i, j);
        sort(a, i, partition - 1);
        sort(a, partition + 1, j);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable t = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (right >= lo + 1) {
                if (greater(t, a[--right])) {
                    break;
                }
            }
            while (left <= hi - 1) {
                if (greater(a[++left], t)) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }else{
                exch(a, left, right);
            }
        }
        exch(a, right, lo);
        return right;
    }
}
