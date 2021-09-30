package com.coinme.hackathon.ledger.api.rest;

import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class AccountResourceHandler {

  public Single<ServerResponse> create(ServerRequest request) {
    return Single.error(new IllegalArgumentException());
  }
}
