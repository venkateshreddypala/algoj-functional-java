package objectoriented.basics;

public class HelloOOP {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.sayHello();
    }
}

class Greeter {
    public void sayHello() {
        System.out.println("Hello from OOP!");
    }
}