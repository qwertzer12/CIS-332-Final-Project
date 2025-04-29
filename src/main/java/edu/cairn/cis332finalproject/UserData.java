package edu.cairn.cis332finalproject;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Stores user information and login history for the application.
 * Maintains a queue of the last 10 login timestamps.
 *
 * @author AJ Chabin
 */
public class UserData {
    private final Queue<Date> logins = new LinkedList<>();
    private String username;
    private int userID;
    private int consecutiveWins = 0;
    private int totalWins = 0;

    /**
     * Default constructor for Jackson deserialization.
     *
     * @author AJ Chabin
     */
    public UserData() { // Blank constructor, required for Jackson
    }

    /**
     * Creates a new user with the specified username and ID.
     * Records the current date/time as the first login.
     *
     * @param username the user's name
     * @param userID the unique identifier for the user
     * @author AJ Chabin
     */
    public UserData(String username, int userID) {
        this.username = username;
        this.userID = userID;
        logins.add(new Date());
    }

    /**
     * Gets the username of this user.
     *
     * @return the username
     * @author AJ Chabin
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of this user.
     *
     * @param username the new username
     * @author AJ Chabin
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the unique ID for this user.
     *
     * @return the user ID
     * @author AJ Chabin
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the unique ID for this user.
     *
     * @param userID the new user ID
     * @author AJ Chabin
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Records a new login event with the current timestamp.
     * Removes the oldest login if there are more than 10 entries.
     *
     * @author AJ Chabin
     */
    public void updateLoginTime() {
        logins.add(new Date());
        if (logins.size() > 10) {
            logins.remove(); // Remove the oldest login time if there are more than 10
        }
        System.out.println("Login times updated: " + logins);
    }

    /**
     * Gets the login history for this user.
     *
     * @return a queue containing the last 10 login times
     * @author AJ Chabin
     */
    public Queue<Date> getLogins() {
        return logins;
    }

    public int getConsecutiveWins() {
        return consecutiveWins;
    }

    public void setConsecutiveWins(int consecutiveWins) {
        this.consecutiveWins = consecutiveWins;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }
}
