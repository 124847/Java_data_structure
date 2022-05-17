package 排序;

import java.util.Arrays;
/*比较次数  ((n -1) + 1)(n - 1) / 2 = n^2/2 - n/2
  交换次数  ((n -1) + 1)(n - 1) / 2 = n^2/2 - n/2
 */
//
public class Bubble {
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
    public static void exch(Comparable[] a, int h, int l) {
        Comparable t = a[h];
        a[h] = a[l];
        a[l] = t;
    }

    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int t = 0;
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] q = {1, 5, 7, 4, 1, 5};
        sort(q);
        System.out.println(Arrays.toString(q));
    }

}
