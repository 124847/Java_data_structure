package TEST;

import 栈和队列.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> table = new SymbolTable<>();
        table.put(1, "乔峰");
        table.put(2, "虚竹");
        table.put(3, "段誉");
        System.out.println(table.size());

        table.put(2, "慕容复");

        System.out.println(table.size());

        System.out.println(table.get(2));

        table.delete(2);

        System.out.println(table.size());

    }
}
