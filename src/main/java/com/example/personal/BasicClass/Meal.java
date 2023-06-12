package com.example.personal.BasicClass;

public class Meal {
    public String name;
    public String mealtype;
    public Double protein;
    public Double calories;
    public Double fat;

    public Double quantity;

    public Meal() {}

    public Meal(String name, String mealtype, Double protein, Double calories, Double fat, Double quantity) {
        this.name = name;
        this.mealtype = mealtype;
        this.protein = protein;
        this.calories = calories;
        this.fat = fat;
        this.quantity = quantity;
    }


    public Meal (Meal other) {
        this.name=other.name;
        this.mealtype= other.mealtype;
        this.protein=other.protein;
        this.calories=other.calories;
        this.fat=other.fat;
        this.quantity=other.quantity;
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

    public String getMealType() {
        return mealtype;
    }

    public void setMealType(String mealtype) {
        this.mealtype = mealtype;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
