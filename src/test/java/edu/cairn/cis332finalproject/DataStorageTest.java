package edu.cairn.cis332finalproject;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataStorageTest {

    @Test
    void saveData() {
        UserData userData = new UserData("testUser", 12345);
        // Create a sample data map
        Map<String, Object> data = new HashMap<>();
        data.put(userData.getUsername(), userData);


        // Save the data
        try {
            DataStorage.saveData(data);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        // Load the data back
        Map<String, Object> loadedData = DataStorage.loadData();
        for (Map.Entry<String, Object> entry : loadedData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Verify that the loaded data matches the original data
        assertEquals("{username=testUser, userID=12345}", loadedData.get(userData.getUsername()));
    }

    @Test
    void loadData() {
        // Load the data
    }
}