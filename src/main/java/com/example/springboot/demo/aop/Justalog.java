package com.example.springboot.demo.aop;


import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
public @interface Justalog {

    String value() default "v1";

}
