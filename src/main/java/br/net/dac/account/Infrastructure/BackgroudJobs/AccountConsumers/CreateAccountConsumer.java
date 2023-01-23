package br.net.dac.account.Infrastructure.BackgroudJobs.AccountConsumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.account.Application.Services.Client.Events.CreateAccountEvent;

@Component
public class CreateAccountConsumer {
    
    @RabbitListener(queues = {"COMMAND_ACCOUNT_QUEUE"})
    public void receive(@Payload CreateAccountEvent createAccount){
        //System.out.println("Message updateAccount: " + id);
    }
}
