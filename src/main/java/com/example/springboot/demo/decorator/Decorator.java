package com.example.springboot.demo.decorator;

import lombok.Data;

@Data
public abstract class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}