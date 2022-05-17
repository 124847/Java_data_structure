package TEST;

import 树和堆和优先队列.Heap;

public class HeepTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(10);
        heap.insert("D");
        heap.insert("C");
        heap.insert("A");
        heap.insert("B");
//        heap.insert("E");
//        heap.insert("F");
//        heap.insert("G");
        for (Object o : heap) {
            System.out.println(o);
        }
        String result = null;
        while ((result = heap.delMax()) != null) {
            System.out.println(result+" ");
        }
    }
}
