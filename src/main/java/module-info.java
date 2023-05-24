module com.example.personal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personal to javafx.fxml;
    exports com.example.personal;
    exports com.example.personal.BasicClass;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fazecast.jSerialComm;

    opens com.example.personal.BasicClass to javafx.fxml;


}
