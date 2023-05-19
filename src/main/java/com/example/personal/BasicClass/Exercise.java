package com.example.personal.BasicClass;

import javafx.beans.property.*;

public class Exercise {
    public final String name;
    public final String muscleGroup;
/*
    public final IntegerProperty series;

    public final IntegerProperty repetitions;

    public final DoubleProperty weight;

    public Exercise(String name, String muscleGroup, Integer series, Integer repetitions, Double weight) {
        this.name = new SimpleStringProperty(name);
        this.muscleGroup = new SimpleStringProperty(muscleGroup);
        this.series = new SimpleIntegerProperty(series);
        this.repetitions = new SimpleIntegerProperty(repetitions);
        this.weight = new SimpleDoubleProperty(weight);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMuscleGroup() {
        return muscleGroup.get();
    }

    public StringProperty muscleGroupProperty() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup.set(muscleGroup);
    }

    public int getSeries() {
        return series.get();
    }

    public IntegerProperty seriesProperty() {
        return series;
    }

    public void setSeries(int series) {
        this.series.set(series);
    }

    public int getRepetitions() {
        return repetitions.get();
    }

    public IntegerProperty repetitionsProperty() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions.set(repetitions);
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }*/

    public Exercise(String name, String muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

}
