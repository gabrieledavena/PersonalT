package com.example.personal;

import com.example.personal.BasicClass.BMI;
import com.example.personal.BasicClass.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    BMI bmi=new BMI(185, 70);


    public void initialize () {

        try {
             File file = new File("/Users/gabrieledavena/IdeaProjects/PersonalT/src/main/resources/com/example/personal/bmi.json");
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
            }else if (bmi.getBMIvalue()>=35) {
                statusLabel.setText("Obesità di || classe");
            }else if (bmi.getBMIvalue()>30) {
                statusLabel.setText("Obesità di | classe");
            } else if (bmi.getBMIvalue()>=25 ) {
                statusLabel.setText("Sovrappeso");
            } else if (bmi.getBMIvalue()>=18.5) {
                statusLabel.setText("Normopeso");
            } else if (bmi.getBMIvalue()>17) {
                statusLabel.setText("Sottopeso");
            } else if (bmi.getBMIvalue()>16) {
                statusLabel.setText("Visibilmente Sottopeso");
            } else if (bmi.getBMIvalue()<15.9) {
                statusLabel.setText("Gravemente Sottopeso");
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
    }

    @FXML
    void weightminus() {
        BMI modified = new BMI( getBMIdetails().getHeight(), getBMIdetails().getWeight()-1);
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
    }

    @FXML
    void heightplus() {
        BMI modified = new BMI( getBMIdetails().getHeight()+1, getBMIdetails().getWeight());
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
    }

    @FXML
    void heightminus() {
        BMI modified = new BMI( getBMIdetails().getHeight()-1, getBMIdetails().getWeight());
        setBMIDATA(modified);
        showBMIdetails(getBMIdetails());
    }

    @FXML
    void handleSave() {
        try {
            File file = new File("/Users/gabrieledavena/IdeaProjects/PersonalT/src/main/resources/com/example/personal/bmi.json");
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, getBMIdetails());
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data").showAndWait();
        }
    }



}
