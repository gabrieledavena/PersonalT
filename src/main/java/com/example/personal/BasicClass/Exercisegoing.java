package com.example.personal.BasicClass;

public class Exercisegoing extends Exercise{
    public Integer repetitionstatus;
    public Integer seriesstaus;

    public Exercisegoing(Integer repetitionstatus, Integer seriesstaus) {
        this.repetitionstatus = repetitionstatus;
        this.seriesstaus = seriesstaus;
    }

    public Exercisegoing(String name, String muscleGroup, Integer series, Integer repetitions, Double weight, Integer repetitionstatus, Integer seriesstaus) {
        super(name, muscleGroup, series, repetitions, weight);
        this.repetitionstatus = repetitionstatus;
        this.seriesstaus = seriesstaus;
    }

    public Exercisegoing(Exercise other, Integer repetitionstatus, Integer seriesstaus) {
        super(other);
        this.repetitionstatus = repetitionstatus;
        this.seriesstaus = seriesstaus;
    }


}
