package com.example.personal;

import com.example.personal.BasicClass.Exercise;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ExerciseneweditController {
    @FXML
    private TextField SerieField;
    @FXML
    private TextField esercizioField;

    @FXML
    private ChoiceBox<String> muscolarChoiceBox;

    @FXML
    private TextField pesoField;
    @FXML
    private TextField ripetizioniField;
    Exercise exercises;

    private final String[] muscle = {"Petto", "Schiena", "Spalle", "Braccia", "Gambe", "Addominali", "Glutei", "Polpacci"};


    @FXML
    public void initialize() {
        esercizioField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setName(newValue));
        SerieField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setSeries(Integer.parseInt(newValue)));
        ripetizioniField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setRepetitions(Integer.parseInt(newValue)));
        pesoField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setWeight(Double.parseDouble(newValue)));
        muscolarChoiceBox.getItems().addAll(muscle);
        muscolarChoiceBox.valueProperty().addListener((observableValue, oldvalue, newvalue) -> exercises.setMuscleGroup(newvalue));


    }

    void update() {
        esercizioField.textProperty().set(exercises.getName());
        SerieField.textProperty().set(String.valueOf(exercises.getSeries()));
        ripetizioniField.textProperty().set(String.valueOf(exercises.getRepetitions()));
        pesoField.textProperty().set(String.valueOf(exercises.getWeight()));
        muscolarChoiceBox.valueProperty().set(exercises.getMuscleGroup());

    }

    public Exercise getExercises() {
        return exercises;
    }

    public void setExercises(Exercise exercises) {
        this.exercises = exercises;
        update();
    }
}
