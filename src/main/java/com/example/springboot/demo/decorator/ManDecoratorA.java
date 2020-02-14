package com.example.springboot.demo.decorator;

public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        System.out.println("再吃一顿饭");
        System.out.println("ManDecoratorA类");
    }
}

