package TEST;

import 栈和队列.Stack;

/**
 * @author Lenovo
 */
//后缀表达式


public class ReversePolishNotationTest {

    public static void main(String[] args) {
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        System.out.println(caculate(notation));
    }

    public static Double caculate(String[] notation) {
        Stack<Double> stack = new Stack<>();
        Double t1;
        Double t2;
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            switch (curr) {
                case "+":
                    t1 = stack.pop();
                    t2 = stack.pop();
                    stack.push(t2 + t1);
                    break;
                case "-":
                    t1 = stack.pop();
                    t2 = stack.pop();
                    stack.push(t2 - t1);
                    break;
                case "*":
                    t1 = stack.pop();
                    t2 = stack.pop();
                    stack.push(t2 * t1);
                    break;
                case "/":
                    t1 = stack.pop();
                    t2 = stack.pop();
                    stack.push(t2 / t1);
                    break;
                default:
                    stack.push(Double.parseDouble(curr));
                    break;
            }
        }

        return stack.pop();
    }
}
