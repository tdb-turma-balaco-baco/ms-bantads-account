package br.net.dac.account.Infrastructure.Services.Messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.net.dac.account.Application.Abstractions.IMessageSender;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

@Component
public class MessageSender implements IMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private void sendMessage(String queueName, DomainEvent event) {
        rabbitTemplate.convertAndSend(queueName, event);
    }

    @Override
    public void sendSyncEventMessage(DomainEvent syncEvent) {
        sendMessage("database-sync.queue", syncEvent);
    }

    @Override
    public void sendEventMessage(DomainEvent event) {
        sendMessage("account-response.queue", event);
        
    }
    
}
