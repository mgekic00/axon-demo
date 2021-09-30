package com.coinme.hackathon.payments.aggregate;

import java.util.List;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAccount {

  @AggregateIdentifier
  private String userId;
  @AggregateMember
  private List<PaymentMethod> paymentMethods;

  public PaymentAccount() {}
}
