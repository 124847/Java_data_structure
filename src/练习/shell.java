package 练习;

public class shell {
    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 2) {
            h = h * 2 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h /= 2;
        }
    }
}
