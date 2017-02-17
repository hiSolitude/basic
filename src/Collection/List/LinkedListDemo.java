package Collection.List;

import java.util.LinkedList;

/**
 * Created by solitude on 2017/2/8.
 *
 *linkedList 添加，删除
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("java01");
        list.addFirst("java02");
        list.addFirst("java03");
        list.addFirst("java04");
        System.out.println(list);
        System.out.println(list.getFirst());

        while (!list.isEmpty()){
            System.out.println(list.removeLast());

            System.out.println(list);
        }
    }
}
