package 练习;

public class merage {
    private static Comparable[] assist;

    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int i, int j) {
        if (j <= i) {
            return;
        }
        int mid = i + (j - i) / 2;
        sort(a, i, mid);
        sort(a, mid + 1, j);
        merage(a, i, mid, j);
    }

    private static  void merage(Comparable[] a,int i,int mid, int j) {
        int index = i;
        int n = i;
        int m = mid + 1;
        while (n <= mid && m <= j) {
            if (greater(a[n], a[m])) {
                assist[index++] = a[m++];
            }else{
                assist[index++] = a[n++];
            }
        }
        while (n <= mid) {
            assist[index++] = a[n++];
        }
        while (m <= mid) {
            assist[index++] = a[m++];
        }
        for (int i1 = i; i1 <= j; i1++) {
            a[i1] = assist[i1];
        }
    }

}
