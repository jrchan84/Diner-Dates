package main.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.model.Profile;

import java.util.ArrayList;

public class Main extends Application{
    //JAVA FX GLOBAL FIELDS;
    private Stage stage;
    private Scene menu;
    private String searchInput;


    private static ArrayList<Profile> ProfileList;
    private static ArrayList<String> preferences = new ArrayList<String>() {{add("Sushi");
                                                                add("pizza");}};
    private static Profile user = new Profile("Prestonmlo", "Preston Lo", "prestonmlo@gmail.com", "pmoney", preferences);



    public static void main(String[] args){
        ProfileList = new ArrayList<>();
        ProfileList.add(user);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        StackPane menu = new StackPane();
        menu.setStyle("-fx-background-image: url(file:background.png); "
                      + "-fx-background-size: cover;");

        primaryStage.setScene(new Scene(menu));
        primaryStage.setResizable(true);
        primaryStage.setTitle("DinerDates");
        primaryStage.show();
    }

    private GridPane menuPane() {
        GridPane pane = new GridPane();
        pane.add(loginPane(), 0, 0, 1, 1);
        return pane;
    }

    private HBox loginPane() {
        HBox box = new HBox();
        box.setPrefHeight(250);
        box.setPrefWidth(100);
        return box;
    }

//    private String createDisplayText(String searchInput) {
//        return "Hello";
//    }

}
