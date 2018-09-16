package com.zr.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    public static <T> T  toObject(String jsonData,Class<T> tarObj) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(jsonData,tarObj);
    }

    public static <T> T  toListObject(String jsonData,Class type,Class inType) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(type, inType);
        return objectMapper.readValue(jsonData,javaType);
    }

    public static String toJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
