package com.melodex.services;

public interface IConvertData {
    // Generic method to convert JSON into an object of the specified class type
    <T> T getData(String json, Class<T> clase);
}
