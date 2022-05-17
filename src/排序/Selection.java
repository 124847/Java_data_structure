package 排序;

/*
  比较次数  ((n -1) + 1)(n - 1) / 2 = n^2/2 - n/2
  交换次数  n - 1
 */
//
public class Selection {
    public static void sort(Comparable[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[min], a[j])) {
                    min = j;
                }
            }
            exch(a, min, i);

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
