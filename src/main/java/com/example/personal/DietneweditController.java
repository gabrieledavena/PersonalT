package com.example.personal;

import com.example.personal.BasicClass.Meal;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class DietneweditController {


    @FXML
    private TextField CaloriesField;

    @FXML
    private TextField FatField;

    @FXML
    private ChoiceBox<String> MealChoiceBox;

    @FXML
    private TextField NameField;

    @FXML
    private TextField ProteinField;

    @FXML
    private TextField QuantityField;
    Meal meals;
    private final String[] mealtypes = {"Colazione", "Merenda", "Pranzo", "Cena"};

    @FXML
    public void initialize() {
        CaloriesField.textProperty().addListener((observable, oldValue, newValue) -> meals.setCalories(Double.valueOf(newValue)));
        FatField.textProperty().addListener((observable, oldValue, newValue) -> meals.setFat(Double.valueOf(newValue)));
        NameField.textProperty().addListener((observable, oldValue, newValue) -> meals.setName(newValue));
        ProteinField.textProperty().addListener((observable, oldValue, newValue) -> meals.setProtein(Double.valueOf(newValue)));
        QuantityField.textProperty().addListener((observable, oldValue, newValue) -> meals.setQuantity(Double.parseDouble(newValue)));
        MealChoiceBox.getItems().addAll(mealtypes);
        MealChoiceBox.valueProperty().addListener((observableValue, oldvalue, newvalue) -> meals.setMealType(newvalue));
    }

    void update() {
        CaloriesField.textProperty().set(String.valueOf(meals.getCalories()));
        FatField.textProperty().set(String.valueOf(meals.getFat()));
        NameField.textProperty().set(String.valueOf(meals.getName()));
        ProteinField.textProperty().set(String.valueOf(meals.getProtein()));
        QuantityField.textProperty().set(String.valueOf(meals.getQuantity()));
        MealChoiceBox.valueProperty().set(meals.getMealType());

    }


    public Meal getMeals() {
        return meals;
    }

    public void setMeals(Meal meals) {
        this.meals = meals;
        update();
    }
}
