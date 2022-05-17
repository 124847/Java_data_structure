package 树和堆和优先队列;

import java.util.Iterator;

public class Heap<T extends Comparable<T>> implements Iterable{   //泛型T 实现Comparable接口 这里用extends 不用implements
    private T[] items;

    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        //至于为什么不支持泛型化数组其实是跟Java的泛型实现机制有关的，
        // Java的泛型其实只是编译期间的一种安全性检查，避免程序员书写代码时候存储类型出错，
        // 而在运行时Java会将所有的泛型转为Object类型的也就是被称为类型擦除的机制
        //1.stack1 中的String会被擦除，从而被转换为LinkedStack[]类型
        //2.Object[] arrays = stack1; 转换为Object,而数组会记住他自己的类型为LinkedStack，
        // 若此时我们尝试将一个String赋值给数组，即arrays[0] = "hello";就会出现类型转换异常
        //    java.lang.ClassCastException:cannot be cast to LinkedStack
        //    所以出于这个原因,不允许创建泛型数组
        //不过需要说明的是,只是不允许创建这些数组，而声明类型LinkedStack< String >[] 的变量是合法的
        //只是不能使用new LinkedStack<>()[10]来初始化这个变量
        //例如我们可以使用Object进行类型转换，但是就是需要我们自己每次赋值的时候保证类型安全
        this.N = 0;
    }

    public boolean greater(int i, int j) {
        return items[i].compareTo(items[j]) > 0;
    }

    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public T delMax() {
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k >= 2) {
            if (greater(k, k / 2)) {
                exch(k, k / 2);
                k = k / 2;
            }else{
                break;
            }
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int max;
            if (2 * k + 1 > N) {
                max = 2 * k;
            } else {
                max = greater(2 * k, 2 * k + 1) ? 2 * k : 2 * k + 1;
            }
            if (greater(k, max)) {
                break;
            }
            exch(k, max);
            k = max;
        }

    }

    @Override
    public Iterator iterator() {
        return new ita();
    }
    private class ita implements Iterator{

        int n;

        public ita() {
            n = 0;
        }
        @Override
        // ++ n 先自加在使用  n++ 先使用在自加
        public boolean hasNext() {
            return ++n <= N;
        }

        @Override
        public Object next() {
            return items[n];
        }
    }
}
