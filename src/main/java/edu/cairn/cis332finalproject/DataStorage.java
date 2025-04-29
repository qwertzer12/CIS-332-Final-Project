package edu.cairn.cis332finalproject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides data persistence services for user information.
 * Uses Jackson for JSON serialization and deserialization.
 *
 * @author AJ Chabin
 */
public class DataStorage {
    /**
     * Private constructor to prevent instantiation of this utility class.
     * 
     * @author AJ Chabin
     */
    private DataStorage() {
        // Utility class should not be instantiated
    }

    private static final String DATA_FILE = "data.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Saves the user data map to a JSON file.
     *
     * @param data map of usernames to UserData objects to save
     * @throws IOException if an error occurs during file writing
     * @author AJ Chabin
     */
    public static void saveData(Map<String, UserData> data) throws IOException {
        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE), data);
    }

    /**
     * Loads user data from the JSON file.
     *
     * @return a map of usernames to UserData objects
     * @author AJ Chabin
     */
    public static Map<String, UserData> loadData() {
        try {
            return OBJECT_MAPPER.readValue(new File(DATA_FILE), OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, UserData.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    /**
     * Saves or updates a user in the data store.
     * If the user already exists, it will be replaced.
     *
     * @param user the UserData object to save
     * @author AJ Chabin
     */
    public static void saveUser(UserData user) {
        Map<String, UserData> data = loadData();
        if (data.containsKey(user.getUsername())) {
            data.remove(user.getUsername());
            data.put(user.getUsername(), user);
        } else {
            data.put(user.getUsername(), user);
        }
        try {
            saveData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a specific user by username.
     *
     * @param username the username to look up
     * @return the UserData object or null if not found
     * @author AJ Chabin
     */
    public static UserData loadUser(String username) {
        Map<String, UserData> data = loadData();
        return data.getOrDefault(username, null);
    }

    /**
     * Deletes a user from the data store.
     *
     * @param username the username of the user to delete
     * @author AJ Chabin
     */
    public static void deleteUser(String username) {
        Map<String, UserData> data = loadData();
        if (data.containsKey(username)) {
            data.remove(username);
            try {
                saveData(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets the total number of users in the data store.
     *
     * @return the count of users
     * @author AJ Chabin
     */
    public static int getUserCount() {
        Map<String, UserData> data = loadData();
        return data.size();
    }

    public static void saveHangmanData(String username, int[] info) {
        UserData user = loadUser(username);
        if (user == null) {
            user = new UserData(username, getUserCount() + 1);
        }
        user.setConsecutiveWins(info[0]);
        user.setTotalWins(info[1]);
        saveUser(user);
    }

    public static int[] loadHangmanData(String username) {
        UserData user = loadUser(username);
        int[] info = new int[2];
        info[0] = user.getConsecutiveWins();
        info[1] = user.getTotalWins();
        return info;
    }
}
