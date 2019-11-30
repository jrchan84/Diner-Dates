package main.model;

import java.util.ArrayList;

public class Profile {
    private String username;
    private String name;
    private String email;
    private String password;
    private String bio;
    private ArrayList<String> preferences;

    public Profile(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferences = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getBio() {
        return this.bio;
    }

    public ArrayList<String> getPreferences() {
        return this.preferences;
    }



}
