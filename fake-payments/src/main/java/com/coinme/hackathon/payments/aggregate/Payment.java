package com.coinme.hackathon.payments.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.coinme.hackathon.payments.command.SubmitPaymentCommand;
import com.coinme.hackathon.payments.event.PaymentSubmittedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Payment {

  @AggregateIdentifier
  private String paymentId;
  private String paymentMethodId;
  private String userId;
  private String amount;
  private long submittedAt;

  public Payment () {}

  @CommandHandler
  public void on(SubmitPaymentCommand command) {

    PaymentSubmittedEvent event = new PaymentSubmittedEvent();
    event.setPaymentId(command.getPaymentId());
    event.setUserId(command.getUserId());
    event.setAmount(command.getAmount());
    event.setSubmittedAt(command.getSubmittedAt());

    apply(event);
  }

  @EventSourcingHandler
  public void on(PaymentSubmittedEvent event) {

    this.paymentId = event.getPaymentId();
    this.paymentMethodId = event.getPaymentMethodId();
    this.userId = event.getUserId();
    this.amount = event.getAmount();
    this.submittedAt = event.getSubmittedAt();


  }


}


