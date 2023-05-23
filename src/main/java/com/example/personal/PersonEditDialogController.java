package com.example.personal;


import com.example.personal.BasicClass.Person;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> person.firstNameProperty().set(newValue));
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> person.lastNameProperty().set(newValue));
        genderField.textProperty().addListener((observable, oldValue, newValue) -> person.genderProperty().set(newValue));
        addressField.textProperty().addListener((observable, oldValue, newValue) -> person.streetProperty().set(newValue));
        cityField.textProperty().addListener((observable, oldValue, newValue) -> person.cityProperty().set(newValue));
        postalCodeField.textProperty().addListener((observable, oldValue, newValue) -> person.postalCodeProperty().set(Integer.parseInt(newValue)));
        AgeField.textProperty().addListener((observable, oldValue, newValue) -> person.ageProperty().set(Integer.parseInt(newValue)));
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