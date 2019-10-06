package io.effective;

public class Reentrant {
    public synchronized void sayHello() {
        System.out.println("hello");
    }

    public synchronized void sayYes() {
        System.out.println("Yes");
        sayHello();
    }

    public static void main(String[] args) {
        Reentrant r = new Reentrant();
        r.sayHello();
        r.sayYes();
    }
}
