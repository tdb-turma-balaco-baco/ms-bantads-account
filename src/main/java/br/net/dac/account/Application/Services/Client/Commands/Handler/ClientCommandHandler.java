package br.net.dac.account.Application.Services.Client.Commands.Handler;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Abstractions.IMessageSender;
import br.net.dac.account.Application.Services.Client.Commands.CreateAccount.CreateAccountCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateClient.UpdateClientCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateStatusAccount.UpdateStatusAccountCommand;
import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Entities.Write.Client;
import br.net.dac.account.Domain.Entities.Write.Manager;
import br.net.dac.account.Domain.Enums.Status;
import br.net.dac.account.Domain.Events.ChangedStatusAccountEvent;
import br.net.dac.account.Domain.Events.CreatedAccountEvent;
import br.net.dac.account.Domain.Events.ErrorAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncStatusAccountEvent;
import br.net.dac.account.Domain.Events.SyncDataBase.SyncUpdateAccountEvent;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.AccountRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.ClientRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.ManagerRepository;

@Service
public class ClientCommandHandler implements IClientCommandHandler{
    
    @Autowired
    AccountRepository _accountRepository;

    @Autowired
    ManagerRepository _managerRepository;

    @Autowired
    ClientRepository _clientRepository;

    @Autowired
    IMessageSender _messageSender;

    @Override
    public void createAccountClient(CreateAccountCommand command) {
        
        try
        {
            Client client = new Client(command.getClientName(),
                            command.getClientCpf(),
                            command.getClientEmail());
            
            Manager manager = _managerRepository.findByCpf(command.getManagerCpf());
            if(manager == null){
                manager = new Manager(command.getManagerName(), command.getManagerCpf());
                _managerRepository.saveAndFlush(manager);
            }

            Account account = new Account();
            account.setClient(client);
            account.setManager(manager);
            account.setStatus(Status.PENDING);
            account.setWage(command.getWage());
            account.setBalance(0.0);
            account.setCreationDate(new Date());
            account.setUpdatedDate(new Date());

            account = _accountRepository.saveAndFlush(account);

            _messageSender.sendSyncEventMessage(new SyncAccountEvent(account));

            CreatedAccountEvent event = new CreatedAccountEvent(command.getClientEmail(),
                                            command.getClientName(),
                                            command.getClientCpf());

            _messageSender.sendEventMessage(event);
        }catch(Exception ex){
            ErrorAccountEvent event = new ErrorAccountEvent(command.getClientCpf());
            _messageSender.sendEventMessage(event);
        }
    }

    @Override
    public void updateClient(UpdateClientCommand command) {

        Account account = _accountRepository.findAccountByClientCpf(command.getCpf());
        if(account == null) throw new AccountNotFoundException();

        account.setWage(command.getWage());
        account.setUpdatedDate(new Date());
        account.getClient().setEmail(command.getEmail());
        account.getClient().setName(command.getName());

        account = _accountRepository.saveAndFlush(account);

        _messageSender.sendSyncEventMessage(new SyncUpdateAccountEvent(account));
    }

    @Override
    public void updateStatusAccount(UpdateStatusAccountCommand command) {
        Optional<Account> result = _accountRepository.findById(command.getAccountNumber());
        if(!result.isPresent()) throw new AccountNotFoundException();

        Account account = result.get();

        account.setStatus(command.getStatus());
        account.setStatusReason(command.getStatusReason());
        account.setUpdatedDate(new Date());

        account = _accountRepository.saveAndFlush(account);

        _messageSender.sendSyncEventMessage(new SyncStatusAccountEvent(account));

        ChangedStatusAccountEvent event = new ChangedStatusAccountEvent(account.getClient().getCpf(),
                                            command.getStatus(),
                                            command.getStatusReason());

        _messageSender.sendEventMessage(event);
    }
    
}
