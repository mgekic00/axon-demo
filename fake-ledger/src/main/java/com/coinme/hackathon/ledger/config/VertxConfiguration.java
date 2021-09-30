package com.coinme.hackathon.ledger.config;

import com.coinme.hackathon.ledger.api.RestApiVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.Vertx;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.downgoon.snowflake.Snowflake;

@Component
public class VertxConfiguration {

  @Bean
  public Vertx vertx() {
    return Vertx.vertx();
  }

  @Bean
  public DeploymentOptions deploymentOptions(@Value("${server.port}") Integer serverPort) {
    return new DeploymentOptions().setConfig(new JsonObject().put("port", serverPort));
  }

  @Bean
  public Snowflake snowflake(Vertx vertx) {
    return new Snowflake(1, vertx.getOrCreateContext().getInstanceCount());
  }

  @Bean
  public RestApiVerticle restApiVerticle(Snowflake snowflake, CommandGateway commandGateway) {
    return new RestApiVerticle(snowflake, commandGateway);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void deployVerticles(ApplicationReadyEvent event) {
    final ConfigurableApplicationContext context = event.getApplicationContext();
    final Vertx vertx = context.getBean(Vertx.class);
    final DeploymentOptions deploymentOptions = context.getBean(DeploymentOptions.class);
    vertx.deployVerticle(context.getBean(RestApiVerticle.class), deploymentOptions);
  }
}
