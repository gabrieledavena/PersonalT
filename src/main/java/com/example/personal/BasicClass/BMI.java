package com.example.personal.BasicClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMI {
    double height;
    double weight;
    double BMIvalue;

    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
        BigDecimal bd = new BigDecimal(weight/((height*height)/10000)).setScale(2, RoundingMode.HALF_UP);
        this.BMIvalue = bd.doubleValue();
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
