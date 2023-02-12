package br.net.dac.account.Application.Services.Client.Commands.Handler;

import br.net.dac.account.Application.Services.Client.Commands.CreateAccount.CreateAccountCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateClient.UpdateClientCommand;
import br.net.dac.account.Application.Services.Client.Commands.UpdateStatusAccount.UpdateStatusAccountCommand;

public interface IClientCommandHandler {
    void createAccountClient(CreateAccountCommand command);
    void updateClient(UpdateClientCommand command);
    void updateStatusAccount(UpdateStatusAccountCommand command);
}
