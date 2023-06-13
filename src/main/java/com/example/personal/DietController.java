package com.example.personal;




import com.example.personal.BasicClass.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    private TableColumn<Meal, String> MealTypeColumn;
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

        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        MealTypeColumn.setCellValueFactory(new PropertyValueFactory<>("MealType"));
        QuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        CaloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        ProteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        FatColumn. setCellValueFactory(new PropertyValueFactory<>("fat"));


        File file = new File("src/main/resources/com/example/personal/DaysJson/Lunedi");

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            try {
                List<Meal> meals = mapper.readValue(file, new TypeReference<>() {});
                diettable.getItems().addAll(meals);
            } catch (IOException e) {
                throw new RuntimeException(e);
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
            System.out.println(diettable.getItems().get(0).getMealType());

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
        }
    }

    void showNoMealSelectedAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Nessuna selezione");
        alert.setHeaderText("Non hai selezionato niente");
        alert.setContentText("Seleziona prima un pasto");
        alert.showAndWait();
    }
    @FXML
    public void remove() {
        try {
            int selectedIndex = selectedIndex();
            diettable.getItems().remove(selectedIndex);
        } catch (NoSuchElementException e) {
            showNoMealSelectedAlert();
        }
    }


    public void edit() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("dietnewedit.fxml"));
            DialogPane view = loader.load();
            DietneweditController controller = loader.getController();

            // Set an empty meal into the controller
            controller.setMeals(new Meal(diettable.getItems().get(selectedIndex())));

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Nuovo Pasto");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CLOSE) == ButtonType.APPLY) {
                diettable.getItems().set(selectedIndex(),controller.getMeals());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        statistics();
    }

    @FXML
    public void newMeal(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("dietnewedit.fxml"));
            DialogPane view = loader.load();
            DietneweditController controller = loader.getController();

            // Set an empty person into the controller
            controller.setMeals(new Meal("", "", 0.0, 0.0, 0.0, 0.0));

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Nuovo Pasto");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CLOSE) == ButtonType.APPLY) {
                diettable.getItems().add(controller.getMeals());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        statistics();
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