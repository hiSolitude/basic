package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by solitude on 2017/2/8.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("java01");
        list.add("java02");
        list.add("java03");
        ListIterator<String> it = list.listIterator();//获取列表迭代器对象
        // 它可以实现在迭代过程中完成元素的增删改查
        //注意：只有List集合具备该迭代器

        while(it.hasNext()){
            Object obj = it.next();
            if (obj.equals("java02"))
                it.add("java08");
        }
        System.out.println(list);

//         show_1(list);
//         show_2(list);
    }

    //List特有取出元素方法
    public static void show_2(List<String> list){
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    //通用方法
    public static void show_1(List<String> list){
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
