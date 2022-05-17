package TEST;

public class FastSlowTest {
    private static class Node<T> {
        Node next;
        T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    public static Node<String> getcyclemiddle(Node<String> n) {
        if (n.next == null) {
            return null;
        }
        Node<String> mid = getextrance(n);
        Node<String> fast = n;
        Node<String> slow = n;
        while (fast.next != mid && mid !=fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = fast.next.next;
        slow = slow.next;
        while (fast.next != mid && mid !=fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static Node<String> getmiddle(Node<String> n) {
        if (n.next == null) {
            return null;
        }
        Node<String> fast = n;
        Node<String> slow = n;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    public static boolean iscycle(Node<String> n) {
        if (n.next == null) {
            return false;
        }
        Node<String> fast = n;
        Node<String> slow = n;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static Node<String> getextrance(Node n) {
        if (n.next == null) {
            return null;
        }
        Node<String> fast = n;
        Node<String> slow = n;
        Node<String> t = null;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (t != null) {
                t = t.next;
            }
            if (fast == slow) {
                t = n;
                continue;
            }

            if (t == slow) {
                break;
            }
        }

        return t;
    }
    public static void main(String[] args) {
        Node<String> one = new Node<>(null, "aa");
        Node<String> two = new Node<>(null, "bb");
        Node<String> three = new Node<>(null, "cc");
        Node<String> four = new Node<>(null, "dd");
        Node<String> five = new Node<>(null, "ee");
        Node<String> six = new Node<>(null, "ff");
        Node<String> seven = new Node<>(null, "gg");
        Node<String> eight = new Node<>(null, "hh");
        Node<String> nine = new Node<>(null, "ii");

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = three;
        System.out.println(getcyclemiddle(one).item);

    }
}
