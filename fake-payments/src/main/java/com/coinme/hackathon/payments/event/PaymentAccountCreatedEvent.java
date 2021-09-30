package com.coinme.hackathon.payments.event;

public class PaymentAccountCreatedEvent {

  public String userId;
  public String createdAt;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}
