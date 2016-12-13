package com.example.sm.problem2;

public class Person {
    private String name;
    private int age;
    private int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = this.salary;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getSalary(int i) {return salary;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {this.age = age;}
    public void setSalary(int salary) {this.salary = salary; }
}