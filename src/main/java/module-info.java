module com.example.personal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personal to javafx.fxml;
    exports com.example.personal;
}