package com.coinme.hackathon.payments.command;

public class CreatePaymentAccountCommand {

  public String userId;
  public long createdAt;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }
}
