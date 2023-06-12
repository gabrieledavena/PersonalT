package com.example.personal;

import com.example.personal.BasicClass.Meal;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.EventListener;

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
    }

    void update() {
        CaloriesField.textProperty().set(String.valueOf(meals.getCalories()));
        FatField.textProperty().set(String.valueOf(meals.getFat()));
        NameField.textProperty().set(String.valueOf(meals.getName()));
        ProteinField.textProperty().set(String.valueOf(meals.getProtein()));
        QuantityField.textProperty().set(String.valueOf(meals.getQuantity()));
        MealChoiceBox.converterProperty().addListener((observable) -> meals.setMealType(MealChoiceBox.getValue()));

    }

    public void getMealTypes(ActionEvent event) {
        String myMeal=MealChoiceBox.getValue();
    }

    public Meal getMeals() {
        return meals;
    }

    public void setMeals(Meal meals) {
        this.meals = meals;
        update();
    }
}
