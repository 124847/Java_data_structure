package TEST;

import 排序.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
