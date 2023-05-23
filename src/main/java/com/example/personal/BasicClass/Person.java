package com.example.personal.BasicClass;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private final StringProperty firstName ;
    private final StringProperty lastName;
    private final StringProperty street;
    private final StringProperty gender;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final IntegerProperty age;




    public Person(String firstName, String lastName, String street, String gender, int postalCode, String city, int age) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.gender = new SimpleStringProperty(gender);
        this.postalCode = new SimpleIntegerProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.age = new SimpleIntegerProperty(age);
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
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}