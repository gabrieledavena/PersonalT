package com.example.personal;

import com.example.personal.BasicClass.BMI;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BMIcontroller {

    @FXML
    private Label BMILabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label weightLabel;

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
