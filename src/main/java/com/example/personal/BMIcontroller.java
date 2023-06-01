package com.example.personal;

import com.example.personal.BasicClass.BMI;
import com.example.personal.BasicClass.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class BMIcontroller {

    @FXML
    private Label BMILabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label goalLabel;
    @FXML
    private Label statusLabel;

    @FXML
    private ProgressBar BMIbar;

    @FXML
    private Button SaveButton;

    BMI bmi=new BMI(185, 70);


    public void initialize () {
        BMIbar.setStyle("-fx-accent: #6c9a43;");

        try {
             File file = new File("src/main/resources/com/example/personal/bmi.json");
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                bmi =mapper.readValue(file, new TypeReference<BMI>() {});
                showBMIdetails(bmi);            }
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Could not load data").showAndWait();

        }

        showBMIdetails(getBMIdetails());
    }

    public BMI getBMIdetails() {
        return bmi;
    }

    private void showBMIdetails(BMI bmi) {
        if (bmi != null) {
            heightLabel.setText(String.valueOf(bmi.getHeight()));
            weightLabel.setText(String.valueOf(bmi.getWeight()));
            BMILabel.setText(String.valueOf(bmi.getBMIvalue()));

            goalLabel.setText(String.valueOf(bmi.getGoal())+ " kg");
            statusLabel.setText("");

            if (bmi.getBMIvalue()>=40) {
                statusLabel.setText("Obesità di ||| classe");
                BMIbar.setStyle("-fx-accent: #f62206;");
            }else if (bmi.getBMIvalue()>=35) {
                statusLabel.setText("Obesità di || classe");
                BMIbar.setStyle("-fx-accent: #f77f16;");
            }else if (bmi.getBMIvalue()>30) {
                statusLabel.setText("Obesità di | classe");
                BMIbar.setStyle("-fx-accent: #fad955;");
            } else if (bmi.getBMIvalue()>=25 ) {
                statusLabel.setText("Sovrappeso");
                BMIbar.setStyle("-fx-accent: #79f19e;");
            } else if (bmi.getBMIvalue()>=18.5) {
                statusLabel.setText("Normopeso");
                BMIbar.setStyle("-fx-accent: #007b00;");
            } else {
                statusLabel.setText("Sottopeso");
                BMIbar.setStyle("-fx-accent: #9dbff6;");
            }

            BMIbar.progressProperty().set(bmi.getBMIvalue()/40);
        }
    }

    public void setBMIDATA (BMI bmi) {
        this.bmi = bmi;
    }
    @FXML
    void weightplus() {
        BMI modified = new BMI( getBMIdetails().getHeight(), getBMIdetails().getWeight()+1);
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
        SaveButton.setStyle("-fx-border-color: #FF0000; -fx-border-width: 1.5");

    }

    @FXML
    void weightminus() {
        BMI modified = new BMI( getBMIdetails().getHeight(), getBMIdetails().getWeight()-1);
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
        SaveButton.setStyle("-fx-border-color: #FF0000; -fx-border-width: 1.5");
    }

    @FXML
    void heightplus() {
        BMI modified = new BMI( getBMIdetails().getHeight()+1, getBMIdetails().getWeight());
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
        SaveButton.setStyle("-fx-border-color: #FF0000; -fx-border-width: 1.5");
    }

    @FXML
    void heightminus() {
        BMI modified = new BMI( getBMIdetails().getHeight()-1, getBMIdetails().getWeight());
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
        SaveButton.setStyle("-fx-border-color: #FF0000; -fx-border-width: 1.5");
    }

    @FXML
    void handleSave() {
        try {
            File file = new File("src/main/resources/com/example/personal/bmi.json");
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, getBMIdetails());
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
        }
        SaveButton.setStyle("-fx-border-color: #32CD32; -fx-border-width: 1.5");
    }



}
