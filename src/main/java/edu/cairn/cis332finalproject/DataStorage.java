package edu.cairn.cis332finalproject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final String DATA_FILE = "data.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void saveData(Map<String, UserData> data) throws IOException {
        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE), data);
    }

    public static Map<String, UserData> loadData() {
        try{
            return OBJECT_MAPPER.readValue(new File(DATA_FILE), OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, UserData.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static void saveUser(UserData user) {
        Map<String, UserData> data = loadData();
        if(data.containsKey(user.getUsername())) {
            data.remove(user.getUsername());
            data.put(user.getUsername(), user);
        }
        else {
            data.put(user.getUsername(), user);
        }
        try {
            saveData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserData loadUser(String username) {
        Map<String, UserData> data = loadData();
        return data.getOrDefault(username, null);
    }

    public static void deleteUser(String username) {
        Map<String, UserData> data = loadData();
        if(data.containsKey(username)) {
            data.remove(username);
            try {
                saveData(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}