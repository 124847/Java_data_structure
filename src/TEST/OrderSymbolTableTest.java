package TEST;

import 栈和队列.OrderSymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {

        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        table.put(1, "张三");
        table.put(2, "李四");
        table.put(4, "赵六");
        table.put(7, "田七");
        for (Object o : table) {
            System.out.println(o);
        }
        table.put(3, "王五");
        for (Object o : table) {
            System.out.println(o);
        }
    }
}
