package com.coinme.hackathon.payments.event;

public class PaymentSubmittedEvent {

  public String userId;
  public String paymentId;
  public String paymentMethodId;
  private String amount;
  public long submittedAt;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public long getSubmittedAt() {
    return submittedAt;
  }

  public void setSubmittedAt(long submittedAt) {
    this.submittedAt = submittedAt;
  }

  public String getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }
}
