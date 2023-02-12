package br.net.dac.account.Application.Services.Client.Commands.Handler;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Client.Commands.CreateAccount.CreateAccountCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateClient.UpdateClientCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateStatusAccount.UpdateStatusAccountCommand;
import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Entities.Write.Client;
import br.net.dac.account.Domain.Entities.Write.Manager;
import br.net.dac.account.Domain.Enums.Status;
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

    @Override
    public void createAccountClient(CreateAccountCommand command) {
        
        Client client = new Client(command.getClientName(),
                        command.getClientCpf(),
                        command.getClientEmail());
        
        Manager manager = _managerRepository.findByCpf(command.getManagerCpf());
        if(manager == null){
            manager = new Manager(command.getManagerName(), command.getManagerCpf());
        }

        Account account = new Account();
        account.setClient(client);
        account.setManager(manager);
        account.setStatus(Status.PENDING);
        account.setWage(command.getWage());
        account.setBalance(0.0);
        account.setCreationDate(new Date());
        account.setUpdatedDate(new Date());

        _accountRepository.saveAndFlush(account);

        //AccountCreatedEvent

        //Error -> ErrorCreatingAccount
    }

    @Override
    public void updateClient(UpdateClientCommand command) {

        Account account = _accountRepository.findAccountByClientCpf(command.getCpf());
        if(account == null) throw new AccountNotFoundException();

        account.setWage(command.getWage());
        account.setUpdatedDate(new Date());
        account.getClient().setEmail(command.getEmail());
        account.getClient().setName(command.getName());

        _accountRepository.saveAndFlush(account);

        //Só se der erro
    }

    @Override
    public void updateStatusAccount(UpdateStatusAccountCommand command) {
        Optional<Account> result = _accountRepository.findById(command.getAccountNumber());
        if(!result.isPresent()) throw new AccountNotFoundException();

        Account account = result.get();

        account.setStatus(command.getStatus());
        account.setStatusReason(command.getStatusReason());
        account.setUpdatedDate(new Date());

        _accountRepository.saveAndFlush(account);

        //AccountStatusChanged

        //Faz nada erro
    }
    
}
