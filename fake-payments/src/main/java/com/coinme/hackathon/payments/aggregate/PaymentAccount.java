package com.coinme.hackathon.payments.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.coinme.hackathon.payments.command.CreatePaymentAccountCommand;
import com.coinme.hackathon.payments.event.PaymentAccountCreatedEvent;
import java.time.LocalDateTime;
import java.util.List;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
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

  @CommandHandler
  public PaymentAccount (CreatePaymentAccountCommand command) {

    System.out.println("Received "+command.getClass().toString());

    PaymentAccountCreatedEvent event = new PaymentAccountCreatedEvent();
    event.setUserId(command.getUserId());
    event.setCreatedAt(LocalDateTime.now().toString());

    apply(event);
  }


  @EventSourcingHandler
  public void on(PaymentAccountCreatedEvent event) {
    this.userId = event.getUserId();
  }

}
