package com.example.springboot.demo.DecoratorTest;

public class Test {

    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();

        md1.setPerson(man);
        //装饰器模式，讲道理我没懂啊。。。
        md2.setPerson(md1);
        md2.eat();
    }

}
