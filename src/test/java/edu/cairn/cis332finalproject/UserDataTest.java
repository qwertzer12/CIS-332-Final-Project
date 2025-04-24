package edu.cairn.cis332finalproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDataTest {

    @Test
    void updateLoginTime() {
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
    }
}