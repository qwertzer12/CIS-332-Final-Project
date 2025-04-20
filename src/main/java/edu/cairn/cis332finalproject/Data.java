package edu.cairn.cis332finalproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private static final String DATA_FILE = "data.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void saveData(Map<String, Object> data) throws IOException {
        OBJECT_MAPPER.writeValue(Path.of(DATA_FILE).toFile(), data);
    }

    public static Map<String, Object> loadData() {
        try {
            return OBJECT_MAPPER.readValue(Path.of(DATA_FILE).toFile(), OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}