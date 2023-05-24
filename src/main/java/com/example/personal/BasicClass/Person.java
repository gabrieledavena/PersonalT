package com.example.personal.BasicClass;

import javafx.beans.property.*;

public class Person {

    private StringProperty firstName ;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty gender;
    private IntegerProperty postalCode;
    private StringProperty city;
    private IntegerProperty age;
    public Person() {}
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

    public void setFirstName(StringProperty firstName) {
        this.firstName=firstName;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(StringProperty lastName) {
        this.lastName=lastName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(StringProperty street) {
        this.street=street;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(StringProperty gender) {
        this.gender=gender;
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(IntegerProperty postalCode) {
        this.postalCode=postalCode;
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(StringProperty city) {
        this.city=city;
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

    public void setAge(IntegerProperty age) {
        this.age=age;
    }
}