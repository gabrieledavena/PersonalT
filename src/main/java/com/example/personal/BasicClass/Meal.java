package com.example.personal.BasicClass;

public class Meal {
    public String name;
    public String Meal;
    public Double protein;
    public Double calories;
    public Double fat;

    public Double quantity;

    public Meal(String name, String meal, Double protein, Double calories, Double fat, Double quantity) {
        this.name = name;
        Meal = meal;
        this.protein = protein;
        this.calories = calories;
        this.fat = fat;
        this.quantity = quantity;
    }

    public Meal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public String getMeal() {
        return Meal;
    }

    public void setMeal(String meal) {
        Meal = meal;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
