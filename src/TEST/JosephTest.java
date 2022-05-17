package TEST;

public class JosephTest {
    private static class Node<T> {
        Node next;
        T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                first = new Node<Integer>(null, i);
                pre = first;
                continue;
            }
            pre = pre.next = new Node<Integer>(null, i);
            if (i == 41) {
                pre.next = first;
            }
        }
        //方法一 打印约瑟夫数列
//        int count = 0;
//        Node<Integer> before = new Node<>(first, null);
//        Node<Integer> curr = before;
//        while (curr.next != curr) {
//            count++;
//            if (count == 3) {
//                count = 0;
//                System.out.print(curr.next.item + ",");
//                curr.next = curr.next.next;
//
//            }else{
//            curr = curr.next;}
//        }
//        System.out.println(curr.item);

        //方法二，打印约瑟夫环

        Node curr = first;
        Node before = null;
        int count = 0;

        while (curr != curr.next) {
            count++;
            if (count == 3) {
                before.next = curr.next;
                count = 0;
                System.out.print(curr.item + ",");
            }else{
                before = curr;
            }
            curr = curr.next;
        }

        System.out.println(curr.item);

        //打印所有节点的数据
//        while (t.next != first) {
//            System.out.println(t.item);
//            t = t.next;
//            if (t.next == first) {
//                System.out.println(t.item);
//            }
//        }



    }
}
