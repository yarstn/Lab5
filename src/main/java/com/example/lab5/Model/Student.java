package com.example.lab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private  String degree;
    private boolean status;
//    private ArrayList<String> students;
}
