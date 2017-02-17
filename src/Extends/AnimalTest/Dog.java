package Extends.AnimalTest;

/**
 * Created by solitude on 2017/1/5.
 */
public class Dog extends Animal {
    public void lookDoor() {
        System.out.println(this.getName() + "正在看门...");
    }
    public void shout(){
        System.out.println(this.getName()+"汪汪");
    }
}
