package com.example.personal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PersonalApplication.class.getResource("Mainview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1150, 450);
        stage.setMinWidth(1150);
        stage.setMinHeight(450);
        stage.setMaxWidth(1150);
        stage.setMaxHeight(450);
        stage.getIcons().add(new Image("com/example/personal/images/fotoapp.jpeg"));
        stage.setTitle("Personal Trainer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}