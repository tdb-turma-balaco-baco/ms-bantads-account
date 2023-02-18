package br.net.dac.account.Application.Abstractions;

import br.net.dac.account.Domain.Events.Common.DomainEvent;

public interface IMessageSender {
    
    void sendSyncEventMessage(DomainEvent syncEvent);
    void sendEventMessage(DomainEvent event);
}
