package 练习;

public class insertion {
    private static boolean greater(Comparable w, Comparable q) {
        return w.compareTo(q) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length -1 ; i++) {
            for (int j = i + 1; j >= 1; j--) {
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                }else{
                    break;
                }

            }
        }
    }
}
