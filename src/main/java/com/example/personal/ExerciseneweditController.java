package com.example.personal;

import com.example.personal.BasicClass.Exercise;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ExerciseneweditController {
    @FXML
    private TextField SerieField;
    @FXML
    private TextField esercizioField;
    @FXML
    private TextField muscolareField;
    @FXML
    private TextField pesoField;
    @FXML
    private TextField ripetizioniField;
    Exercise exercises;

    @FXML
    public void initialize() {
        esercizioField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setName(newValue));
        muscolareField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setMuscleGroup(newValue));
        SerieField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setSeries(Integer.parseInt(newValue)));
        ripetizioniField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setRepetitions(Integer.parseInt(newValue)));
        pesoField.textProperty().addListener((observable, oldValue, newValue) -> exercises.setWeight(Double.parseDouble(newValue)));

    }

    void update() {
        esercizioField.textProperty().set(exercises.getName());
        muscolareField.textProperty().set(exercises.getMuscleGroup());
        SerieField.textProperty().set(String.valueOf(exercises.getSeries()));
        ripetizioniField.textProperty().set(String.valueOf(exercises.getRepetitions()));
        pesoField.textProperty().set(String.valueOf(exercises.getWeight()));

    }

    public Exercise getExercises() {
        return exercises;
    }

    public void setExercises(Exercise exercises) {
        this.exercises = exercises;
        update();
    }
}
