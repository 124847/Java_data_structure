package TEST;

import 排序.Insertion;

import java.util.Arrays;

public class TestInsertion {
    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
