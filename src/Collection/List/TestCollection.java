package Collection.List;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by solitude on 2017/2/7.
 */
public class TestCollection {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        Collection<String> c1 = new ArrayList<String>();
        Collection<String> c2 = new ArrayList<String>();
         show(c);
//        show(c1, c2);
    }
    public static void show(Collection<String> c1, Collection<String> c2) {
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");
        c2.add("abc2");
        c2.add("abc4");
        c2.add("abc6");
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        // c1.addAll(c2);
        c1.removeAll(c2);// 去除相同元素
        System.out.println("c1:" + c1);
    }
    public static void show(Collection<String> c) {
        // 添加元素
        c.add("abc1");
        c.add("abc2");
        c.add("abc3");
        c.add("abc2");
        System.out.println(c.toString());
        // 删除元素
        c.remove("abc2");// 会改变集合的长度
        System.out.println(c.toString());
    }
}
