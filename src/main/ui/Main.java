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
import main.model.Place;
import main.model.PlacesService;
import main.model.Profile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
    //JAVA FX GLOBAL FIELDS;
    private Stage stage;
    private Scene mainMenu;
    private Scene mainPage;
    private TextField loginUsername;
    private TextField loginPassword;
    private static ArrayList<Profile> ProfileList;

    private static ArrayList<String> preferences1 = new ArrayList<>(Arrays.asList("sushi", "pizza", "italian", "korean"));
    private static ArrayList<String> preferences2 = new ArrayList<>(Arrays.asList("sushi", "ramen", "udon", "korean"));
    private static ArrayList<String> preferences3 = new ArrayList<>(Arrays.asList("sushi", "steak", "italian"));
    private static ArrayList<String> preferences4 = new ArrayList<>(Arrays.asList("spaghetti", "steak", "hotpot"));
    private static Profile user1 = new Profile("prestonmlo", "Preston Lo", "prestonmlo@gmail.com", "pmoney", preferences1);
    private static Profile user2 = new Profile("rikkyma", "Ricky Ma", "mr.rickyma@gmail.com", "yerba", preferences2);
    private static Profile user3 = new Profile("justin", "Justin", "justin@gmail.com", "password", preferences3);
    private static Profile user4 = new Profile("true_man", "Truman Zhen", "truman@gmail.com", "1234", preferences4);
    private static Profile user5 = new Profile("Matt1", "Matt Lo", "Mattlo@gmail.com", "pmoney", preferences1);
    private static Profile user6 = new Profile("Pat1", "Pat Chan", "Patchan@gmail.com", "pmoney", preferences2);
    private static Profile user7 = new Profile("danny1", "Danny Lo", "dannylo@gmail.com", "pmoney", preferences3);


    public static void main(String[] args){
        ProfileList = new ArrayList<>();
        ProfileList.add(user1);
        ProfileList.add(user2);
        ProfileList.add(user3);
        ProfileList.add(user4);
        ProfileList.add(user5);
        ProfileList.add(user6);
        ProfileList.add(user7);
        launch(args);
        menu(ProfileList);

        // Uncomment for testing:
//        System.out.println("Same Interests:");
//        ArrayList<String> sameInterests = user1.getSamePreferences(user2);
//        for (String s : sameInterests) {
//            System.out.println(s);
//        }
//        System.out.println("Places Nearby:");
//        ArrayList<String> placeNames = new ArrayList<>();
//        for (String preference : sameInterests) {
//            ArrayList<Place> places = PlacesService.search(preference, 49.266427, -123.248539, 500);
//            for (Place p : places) {
//                if (!placeNames.contains(p.name)) {
//                    placeNames.add(p.name);
//                }
//            }
//        }
//        for (String p : placeNames) {
//            System.out.println(p);
//        }

    }


    public static void menu(ArrayList<Profile> profileList) {

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
        if (checkLogin(loginUsername.getText(), loginPassword.getText())) {
            stage.setScene(mainPage);
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private boolean checkLogin(String username, String password) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("credentials.txt"));
            return (lines.get(0).equals(username) && lines.get(1).equals(password));
        } catch (IOException e) {
            return false;
        }

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

        PlacesService PS = new PlacesService();
        String s = "sushi";
        ArrayList<Place> restaurants;
        restaurants = PlacesService.search(s, 49.2827,-123.1207,3000);
        ArrayList<String> foodArray = new ArrayList<>();
        for (Place p: restaurants) {
            foodArray.add(p.name);
        }

        StringBuilder string = new StringBuilder();
        for (int i = 0; i< foodArray.size(); i++) {
            String s1 = foodArray.get(i) + "\n";
            string.append(s1);
        }

        TextArea food = new TextArea(string.toString());
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
        return user1.getUser();
    }

    private String getPeople() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < ProfileList.size(); i++) {
            if (user1 != ProfileList.get(i) && user1.containsPreferences(ProfileList.get(i))) {
                String s1 = ProfileList.get(i).getPeople() + "\n";
                s.append(s1).toString();
            }
        }

        return s.toString();
    }

}


