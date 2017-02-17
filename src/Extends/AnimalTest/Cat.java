package Extends.AnimalTest;

/**
 * Created by solitude on 2017/1/5.
 */
public class Cat extends Animal {
    public void catchMouse(){
        System.out.println(this.getName()+"正在斗老鼠...");
    }
    public void shout(){
        System.out.println(this.getName()+"......"+this.getColor()+"喵喵");
    }
}
