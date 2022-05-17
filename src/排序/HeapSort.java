package 排序;

public class HeapSort {
    private static boolean greater(Comparable[] heap,int i,int j) {
        return heap[i].compareTo(heap[j]) > 0;
    }

    private static void exch(Comparable[] heap, int i, int j) {
        Comparable t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    public static void createHeap(Comparable[] source, Comparable[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = (heap.length) / 2; i > 0; i--) {
            sink(heap, i, heap.length-1);
        }
    }

    public static void sort(Comparable[] source) {
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        int max = heap.length - 1;
        while (max >= 2) {
            exch(heap, 1, max);
            max--;
            sink(heap, 1, max);
        }
        System.arraycopy(heap, 1, source, 0, source.length);

    }
    private static void sink(Comparable[] heap, int target, int range) {
        while (2 * target <= range) {
            int max;
            if (2 * target + 1 <= range) {
                max = greater(heap, 2 * target, 2 * target + 1) ? 2 * target : 2 * target + 1;
            } else {
                max = 2 * target;
            }
            if(greater(heap, target,max)) {
                break;
            }
            exch(heap, target, max);
            target = max;
        }

        }
    }

