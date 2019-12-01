package main.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Scene mainMenu;
    private Scene mainPage;
    private TextField loginUsername;
    private TextField loginPassword;


    private static ArrayList<Profile> ProfileList;
    private static ArrayList<String> preferences = new ArrayList<String>() {{add("Sushi");
                                                                add("pizza");}};
    private static Profile user = new Profile("Prestonmlo", "Preston Lo", "prestonmlo@gmail.com", "pmoney", preferences);
    private static Profile user1 = new Profile("Matt1", "Matt Lo", "Mattlo@gmail.com", "pmoney", preferences);
    private static Profile user2 = new Profile("Pat1", "Pat Chan", "Patchan@gmail.com", "pmoney", preferences);
    private static Profile user3 = new Profile("danny1", "Danny Lo", "dannylo@gmail.com", "pmoney", preferences);



    public static void main(String[] args){
        ProfileList = new ArrayList<>();
        ProfileList.add(user);
        ProfileList.add(user1);
        ProfileList.add(user2);
        ProfileList.add(user3);

        launch(args);
        menu(ProfileList);
    }

    public static void menu(ArrayList<Profile> ProfileList) {

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
        menu.getChildren().addAll(menuPane());

        mainMenu = new Scene(menu);

        primaryStage.setScene(mainMenu);
        primaryStage.setResizable(true);
        primaryStage.setTitle("DinerDates");
        primaryStage.show();
    }

    private GridPane menuPane() {
        GridPane pane = new GridPane();
        pane.add(loginPane(), 0, 1, 1, 1);
        pane.setPadding(new Insets(500,300,100,165));
        return pane;
    }


    private HBox loginPane() {
        loginUsername = new TextField();
        loginUsername.setPrefHeight(40);
        loginUsername.setPrefWidth(200);
        loginUsername.setPadding(new Insets(0,50,0,0));
        loginUsername.setPromptText("username");

        loginPassword = new TextField();
        loginPassword.setPrefHeight(40);
        loginPassword.setPrefWidth(200);
        loginPassword.setPadding(new Insets(0,0,0,0));
        loginPassword.setPromptText("password");

        Button loginButton = new Button("login");
        loginButton.setPrefSize(100,40);
        loginButton.setOnAction(e -> loginClick());

        HBox box = new HBox();
        box.setPrefHeight(100);
        box.setPrefWidth(600);
        box.getChildren().addAll(loginUsername, loginPassword, loginButton);
        box.setSpacing(50);

        return box;
    }

    private void loginClick() {
        Screen screen2 = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds2 = screen2.getVisualBounds();
        stage.setX(bounds2.getMinX());
        stage.setY(bounds2.getMinY());
        stage.setWidth(bounds2.getWidth());
        stage.setHeight(bounds2.getHeight());

        StackPane menu2 = new StackPane();
        menu2.setStyle("-fx-background-image: url(file:background2.png); "
                + "-fx-background-size: cover;");
        menu2.getChildren().addAll(profilePane());

        mainPage = new Scene(menu2);
        stage.setScene(mainPage);
    }

    private GridPane profilePane(){
        GridPane pane = new GridPane();
        pane.add(profile(), 0, 0, 1, 1);
        pane.add(people(), 1, 0, 1,1);
        pane.add(food(),2,0,2,1);
        return pane;
    }

    private HBox profile(){
        TextArea profile = new TextArea(getProfile());
        profile.setPrefSize(400, 400);

        HBox pane = new HBox(profile);
        pane.setPadding(new Insets(400, 30, 5, 50));
        pane.setSpacing(30);
        return pane;
    }

    private HBox food(){
        TextArea food = new TextArea("map");
        food.setPrefSize(400, 400);


        HBox pane = new HBox(food);
        pane.setPadding(new Insets(400, 20, 5, 55));
        pane.setSpacing(30);
        return pane;
    }

    private HBox people(){
        TextArea profile = new TextArea(getPeople());
        profile.setPrefSize(400, 400);

        HBox pane = new HBox(profile);
        pane.setPadding(new Insets(400, 30, 5, 40));
        pane.setSpacing(30);
        return pane;
    }

    private String getProfile() {
        return user.getUser();
    }

    private String getPeople() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < ProfileList.size(); i++) {
            if (user != ProfileList.get(i)) {
                String s1 = ProfileList.get(i).getPeople() + "\n";
                s.append(s1).toString();
            }
        }

        return s.toString();
    }


}
