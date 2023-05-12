package com.example.personal;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.ProgressBar;

import java.time.LocalDate;

public class Week {
    public  ObjectProperty<LocalDate> Begindate;
    public  ObjectProperty<LocalDate> Endingdate;

    public ProgressBar Progress;


    public Week(ObjectProperty<LocalDate> begindate, ObjectProperty<LocalDate> endingdate) {
        Begindate = begindate;
        Endingdate = endingdate;
    }

    public Week(ObjectProperty<LocalDate> begindate, ObjectProperty<LocalDate> endingdate, double progress) {
        Begindate = begindate;
        Endingdate = endingdate;
    }

    public LocalDate getBegindate() {
        return Begindate.get();
    }

    public ObjectProperty<LocalDate> begindateProperty() {
        return Begindate;
    }

    public void setBegindate(LocalDate begindate) {
        this.Begindate.set(begindate);
    }

    public LocalDate getEndingdate() {
        return Endingdate.get();
    }

    public ObjectProperty<LocalDate> endingdateProperty() {
        return Endingdate;
    }

    public void setEndingdate(LocalDate endingdate) {
        this.Endingdate.set(endingdate);
    }

    public void openBMIview() {

    }

}
