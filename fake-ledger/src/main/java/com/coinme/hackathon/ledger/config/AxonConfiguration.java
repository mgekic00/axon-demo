package com.coinme.hackathon.ledger.config;

import com.coinme.hackathon.ledger.support.Serializers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {

  @Bean
  public Serializer messageSerializer(ObjectMapper objectMapper) {
    return JacksonSerializer.builder().objectMapper(objectMapper).build();
  }

  @Bean
  public ObjectMapper objectMapper() {
    return Serializers.objectMapper();
  }
}
