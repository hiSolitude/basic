package Extends.AnimalTest;

/**
 * Created by solitude on 2017/1/5.
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 当dog 继承 Animal 类之后
        // 在 dog 中无需定义 name 属性及 set方法
        // 我们可以调用,说明当 Dog 继承Animal的时候
        // 就从 Animal 中继承了属性的方法
        dog.setName("熊熊").shout();
        dog.eat("骨头");
        dog.lookDoor();

        Cat cat = new Cat();
        cat.setName("花花").setColor("黄色").shout();
        cat.eat("鱼鱼");
        cat.catchMouse();
    }
}

