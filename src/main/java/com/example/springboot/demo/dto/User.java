package com.example.springboot.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    @NotBlank(message = "iamnullname")
    private String name;
    @NotBlank(message = "iamnullage")
    private int age;
}
