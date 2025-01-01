package com.example.myjavaapplication;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeDeserializer implements JsonDeserializer<OffsetDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public OffsetDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String dateString = json.getAsString();
        return OffsetDateTime.parse(dateString, formatter);
    }
}

