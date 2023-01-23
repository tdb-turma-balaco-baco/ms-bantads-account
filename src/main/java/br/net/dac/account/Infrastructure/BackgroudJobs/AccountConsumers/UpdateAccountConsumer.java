package br.net.dac.account.Infrastructure.BackgroudJobs.AccountConsumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountConsumer {

    @RabbitListener(queues = {"COMMAND_ACCOUNT_QUEUE"})
    public void receive(@Payload int id){
        System.out.println("Message updateAccount: " + id);
    }
    
}
