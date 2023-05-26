package com.example.personal;

import com.example.personal.ExerciseneweditController;
import com.example.personal.BasicClass.Exercise;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


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

        File file = new File("src/main/resources/com/example/personal/exercises.json");
        if (file != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            try {
                List<Exercise>  exercises = mapper.readValue(file, new TypeReference<>() {});
                Extable.getItems().addAll(exercises);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    ObservableList<Exercise> getExerciseData() {
        ObservableList<Exercise> exercises = FXCollections.observableArrayList();
      // exercises.add(new Exercise("Panca piana", "petto", 1, 10, 5.0));
       //exercises.add(new Exercise("Flessioni", "Petto", 1, 10, 5.0));
        return exercises;
    }

    int selectedIndex() {
        int selectedIndex = Extable.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            throw new NoSuchElementException();
        }
        return selectedIndex;
    }

    /**
     * Shows a simple warning dialog
     */
    void showNoPersonSelectedAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Nessuna selezione");
        alert.setHeaderText("Non hai selezionato niente");
        alert.setContentText("Seleziona prima un esercizio");
        alert.showAndWait();
    }
    public void edit() {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("exercisenewedit.fxml"));
            DialogPane view = loader.load();
            ExerciseneweditController controller = loader.getController();

            // Set an empty person into the controller
            controller.setExercises(new Exercise(Extable.getItems().get(selectedIndex())));

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Nuovo esercizio");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CLOSE) == ButtonType.APPLY) {
                Extable.getItems().set(selectedIndex(),controller.getExercises());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void remove() {
        try {
            int selectedIndex = selectedIndex();
            Extable.getItems().remove(selectedIndex);
        } catch (NoSuchElementException e) {
            showNoPersonSelectedAlert();
        }
    }

    public void newexe(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("exercisenewedit.fxml"));
            DialogPane view = loader.load();
            ExerciseneweditController controller = loader.getController();

            // Set an empty person into the controller
           controller.setExercises(new Exercise("", "", 0, 0, 0.0));

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Nuovo esercizio");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CLOSE) == ButtonType.APPLY) {
                Extable.getItems().add(controller.getExercises());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void save() {
        try {
            File file = new File("src/main/resources/com/example/personal/exercises.json");
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, Extable.getItems());
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
        }
    }

}