package com.example.personal.BasicClass;

import javafx.beans.property.*;

public class Person {

    private String firstName ;
    private String lastName;
    private String street;
    private String gender;
    private Integer postalCode;
    private String city;
    private Integer age;
    public Person() {}
    public Person(String firstName, String lastName, String street, String gender, int postalCode, String city, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.gender = gender;
        this.postalCode = postalCode;
        this.city = city;
        this.age = age;
    }

    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.street = other.street;
        this.gender = other.gender;
        this.postalCode = other.postalCode;
        this.city = other.city;
        this.age = other.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}