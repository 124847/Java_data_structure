package TEST;

import 排序.Student;

public class TestComparable {
    public static Comparable getMax(Comparable a, Comparable b) {
        int result = a.compareTo(b);
        if (result >= 0) {
            return a;
        }
        else {
            return b;
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("lei", 20);
        Student s2 = new Student("lei", 20);
//        如果重写了toString方法那么输入变量名就会执行tostring方法
        System.out.println(getMax(s1, s2));
        System.out.println(s2);
        System.out.println(s2.toString());

    }
}
