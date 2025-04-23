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
        ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        try{
            Map<String, UserData> data = OBJECT_MAPPER.readValue(new File(DATA_FILE), OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, UserData.class));
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }


    }
}