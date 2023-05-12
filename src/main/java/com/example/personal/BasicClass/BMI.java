package com.example.personal.BasicClass;

public class BMI {
    double height;
    double weight;
    double BMIvalue;

    public BMI(double height, double wieght, double BMIvalue) {
        this.height = height;
        this.weight = wieght;
        this.BMIvalue = BMIvalue;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBMIvalue() {
        return BMIvalue;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBMIvalue(double BMIvalue) {
        this.BMIvalue = BMIvalue;
    }
}
