package 排序;

/*
  比较次数  ((n -1) + 1)(n - 1) / 2 = n^2/2 - n/2
  交换次数  ((n -1) + 1)(n - 1) / 2 = n^2/2 - n/2

 */
//
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (greater(a[j], a[j - 1])) {
                    break;
                }
                exch(a, j, j - 1);
            }
        }

    }

    public static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
