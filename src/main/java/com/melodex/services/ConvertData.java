package com.melodex.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {

    // Creating an ObjectMapper instance to handle JSON conversion
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> clase) {
        try {
            // Trying to convert the JSON string into an object of the specified class
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // Show error if the parsing fails
            throw new RuntimeException();
        }
    }

}
