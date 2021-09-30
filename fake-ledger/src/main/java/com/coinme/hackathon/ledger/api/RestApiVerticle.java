package com.coinme.hackathon.ledger.api;

import com.coinme.hackathon.ledger.command.CreateAccountCommand;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.RoutingContext;
import io.vertx.rxjava.ext.web.handler.BodyHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Completable;
import rx.Single;
import xyz.downgoon.snowflake.Snowflake;

import java.util.Objects;

public class RestApiVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestApiVerticle.class);

  private final Snowflake snowflake;
  private final CommandGateway commandGateway;

  public RestApiVerticle(Snowflake snowflake, CommandGateway commandGateway) {
    this.snowflake = Objects.requireNonNull(snowflake);
    this.commandGateway = Objects.requireNonNull(commandGateway);
  }

  @Override
  public Completable rxStart() {
    final Integer port = config().getInteger("port");
    return vertx
        .createHttpServer()
        .requestHandler(router())
        .rxListen(port)
        .doOnError(error -> LOGGER.error("Failed to start {}", RestApiVerticle.class.getSimpleName(), error))
        .toCompletable();
  }

  private Router router() {
    final Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/accounts").consumes("application/json").handler(this::createAccount);
    return router;
  }

  private void createAccount(RoutingContext context) {
    final JsonObject requestBody = context.getBodyAsJson();
    final CreateAccountCommand command = CreateAccountCommand
        .newBuilder()
        .setId(String.valueOf(snowflake.nextId()))
        .setFirstName(requestBody.getString("firstName"))
        .setLastName(requestBody.getString("lastName"))
        .build();
    Single.from(commandGateway.send(command))
        .doOnSubscribe(() -> LOGGER.info("Sending {} to command gateway", command.getClass().getSimpleName()))
        .subscribe(
            response -> context.response().setStatusCode(response != null ? 201 : 400).end(),
            context::fail
        );
  }
}
