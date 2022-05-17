package TEST;

import 排序.Insertion;
import 排序.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PowerTest {
    public static void main(String[] args) throws IOException {
        //创建一个ArrayList集合,保存读取出来的整数
        ArrayList<Integer> list = new ArrayList<>();
        //创建缓存读取流BufferedReader 读取数据并存储到ArrayList中
        BufferedReader reader = new BufferedReader(new InputStreamReader(PowerTest.class.getClassLoader().getResourceAsStream("Power.txt")));

        String line = null;
        while ((line = reader.readLine()) != null) {
            Integer integer = Integer.valueOf(line);
            list.add(integer);
        }
        reader.close();
        Integer[] a = new Integer[list.size()];
        Integer[] b = new Integer[list.size()];
        list.toArray(a);
        list.toArray(b);
        TestShell(a);
        TestInsertion(b);

    }


    public static void TestShell(Integer[] a) {
        long start = System.currentTimeMillis();
        Shell.sort(a);
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void TestInsertion(Integer[] a) {
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        System.out.println(System.currentTimeMillis() - start);
    }
}