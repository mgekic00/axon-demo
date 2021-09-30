package com.coinme.hackathon.ledger.config;

import com.coinme.hackathon.ledger.api.rest.AccountResourceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.adapter.rxjava.RxJava3Adapter;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RestConfiguration {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(AccountResourceHandler accountResourceHandler) {
    return RouterFunctions
        .route(
            POST("/accounts").and(accept(MediaType.APPLICATION_JSON)),
            request -> RxJava3Adapter.singleToMono(accountResourceHandler.create(request))
        );
  }
}
