package TEST;

import 栈和队列.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
