package br.net.dac.account.Application.Abstractions;

import br.net.dac.account.Domain.Events.Common.DomainEvent;

public interface IMessageSender {
    
    void sendMessage(String queueName, DomainEvent event);
}
