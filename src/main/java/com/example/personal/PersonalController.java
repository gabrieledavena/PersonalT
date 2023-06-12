package com.example.personal;

import com.example.personal.BasicClass.Person;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;


import java.io.File;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class PersonalController {

    @FXML
    private Label AgeLabel;

    @FXML
    private Label GenderLabel;

    @FXML
    private Label LastNameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label postalCodeLabel;
    @FXML
    private BorderPane sidePane;


    @FXML
    private Button bmiButton;

    @FXML
    private Button recordCardButton;

    @FXML
    private Button Contatore;

    Person person = new Person("Shrek", "3", "Palude", "Orco", 999, "Far far away", 24);

    @FXML
    public void initialize() {
        showPersonDetails(null);
        try {

            File file = new File("src/main/resources/com/example/personal/Pe1.json");
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                person=mapper.readValue(file, new TypeReference<Person>() {});

            }
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Could not load data").showAndWait();

        }
        showPersonDetails(person);


    }

    Person getPersonData() {
return person;
    }


    private void showPersonDetails(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            LastNameLabel.setText(person.getLastName());
            addressLabel.setText(person.getStreet());
            postalCodeLabel.setText(String.valueOf(person.getPostalCode()));
            GenderLabel.setText(person.getGender());
            cityLabel.setText(person.getCity());
            AgeLabel.setText(String.valueOf(person.getAge()));
        } else {
            firstNameLabel.setText("");
            LastNameLabel.setText("");
            addressLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            AgeLabel.setText("");
        }
    }


    @FXML
    public void handleEditPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("person-edit-view.fxml"));
            DialogPane view = loader.load();
            PersonEditDialogController controller = loader.getController();

            controller.setPerson(getPersonData());

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Edit Person");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CANCEL) == ButtonType.OK) {
                //DEVO FARE UN METODO PER SALVARE LA PERSONA UNA  VOLTA MODIFICATA
                showPersonDetails(controller.getPerson());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleOpen() {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                Person person =mapper.readValue(file, new TypeReference<Person>() {});
                showPersonDetails(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Could not load data").showAndWait();

        }

    }


    @FXML
    void openBMIview() throws IOException {
        bmiButton.setDisable(true);
        recordCardButton.setDisable(false);
        Contatore.setDisable(false);
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BMIview.fxml")));
        sidePane.setCenter(view);
    }
    @FXML
    void openContatoreview() throws IOException {
        Contatore.setDisable(true);
        recordCardButton.setDisable(false);
        bmiButton.setDisable(false);
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Contatoreview.fxml")));
        sidePane.setCenter(view);
    }

    @FXML
    void openGymview() throws IOException {
        recordCardButton.setDisable(true);
        bmiButton.setDisable(false);
        Contatore.setDisable(false);
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GymView.fxml")));
        sidePane.setCenter(view);
    }

    @FXML
    void openDietaview () throws IOException {
        BorderPane view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("provadieta.fxml")));
        sidePane.setCenter(view);
    }

    @FXML
    void handleSaveAs() {
            try {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
                fileChooser.getExtensionFilters().add(extFilter);

                File file = fileChooser.showSaveDialog(null);
                if (file != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.registerModule(new JavaTimeModule());
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, getPersonData());
                }
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
            }
    }


    @FXML
    private void handleExit() {
        System.exit(0);
    }
}