package br.net.dac.account.Infrastructure.Services.Messaging;

import br.net.dac.account.Application.Abstractions.IMessageSender;
import br.net.dac.account.Domain.Events.Common.DomainEvent;

public class MessageSender implements IMessageSender {

    @Override
    public void sendMessage(String queueName, DomainEvent event) {
        // TODO Auto-generated method stub
        
    }
    
}
