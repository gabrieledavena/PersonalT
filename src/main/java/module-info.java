module com.example.personal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personal to javafx.fxml;
    exports com.example.personal;
    exports com.example.personal.BasicClass;
    opens com.example.personal.BasicClass to javafx.fxml;
}