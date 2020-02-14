package com.example.springboot.demo.decorator;

public class ManDecoratorB extends Decorator {

	public void eat() {
		super.eat();
		System.out.println("===============");
		System.out.println("ManDecoratorB类");
	}
}