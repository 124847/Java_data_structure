package TEST;

import 树和堆和优先队列.MinPriorityQueue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        while (!queue.isEmpty()) {
            System.out.println(queue.deletemin());
        }
    }
}
