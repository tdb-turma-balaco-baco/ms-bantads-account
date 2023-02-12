package br.net.dac.account.Application.Services.Manager.Commands.Handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapAllAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapOneAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.UpdateManager.UpdateManagerCommand;
import br.net.dac.account.Domain.Entities.Write.Account;
import br.net.dac.account.Domain.Entities.Write.Manager;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Domain.Exceptions.ManagerNotFoundException;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.AccountRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.ClientRepository;
import br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite.ManagerRepository;

@Service
public class ManagerCommandHandler implements IManagerCommandHandler {

    @Autowired
    AccountRepository _accountRepository;

    @Autowired
    ManagerRepository _managerRepository;

    @Autowired
    ClientRepository _clientRepository;

    @Override
    public void updateManager(UpdateManagerCommand command) {
        Manager manager = _managerRepository.findByCpf(command.getCpf());
        if(manager == null) throw new ManagerNotFoundException();

        manager.setName(command.getName());
        _managerRepository.saveAndFlush(manager);
        
        //Event Só se der erro 
        
    }

    @Override
    public void swapAllAccountManager(SwapAllAccountManagerCommand command) {
        
        List<Account> accounts = _accountRepository.findAccountByManagerCpf(command.getOldManagerCpf());
        if(accounts == null) throw new AccountNotFoundException();

        Manager manager = _managerRepository.findByCpf(command.getCpf());
        if(manager == null){
            manager = new Manager(command.getName(), command.getCpf());
            _managerRepository.saveAndFlush(manager);
        } 

        for (Account account : accounts) {
            account.setManager(manager);
        }

        _accountRepository.saveAllAndFlush(accounts);

        //Certo event

        //Erro event
    }

    @Override
    public void swapOneAccountManager(SwapOneAccountManagerCommand command) {
        Account account = _accountRepository.findAccountByManagerCpf(command.getOldManagerCpf()).get(0);
        if(account == null) throw new AccountNotFoundException();

        Manager manager = _managerRepository.findByCpf(command.getCpf());
        if(manager == null){
            manager = new Manager(command.getName(), command.getCpf());
        } 

        account.setManager(manager);

        _accountRepository.saveAndFlush(account);
        
        //Certo ok

        //Erro event
    }
    
}
