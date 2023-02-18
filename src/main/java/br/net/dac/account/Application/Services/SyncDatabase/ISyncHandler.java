package br.net.dac.account.Application.Services.SyncDatabase;

import br.net.dac.account.Domain.Events.SyncDataBase.SyncAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncStatusAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapAllAcountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncSwapOneAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncTransactionEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateManagerEvent;

public interface ISyncHandler {
    
    void syncCreateAccount(SyncAccountEvent event);
    void syncUpdateAccount(SyncUpdateAccountEvent event);
    void syncUpdateStatus(SyncStatusAccountEvent event);
    void syncUpdateManager(SyncUpdateManagerEvent event);
    void syncSwapAllAcount(SyncSwapAllAcountEvent event);
    void syncSwapOneAcount(SyncSwapOneAccountEvent event);
    void syncTransaction(SyncTransactionEvent event);
    
}
