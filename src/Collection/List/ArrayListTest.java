package Collection.List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by solitude on 2017/2/7.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //去除ArrayList中Person对象相同内容的元素。
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("wangcai",21));
        list.add(new Person("zhangsan", 22));
        list.add(new Person("lisi", 23));
        list.add(new Person("zhaoliu", 24));
        list.add(new Person("wangcai", 21));
        list.add(new Person("lisi", 23));
        System.out.println(list);
        list = getNewList(list);
        System.out.println(list);
        singleStringDemo();
    }

    //去除ArrayList集合中字符串中相同的元素
    public static void singleStringDemo(){
        ArrayList list = new ArrayList(); list.add("java01");
        list.add("java02");
        list.add("java05");
        list.add("java02");
        list.add("java04");
        list.add("java05");
        list.add("java04");
        System.out.println(list);
        list=getNewList(list);
        System.out.println(list);
    }

    public static  ArrayList getNewList(ArrayList list){
        ArrayList temp = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj  = it.next();
            if (!temp.contains(obj))
                temp.add(obj);
        }
        return temp;
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (!(obj instanceof Person))
            throw new RuntimeException("类型错误");
        Person p = (Person) obj;
//    System.out.println(this + "...equals..." + p.name + "---" + p.age);
        return name.equals(p.name) && age == p.age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
