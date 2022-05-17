package 练习;

import TEST.PowerTest;
import 排序.Quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
//        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
//        shell.sort(a);
//        System.out.println(Arrays.toString(a));
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
        list.toArray(a);
        shell.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
