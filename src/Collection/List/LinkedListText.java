package Collection.List;

import java.util.LinkedList;

/**
 * Created by solitude on 2017/2/8.
 */
public class LinkedListText {
    public static void main(String[] args){
        DuiLie dl = new DuiLie();
        dl.myAdd("java01");
        dl.myAdd("java02");
        dl.myAdd("java03");
        while (!dl.isNull()){
            System.out.println(dl.myGet());
        }
    }
}
class DuiLie{
    private LinkedList link;
    DuiLie(){
        link = new LinkedList();
    }
    public void myAdd(Object obj){
        link.add(obj);
    }
    public Object myGet(){
        return link.removeFirst();
    }
    public boolean isNull(){
        return link.isEmpty();
    }
}
class DuiZhan{
    private LinkedList link;
    DuiZhan(){
        link = new LinkedList();
    }
    public void myAdd(Object obj){
        link.add(obj);
    }
    public Object myGet(){
        return link.removeLast();
    }
    public boolean isNull(){
        return link.isEmpty();
    }
}

