package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by solitude on 2017/2/7.
 */
public class TestList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");
        list.add("ddd");

        //list中定义的针对索引的操作
        list.add(4,"eee");
        System.out.println("---------------------");

        //根据索引获取某个指定的元素
        String str = (String) list.get(0);
        System.out.println(str);
        System.out.println("---------------------");
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("-----------------------------");

        //获取集合中指定元素的位置，返回-1标示查找的元素不存在
        System.out.println(list.indexOf("abc"));
        System.out.println(list.lastIndexOf("aaa"));
        System.out.println("-------------------");

        //将集合中移除指定索引处的元素
        list.remove(3);
        System.out.println(list);
        System.out.println("+++++++++++++");

        //从集合中移除指定索引处的元素进行修改
        list.set(3,"ggg");

        //从指定的集合中截取对应索引的 元素组成一个小集合
        List<String> l = list.subList(2,4);
        System.out.println(l);

        //Iterator 从前往后遍历list集合，在迭代过程中不能使用集合中的方法对元素进行添加、删除操作，，但可以进行修改
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------");

        //ListIterator：可以从指定位置遍历，可以从前往后遍历，也可以从后往前遍历
        //在遍历的过程中，可以使用ListIterator中的方法对元素进行判断，取出，添加，，删除的操作
        //不能使用List中的方法进行添加，删除的操作
        ListIterator<String> it2 = list.listIterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("--------------------------");
        while (it2.hasPrevious()){
            System.out.println(it2.previous());
        }
        System.out.println("--------------------------");
    }
}
