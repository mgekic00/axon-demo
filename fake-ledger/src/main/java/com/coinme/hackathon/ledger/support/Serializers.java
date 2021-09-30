package com.coinme.hackathon.ledger.support;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.avro.AvroModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public interface Serializers {

  static ObjectMapper objectMapper() {
    return new ObjectMapper()
        .registerModules(new AvroModule(), new Jdk8Module(), new JavaTimeModule())
        .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
        .setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE)
        .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS, SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }
}
