package Collection.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by solitude on 2017/2/7.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("java001");
        c.add("java002");
        c.add("java003");
        c.add("java004");
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // 为了释放迭代器，建议使用下面这种方法，it1是局部变量
        for (Iterator<String> it1 = c.iterator(); it1.hasNext();) {
            System.out.println(it1.next());
        }
    }
}
