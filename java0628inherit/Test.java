package java0628inherit;

class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}
class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
    public void fly(){
        System.out.println(this.name+"正在飞");
    }
}
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("cat");
        cat.eat("cat food");
        Bird bird = new Bird("bird");
        bird.fly();
    }

}
