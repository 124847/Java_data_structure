package TEST;

import 线性表.LinkList;

/*麦迪
科比
姚明
詹姆斯
获取的结果麦迪
删除的是科比*/
public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> s1 = new LinkList<>();
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert("王少弋",2);
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println(s1.length());
    }
}
