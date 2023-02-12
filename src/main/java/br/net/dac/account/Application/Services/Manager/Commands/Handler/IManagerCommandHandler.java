package br.net.dac.account.Application.Services.Manager.Commands.Handler;

import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapAllAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.SwapManagerAccount.SwapOneAccountManagerCommand;
import br.net.dac.account.Application.Services.Manager.Commands.UpdateManager.UpdateManagerCommand;

public interface IManagerCommandHandler {
    void updateManager(UpdateManagerCommand command);
    void swapAllAccountManager(SwapAllAccountManagerCommand command);
    void swapOneAccountManager(SwapOneAccountManagerCommand command);
}
