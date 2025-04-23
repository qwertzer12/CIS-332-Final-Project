package edu.cairn.cis332finalproject;

public class UserData {
    private String username;
    private int userID;

    public UserData() { // Blank constructor, required for Jackson
    }

    public UserData(String username, int userID) {
        this.username = username;
        this.userID = userID;
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
}