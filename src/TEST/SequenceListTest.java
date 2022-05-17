package TEST;

import 线性表.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> s1 = new SequenceList<>(3);
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert("詹姆斯",1);
        for (String s : s1) {
            System.out.println(s);
        }
        String s = s1.get(1);
        System.out.println("获取的结果" + s);
        String s2 = s1.remove(0);
        System.out.println("删除的是"+ s2);
        s1.clear();
        System.out.println(s1.length());
        System.out.println(s1.capacity());


        练习.SequenceList<String> s4 = new 练习.SequenceList<>(3);
        s4.insert("姚明");
        s4.insert("科比");
        s4.insert("麦迪");
        s4.insert("詹姆斯",1);
        for (String s8 : s4) {
            System.out.println(s8);
        }
        String s9 = s4.get(1);
        System.out.println("获取的结果" + s9);
        String s5 = s4.remove(0);
        System.out.println("删除的是"+ s5);
        s4.clear();
        System.out.println(s4.length());
        System.out.println(s4.capacity());


    }
}
