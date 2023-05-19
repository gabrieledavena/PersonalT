package com.example.personal;


import com.example.personal.BasicClass.Exercise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.NoSuchElementException;

public class GymController {

    @FXML
    private TableView<Exercise> Extable;
    @FXML
    private TableColumn<Exercise, String> exerciseColumn;

    @FXML
    private TableColumn<Exercise, String> muscleGroupColumn;

    @FXML
    private TableColumn<Exercise, Integer> repetitionColumns;

    @FXML
    private TableColumn<Exercise, Integer> seriesColumn;

    @FXML
    private TableColumn<Exercise, Double> weightColumn;

    ObservableList<Exercise> list = FXCollections.observableArrayList(
        new Exercise("Panca pianca", "Petto"),
            new Exercise("Panca pianca", "Petto")

);
    @FXML
    public void initialize() {
        // Initialize the person table with the two columns.

        exerciseColumn.setCellValueFactory(new PropertyValueFactory<Exercise, String>(""));
        muscleGroupColumn.setCellValueFactory(new PropertyValueFactory<Exercise, String>("Gruppo muscolare"));
        repetitionColumns.setCellValueFactory(new PropertyValueFactory<>("Serie"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("Ripetizioni"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("Peso"));
        Extable.setItems(list);
        // Crea una lista osservabile di esercizi
        //ObservableList<Exercise> exercises = FXCollections.observableArrayList();

        // Aggiungi esercizi alla lista
        //exercises.add(new Exercise("Push-up", "kk", 10, 2, 4.5));

        // Imposta la lista di esercizi come dati della TableView


        //Extable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->showExerciseDetails(newValue));

        //Extable.setItems(getExerciseData());
        //Extable.getItems().add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));


        // Clear person details.
        //showExerciseDetails(null);
        // Listen for selection changes and show the person details when changed.
    }
/*
    @FXML
    public void DioKarim () {
        Extable.getItems().add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
    }
    ObservableList<Exercise> getExerciseData() {
        ObservableList<Exercise> exercises = FXCollections.observableArrayList();
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));

        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));
        exercises.add(new Exercise("Panca pianca", "Petto", 2, 10, 100.2 ));

        return exercises;
    }

 */

    int selectedIndex() {
        int selectedIndex = Extable.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            throw new NoSuchElementException();
        }
        return selectedIndex;
    }
}
