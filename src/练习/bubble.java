package 练习;

public class bubble{
    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            boolean f = true;
            for (int j = 1; j < a.length - i; j++) {
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                    f = false;
                }
            }
            if (f) {
                break;
            }
        }
    }
}
