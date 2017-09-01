package ru.osipov.calculator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Main extends Application {




    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        stage.setOnCloseRequest(x -> Platform.exit());
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("resourses/main.fxml"))));

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }}

