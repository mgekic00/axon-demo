package com.coinme.hackathon.ledger.command;

import com.coinme.hackathon.ledger.api.model.AccountCreatedEvent;
import com.coinme.hackathon.ledger.api.model.CreateAccountCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Account {

  private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

  @AggregateIdentifier
  private String id;

  private String firstName;
  private String lastName;

  public Account() {
    // Required by Axon framework
  }

  @CommandHandler
  public Account(CreateAccountCommand command) {
    apply(
        AccountCreatedEvent
            .newBuilder()
            .setId(command.getId())
            .setFirstName(command.getFirstName())
            .setLastName(command.getLastName())
            .build()
    );
  }

  @EventSourcingHandler
  public void on(AccountCreatedEvent event) {
    id = event.getId();
    firstName = event.getFirstName();
    lastName = event.getLastName();
    LOGGER.info("Created a new account, id={}, firstName={}, lastName={}", id, firstName, lastName);
  }
}
