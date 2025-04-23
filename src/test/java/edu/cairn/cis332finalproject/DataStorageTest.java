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
        Map<String, UserData> data = new HashMap<>();
        data.put(userData.getUsername(), userData);

        // Save the data
        try {
            DataStorage.saveData(data);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        // Load the data back
        Map<String, UserData> loadedData = DataStorage.loadData();
        for (Map.Entry<String, UserData> entry : loadedData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Verify that the loaded data matches the original data
        UserData testUser = (UserData) loadedData.get(userData.getUsername());
        String test1 = testUser.getUsername();
        String test2 = userData.getUsername();

        assertEquals(test1, test2);
    }
}