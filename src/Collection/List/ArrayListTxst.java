package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by solitude on 2017/2/8.
 */
public class ArrayListTxst {
    public static void main(String[] args){
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("小强",20));
        list.add(new Person("张三",21));
        list.add(new Person("李四",22));
        list.add(new Person("赵武",23));

        Iterator<Person> it = list.iterator();
        while (it.hasNext()){
            Person p = (Person)(it.next());
            System.out.println("name:"+p.getName()+"        age:"+p.getAge());
        }
    }
}

