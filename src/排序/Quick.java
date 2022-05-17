package 排序;

public class Quick {
    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public  static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //分组
        int partition = partition(a, lo, hi);
        //左子组
        sort(a, lo, partition - 1);
        //右子组
        sort(a, partition + 1, hi);
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
