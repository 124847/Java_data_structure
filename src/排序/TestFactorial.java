package 排序;

public class TestFactorial {
    public static void main(String[] args) {
        //求n的阶乘
        System.out.println(factorial(3));

    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }else{
            return n * factorial(n - 1);
        }
    }
}
