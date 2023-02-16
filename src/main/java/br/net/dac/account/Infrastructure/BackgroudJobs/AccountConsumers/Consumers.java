package br.net.dac.account.Infrastructure.BackgroudJobs.AccountConsumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.net.dac.account.Application.Services.Client.Commands.CreateAccount.CreateAccountCommand;
import br.net.dac.account.Application.Services.Client.Commands.Handler.IClientCommandHandler;
import br.net.dac.account.Application.Services.Client.Commands.UpdateClient.UpdateClientCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateStatusAccount.UpdateStatusAccountCommand;
import br.net.dac.account.Application.Services.Client.Events.CreateAccountEvent;
import br.net.dac.account.Application.Services.Client.Events.UpdateAccountEvent;
import br.net.dac.account.Application.Services.Client.Events.UpdateStatusAccountEvent;
import br.net.dac.account.Application.Services.Manager.Commands.Events.SwapManagerEvent;
import br.net.dac.account.Application.Services.Manager.Commands.Events.UpdateManagerEvent;
import br.net.dac.account.Application.Services.Manager.Commands.Handler.IManagerCommandHandler;
import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.BaseSwapAccountManager;
import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapAllAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapOneAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.UpdateManager.UpdateManagerCommand;
import br.net.dac.account.Domain.Enums.Status;

@Component
@RabbitListener(queues = {"${account.queue}"})
public class Consumers {
    
    @Autowired
    IManagerCommandHandler _managerHandler;

    @Autowired
    IClientCommandHandler _clientHandler;

    @RabbitHandler
    public void receiveCreateAccount(@Payload CreateAccountEvent event){
        CreateAccountCommand command = new CreateAccountCommand(event.getClientName(),
                                        event.getClientCpf(),
                                        event.getClientEmail(),
                                        event.getManagerCpf(),
                                        event.getManagerName(),
                                        event.getWage());

        _clientHandler.createAccountClient(command);
    }

    @RabbitHandler
    public void receiveUpdateAccount(@Payload UpdateAccountEvent event){
        UpdateClientCommand command = new UpdateClientCommand(event.getName(), 
                                        event.getCpf(),
                                        event.getEmail(),
                                        event.getWage());

        _clientHandler.updateClient(command);
    }

    @RabbitHandler
    public void receiveUpdateStatusAccount(@Payload UpdateStatusAccountEvent event){
        Status receivedStatusAccount = event.isApproved() ? Status.APPROVED : Status.REJECTED;

        UpdateStatusAccountCommand command = new UpdateStatusAccountCommand(event.getAccountNumber(),
                                                receivedStatusAccount,
                                                event.getStatusReason());

        _clientHandler.updateStatusAccount(command);
    }

    @RabbitHandler
    public void receiveUpdateManagerName(@Payload UpdateManagerEvent event){
        UpdateManagerCommand command = new UpdateManagerCommand(event.getCpf(),
                                        event.getName());

        _managerHandler.updateManager(command);
    }

    @RabbitHandler
    public void receiveSwapManagerAccount(@Payload SwapManagerEvent event){

        BaseSwapAccountManager baseSwap = new BaseSwapAccountManager(event.getOldManagerCpf(),
                                            event.getCpf(),
                                            event.getName());

        if(event.isSwapAll())
        {
            var command = (SwapAllAccountManagerCommand)baseSwap;
             _managerHandler.swapAllAccountManager(command);
        }
        else
        {
            var command = (SwapOneAccountManagerCommand)baseSwap;
            _managerHandler.swapOneAccountManager(command);
        }

    }

}
