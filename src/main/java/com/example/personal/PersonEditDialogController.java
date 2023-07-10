package com.example.personal;


import com.example.personal.BasicClass.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PersonEditDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;

    @FXML
    private TextField genderField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField AgeField;
    Person person;

    @FXML
    public void initialize() {
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> person.setFirstName(newValue));
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> person.setLastName(newValue));
        genderField.textProperty().addListener((observable, oldValue, newValue) -> person.setGender(newValue));
        addressField.textProperty().addListener((observable, oldValue, newValue) -> person.setStreet(newValue));
        cityField.textProperty().addListener((observable, oldValue, newValue) -> person.setCity(newValue));
        postalCodeField.textProperty().addListener((observable, oldValue, newValue) -> person.setPostalCode(Integer.valueOf(newValue)));
        AgeField.textProperty().addListener((observable, oldValue, newValue) -> person.setAge(Integer.valueOf(newValue)));
    }

    void update() {
        firstNameField.textProperty().set(person.getFirstName());
        lastNameField.textProperty().set(person.getLastName());
        genderField.textProperty().set(person.getGender());
        addressField.textProperty().set(person.getStreet());
        cityField.textProperty().set(person.getCity());
        postalCodeField.textProperty().set(String.valueOf(person.getPostalCode()));
        AgeField.textProperty().set(String.valueOf(person.getAge()));
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        update();
    }

}