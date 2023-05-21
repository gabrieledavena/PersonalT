package com.example.personal;

import com.example.personal.BasicClass.BMI;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

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

}
