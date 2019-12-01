package main.model;

import java.util.ArrayList;

public class Profile {
    private String username;
    private String name;
    private String email;
    private String password;
    private String bio;
    private ArrayList<String> preferences;

    public Profile(String username, String name, String email, String password, ArrayList<String> preferences) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferences = preferences;
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

    public ArrayList<String> getSamePreferences(Profile person) {
        ArrayList<String> preferences = new ArrayList<>();
        for (String p1 : person.preferences) {
            for (String p2 : getPreferences()) {
                if (p1.equals(p2)) {
                    preferences.add(p1);
                }
            }
        }
        return preferences;
    }

    public String getPeople() {
        StringBuilder string = new StringBuilder();
        String s = this.name;
        String s1 = this.email;
        string.append(s + "\n");
        string.append(s1 + "\n\n");
        return string.toString();
    }

    public String getUser() {
        StringBuilder string = new StringBuilder();
        String s = this.name;
        String s1 = "";
        for (int i = 0; i<this.preferences.size(); i++) {
            s1 = preferences.get(i) + "\n";
        }
        string.append(s + "\n\n");
        string.append("Your Preferences:\n");
        string.append(s1 + "\n");
        return string.toString();
    }

}
