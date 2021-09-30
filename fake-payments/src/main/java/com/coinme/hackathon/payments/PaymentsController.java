package com.coinme.hackathon.payments;

import com.coinme.hackathon.payments.command.CreatePaymentAccountCommand;
import com.coinme.hackathon.payments.command.CreatePaymentMethodCommand;
import com.coinme.hackathon.payments.command.SubmitPaymentCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

  private final CommandGateway commandGateway;

  public PaymentsController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping("/create-account")
  CreatePaymentAccountCommand PaymentMethod (@RequestBody CreatePaymentAccountCommand createPaymentAccountCommand) {

    commandGateway.send(createPaymentAccountCommand);

    return createPaymentAccountCommand;
  }

  @PostMapping("/payment-method")
  CreatePaymentMethodCommand PaymentMethod (@RequestBody CreatePaymentMethodCommand createPaymentMethodCommand) {

    commandGateway.send(createPaymentMethodCommand);

    return createPaymentMethodCommand;
  }

  @PostMapping("/submit-payment")
  SubmitPaymentCommand PaymentMethod (@RequestBody SubmitPaymentCommand submitPaymentCommand) {

    commandGateway.send(submitPaymentCommand);

    return submitPaymentCommand;
  }



}
