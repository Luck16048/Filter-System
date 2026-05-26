package org.example.entity;

public class Person {
    private String name;
    private int age;
    private Sex sex;
    private Nationality nationality;

    public Person(String name, int age, Sex sex, Nationality nationality) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nationality = nationality;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Sex getSex() {
        return this.sex;
    }

    public Nationality getNationality() {
        return this.nationality;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + sex + " " + nationality;
    }
}
