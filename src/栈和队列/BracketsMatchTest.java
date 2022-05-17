package 栈和队列;

public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "(上海(长安)()))";
        System.out.println(isMatch(str));
    }

    public static boolean isMatch(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
