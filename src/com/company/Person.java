package com.company;
import java.util.Date;

public final class Person {
    private final String name;
    private final int age;
    private final Date dob;

    public Person(String name, int age, Date dob) {
        this.name = name;
        this.age = age;
        this.dob = new Date(dob.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }
}
