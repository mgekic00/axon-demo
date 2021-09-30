package com.coinme.hackathon.payments.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.coinme.hackathon.payments.command.CreatePaymentMethodCommand;
import com.coinme.hackathon.payments.event.PaymentMethodCreatedEvent;
import com.coinme.hackathon.payments.pojo.Card;
import java.util.List;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentMethod {

  @AggregateIdentifier
  private String paymentMethodId;

  private String userId;
  private Card card;
  private List<Payment> payments;

  public PaymentMethod() {}

  @CommandHandler
  public void on(CreatePaymentMethodCommand command) {

    System.out.println("Received "+command.getClass().toString());

    PaymentMethodCreatedEvent event = new PaymentMethodCreatedEvent();
    event.setPaymentMethodId(command.getPaymentMethodId());
    event.setUserId(command.getUserId());
    event.setCard(command.getCard());
    event.setCreatedAt(command.getCreatedAt());

    apply(event);
  }

  @EventSourcingHandler
  public void on(PaymentMethodCreatedEvent event) {

    this.paymentMethodId = event.getPaymentMethodId();
    this.userId = event.getUserId();
    this.card = event.getCard();
  }


}
