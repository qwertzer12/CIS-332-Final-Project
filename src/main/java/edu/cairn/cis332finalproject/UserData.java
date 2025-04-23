package edu.cairn.cis332finalproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserData {
    private String username;
    private int userID;
    private final List<Date> logins = new ArrayList<>();

    public UserData() { // Blank constructor, required for Jackson
    }

    public UserData(String username, int userID) {
        this.username = username;
        this.userID = userID;
        logins.add(new Date());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void updateLoginTime() {
        logins.add(new Date());
        if (logins.size() > 10) {
            logins.removeFirst(); // Remove the oldest login time if there are more than 10
        }
        System.out.println("Login times updated: " + logins);
    }
    public List<Date> getLogins() {
        return logins;
    }
}