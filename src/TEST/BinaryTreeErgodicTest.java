package TEST;

import 栈和队列.Queue;
import 树和堆和优先队列.BinaryTree;

public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        Queue<String> queue1 = tree.preErgodic();
        Queue<String> queue2 = tree.midErgodic();
        Queue<String> queue3 = tree.afterErgodic();
        Queue<String> queue4 = tree.layerErgodic();
        for (String s : queue1) {
            System.out.println(tree.get(s)+"  "+s);
        }for (String s : queue2) {
            System.out.println(tree.get(s)+"  "+s);
        }for (String s : queue3) {
            System.out.println(tree.get(s)+"  "+s);
        }for (String s : queue4) {
            System.out.println(tree.get(s)+"  "+s);
        }
        System.out.println(tree.maxDepth());
        tree.Ergodicleaf();
        System.out.println(tree.leafsize());


    }


}
