package com.example.personal;


import com.example.personal.BasicClass.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.time.LocalDate;

public class PersonalController {

    @FXML
    private Label BirthdayLabel;

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
    public void initialize()  {
        showPersonDetails(getPersonData());
 }
    Person getPersonData() {
        return new Person("Shrek", "3", "Palude", "Orco", 999, "Far far away", LocalDate.of(1945, 4, 4));
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            LastNameLabel.setText(person.getLastName());
            addressLabel.setText(person.getStreet());
            postalCodeLabel.setText(String.valueOf(person.getPostalCode()));
            GenderLabel.setText(String.valueOf(person.getGender()));
            cityLabel.setText(person.getCity());
            BirthdayLabel.setText(person.getBirthday().toString());
        } else {
            firstNameLabel.setText("");
            LastNameLabel.setText("");
            addressLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            BirthdayLabel.setText("");
        }
    }

    /*
    @FXML
    public void handleEditPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("person-edit-view.fxml"));
            DialogPane view = loader.load();
            PersonEditDialogController controller = loader.getController();


            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Edit Person");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CANCEL) == ButtonType.OK) {
                .getItems().set(selectedIndex, controller.getPerson());
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
    */



    /*
    @FXML
    public void openBMIview() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BMIview.fxml"));
            Stage window = (Stage) BMIbutton.getScene().getWindow();
            window.setScene(new Scene(root, 800, 500));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    @FXML
    void openBMIview() throws IOException {

        BorderPane view = FXMLLoader.load(getClass().getResource("BMIview.fxml"));
        sidePane.setCenter(view);

    }


}