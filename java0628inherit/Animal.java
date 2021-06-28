package java0628inherit;

public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat(String food){
        System.out.println(this.name+"正在吃"+food);
    }
}
