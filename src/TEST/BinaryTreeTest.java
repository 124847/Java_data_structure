package TEST;

import 树和堆和优先队列.BinaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "张三");
        tree.put(0, "李四");
        tree.put(-5, "王五");
        System.out.println(tree.size());

        System.out.println(tree.size());
        System.out.println(tree.Min());
    }
}
