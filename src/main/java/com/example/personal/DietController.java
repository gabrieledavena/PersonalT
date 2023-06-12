package com.example.personal;



import com.example.personal.BasicClass.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

public class DietController {

    ArrayList<String> daysdata = new ArrayList<>();


    Integer Day =0;


    @FXML
    private Label TotalCaloriesLabel;

    @FXML
    private Label TotalFatLabel;

    @FXML
    private Label TotalProteinLabel;

    Double TotCalories;
    Double TotFat;
    Double TotProtein;

    @FXML
    private TableColumn<Meal, Double> CaloriesColumn;

    @FXML
    private TableColumn<Meal, Double> FatColumn;
    @FXML
    private TableColumn<Meal, String> MealColumn;
    @FXML
    private TableColumn<Meal, String> NameColumn;

    @FXML
    private TableColumn<Meal, Double> ProteinColumn;

    @FXML
    private TableColumn<Meal, Double> QuantityColumn;


    @FXML
    private TableView<Meal> diettable;


    public void initialize() {
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Lunedi");
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Martedi");
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Mercoledi");
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Giovedi");
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Venerdi");
        daysdata.add("src/main/resources/com/example/personal/DaysJson/Sabato");

        NameColumn. setCellValueFactory(new PropertyValueFactory<>("name"));
        MealColumn. setCellValueFactory(new PropertyValueFactory<>("Meal"));
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        CaloriesColumn. setCellValueFactory(new PropertyValueFactory<>("calories"));
        ProteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        FatColumn. setCellValueFactory(new PropertyValueFactory<>("fat"));




        File file = new File("src/main/resources/com/example/personal/DaysJson/Lunedi");

        if (file != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            try {
                List<Meal> meals = mapper.readValue(file, new TypeReference<>() {});
                diettable.getItems().addAll(meals);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        statistics();
    }

    public void statistics() {
        TotCalories= (double) 0;
        TotFat = (double) 0;
        TotProtein = (double) 0;
        for (int i =0; i<diettable.getItems().size(); i++) {
            TotCalories += diettable.getItems().get(i).getCalories();
            TotFat += diettable.getItems().get(i).getFat();
            TotProtein += diettable.getItems().get(i).getProtein();
        }
        TotalCaloriesLabel.setText(Double.toString(TotCalories));
        TotalFatLabel.setText(Double.toString(TotFat));
        TotalProteinLabel.setText(Double.toString(TotProtein));

    }

    public void changeDay (Integer Day) {


        File file = new File(daysdata.get(Day));
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            try {
                List<Meal> meals = mapper.readValue(file, new TypeReference<>() {});
                diettable.getItems().clear();
                diettable.getItems().addAll(meals);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            statistics();
    }


    int selectedIndex() {
        int selectedIndex = diettable.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            throw new NoSuchElementException();
        }
        return selectedIndex;
    }

    @FXML
    void save() {
        try {
            File file = new File(daysdata.get(Day));
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, diettable.getItems());

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
        }
    }









    public void setLunedi() {
        Day =0;
        changeDay(Day);
    }
    public void setMartedi() {
        Day =1;
        changeDay(Day);
    }
    public void setMercoledi() {
        Day =2;
        changeDay(Day);
    }
    public void setGiovedi() {
        Day =3;
        changeDay(Day);
    }
    public void setVenerdi() {
        Day =4;
        changeDay(Day);
    }
    public void setSabato() {
        Day =5;
        changeDay(Day);
    }
}