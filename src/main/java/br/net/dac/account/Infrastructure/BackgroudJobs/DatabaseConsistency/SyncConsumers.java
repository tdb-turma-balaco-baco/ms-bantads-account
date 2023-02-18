package br.net.dac.account.Infrastructure.BackgroudJobs.DatabaseConsistency;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.account.Application.Services.SyncDatabase.ISyncHandler;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncStatusAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapAllAcountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapOneAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncTransactionEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateManagerEvent;

@RabbitListener(queues = {"${database-sync.queue}"})
@Component
public class SyncConsumers {
    @Autowired
    ISyncHandler _syncHandler;

    @RabbitHandler
    public void receiveSyncCreateAccount(@Payload SyncAccountEvent event){
        _syncHandler.syncCreateAccount(event);
    }

    @RabbitHandler
    public void receiveSyncUpdateAccount(@Payload SyncUpdateAccountEvent event){
        _syncHandler.syncUpdateAccount(event);
    }

    @RabbitHandler
    public void receiveSyncStatusAccount(@Payload SyncStatusAccountEvent event){
        _syncHandler.syncUpdateStatus(event);
    }

    @RabbitHandler
    public void receiveUSyncpdateManagerName(@Payload SyncUpdateManagerEvent event){
        _syncHandler.syncUpdateManager(event);
    }

    @RabbitHandler
    public void receiveSyncSwapOne(@Payload SyncSwapOneAccountEvent event){
        _syncHandler.syncSwapOneAcount(event);
    }

    @RabbitHandler
    public void receiveSyncSwapAll(@Payload SyncSwapAllAcountEvent event){
        _syncHandler.syncSwapAllAcount(event);
    }

    @RabbitHandler
    public void receiveSyncSwapAll(@Payload SyncTransactionEvent event){
        _syncHandler.syncTransaction(event);
    }
}
