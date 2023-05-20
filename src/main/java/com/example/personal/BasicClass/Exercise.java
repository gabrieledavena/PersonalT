package com.example.personal.BasicClass;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Exercise {

    public  String name;
    public  String muscleGroup;
    public  Integer series;
    public  Integer repetitions;
    public  Double weight;
    public Exercise(){

    }
    public Exercise(String name, String muscleGroup, Integer series, Integer repetitions, Double weight) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.series = series;
        this.repetitions = repetitions;
        this.weight = weight;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getMuscleGroup() {
            return muscleGroup;
        }
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series=series;
    }
    public int getRepetitions() {
        return repetitions;
    }
    public void setRepetitions(int repetitions) {
        this.repetitions=repetitions;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight=weight;
    }
}