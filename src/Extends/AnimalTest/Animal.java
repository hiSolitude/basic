package Extends.AnimalTest;

/**
 * Created by solitude on 2017/1/5.
 */
public class Animal {
    private String color;
    private String name;

    public String getName() {
        return name;
    }
    public Animal setName(String name) {
        this.name = name;
        return this;
    }
    public String getColor() {
        return color;
    }
    public Animal setColor(String color) {
        this.color = color;
        return this;
    }
    public void shout() {
        System.out.println("叫一声...");
    }

    public void eat(String food){
        System.out.println(this.name+"在吃"+food);
    }
}
