package com.codecool.klondike;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Klondike extends Application {

    private static final double WINDOW_WIDTH = 1400;
    private static final double WINDOW_HEIGHT = 900;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Card.loadCardImages();
        Game game = new Game();
        game.setTableBackground(new Image("/table/greenBack.png"));

        Button greenBack = new Button("Green BG");
        game.getChildren().add(greenBack);
        greenBack.setLayoutX(25);
        greenBack.setLayoutY(850);
        greenBack.setOnMouseClicked(event -> game.setTableBackground(new Image("/table/greenBack.png")));

        Button lightBack = new Button("Light BG");
        game.getChildren().add(lightBack);
        lightBack.setLayoutX(125);
        lightBack.setLayoutY(850);
        lightBack.setOnMouseClicked(event -> game.setTableBackground(new Image("/table/lightBack.png")));

        Button darkBack = new Button("Dark BG");
        game.getChildren().add(darkBack);
        darkBack.setLayoutX(225);
        darkBack.setLayoutY(850);
        darkBack.setOnMouseClicked(event -> game.setTableBackground(new Image("/table/darkBack.png")));

        primaryStage.setTitle("Klondike Solitaire");
        primaryStage.setScene(new Scene(game, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
    }

}
