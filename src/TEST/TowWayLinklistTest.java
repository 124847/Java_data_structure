package TEST;


public class TowWayLinklistTest {
    public static void main(String[] args) {
        练习.TowWayLinkList<String> s1 = new 练习.TowWayLinkList<>();
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
        System.out.println(s1.indexOf("科比"));
//        s1.clear();
        System.out.println(s1.getFirst());
        System.out.println(s1.getLast());

    }
}
