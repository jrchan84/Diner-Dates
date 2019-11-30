package main.ui;

import main.model.Place;
import main.model.PlacesService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Place> places = PlacesService.search("pizza", 49.266427, -123.248539, 500);
        for (Place p : places) {
            System.out.println(p.name);
        }
    }

}
