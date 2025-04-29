package edu.cairn.cis332finalproject;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

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

    @Test
    void testData2() {
        Map<String, UserData> data = new HashMap<>();
        data.put("testUser1", new UserData("testUser1", 12345));
        data.put("testUser2", new UserData("testUser2", 67890));
        data.put("testUser3", new UserData("testUser3", 54321));
        data.put("testUser4", new UserData("testUser4", 98765));
        data.put("testUser5", new UserData("testUser5", 13579));

        // Save the data
        try {
            DataStorage.saveData(data);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        data.put("testUser6", new UserData("testUser6", 12345));

        // Save the data again


        // Save nothing
        try {
            DataStorage.saveData(new HashMap<>());
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        // Load the data back
        Map<String, UserData> loadedData = DataStorage.loadData();
        for (Map.Entry<String, UserData> entry : loadedData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Loaded data: " + loadedData);

    }

    @Test
    void loadBlank() {
        assertNull(DataStorage.loadUser("DoesNotExist"));
    }

    @Test
    void TimeTracking() {
        UserData userData = new UserData("testUser", 12345);
        userData.updateLoginTime();
        assertNotNull(userData.getLogins());
        assertEquals(2, userData.getLogins().size());

        // Simulate multiple logins
        for (int i = 0; i < 10; i++) {
            userData.updateLoginTime();
        }
        assertEquals(10, userData.getLogins().size());

        // Simulate one more login to check if the oldest login is removed
        userData.updateLoginTime();
        assertEquals(10, userData.getLogins().size());
        System.out.println("Logins after update: " + userData.getLogins());

        DataStorage.saveUser(userData);
        UserData testUser = (UserData) DataStorage.loadUser("testUser");
        assertEquals(userData.getLogins(), testUser.getLogins());
        Queue<Date> testLogins = testUser.getLogins();
        Queue<Date> testLogins2 = userData.getLogins();
        assertEquals(testLogins, testLogins2);

    }

    @Test
    void HangmanData(){
        UserData userData = new UserData("testUser", 12345);
        int[] info = {1, 2};
        DataStorage.saveHangmanData(userData.getUsername(), info);
        int[] testInfo = DataStorage.loadHangmanData(userData.getUsername());
        System.out.println("testInfo: " + testInfo[0] + ", " + testInfo[1]);
    }
}