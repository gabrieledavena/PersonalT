package com.example.personal.BasicClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMI {
    double height;
    double weight;
    double BMIvalue;

    double goal;

    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
        BigDecimal bd = new BigDecimal(weight/((height*height)/10000)).setScale(2, RoundingMode.HALF_UP);
        this.BMIvalue = bd.doubleValue();

        double tmp=0;
        if (bd.doubleValue() < 18.5) {
            tmp= (bd.doubleValue() - 18.5) *((height*height)/10000);
        }   else if (bd.doubleValue() > 24.9){
            tmp = (24.9 -bd.doubleValue())*((height*height)/10000);
        }
        BigDecimal goalrounded = new BigDecimal(tmp).setScale(2, RoundingMode.HALF_UP);
        this.goal = goalrounded.doubleValue();
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

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }
}
