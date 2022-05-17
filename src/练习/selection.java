package 练习;

public class selection {
    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minindex], a[j])) {
                    minindex = j;
                }
            }
            exch(a,minindex,i);
        }
    }
}
