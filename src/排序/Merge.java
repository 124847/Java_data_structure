package 排序;

public class Merge {
    private static Comparable[] assist;

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable w, Comparable q) {
        return w.compareTo(q) < 0;
    }
    public static void sort(Comparable[] a) {
        //初始化assist
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (hi <= lo) {
            return;
        }
        //对lo到hi之间的数据进行分为两个组
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        Merge(a, lo, mid, hi);
        //分别对每一组数据进行排序
        //再把两个组中的数据进行合并
    }

    private static void Merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p2], a[p1])) {
                assist[i++] = a[p2++];
            }else {
                assist[i++] = a[p1++];
            }
        }
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }
}
