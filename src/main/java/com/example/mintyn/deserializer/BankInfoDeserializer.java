package com.example.mintyn.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BankInfoDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        while (jsonParser.nextToken() != null) {
            if ("name".equals(jsonParser.getCurrentName())) {
                return jsonParser.nextTextValue();
            }
        }
        return null;
    }
}

