package TEST;

import 栈和队列.Queue;

/**
 * @author Lenovo
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.dequeue();
        System.out.println(queue.size());
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
