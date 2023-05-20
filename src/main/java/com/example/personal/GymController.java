package com.example.personal;


import com.example.personal.BasicClass.Exercise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private TableColumn<Exercise, Integer> seriesColumn;
    @FXML
    private TableColumn<Exercise, Integer> repetitionColumns;
    @FXML
   private TableColumn<Exercise, Double> weightColumn;
    /**
     * Initializes the controller class. This method is automatically called after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        // Initialize the person table with the two columns.
        exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        muscleGroupColumn.setCellValueFactory(new PropertyValueFactory<>("muscleGroup"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));
        repetitionColumns.setCellValueFactory(new PropertyValueFactory<>("repetitions"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        Extable.setItems(getExerciseData());
    }

    ObservableList<Exercise> getExerciseData() {
        ObservableList<Exercise> exercises = FXCollections.observableArrayList();
        exercises.add(new Exercise("sega", "pene", 1,10,5.0));
        exercises.add(new Exercise("dio", "karim", 1,10,5.0));
        return exercises;
    }
}

