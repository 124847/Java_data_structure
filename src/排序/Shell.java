package 排序;

public class Shell {
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 2) {
            h = h * 2 + 1;
        }
        while (h >= 1) {
            for (int i = h; i <= a.length - 1; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j], a[j - h])) {
                        break;
                    }
                    exch(a, j, j - h);
                }
            }
            h /= 2;
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
