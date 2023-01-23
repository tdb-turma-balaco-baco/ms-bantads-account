package br.net.dac.account.Application.Services.Transaction.Commands.Withdraw;

import br.net.dac.account.Application.Services.Transaction.Commands.Common.BaseTransactionCommand;
import br.net.dac.account.Domain.Enums.Operation;

public class WithdrawCommand extends BaseTransactionCommand {

    public WithdrawCommand(double amount, Long accountId, Operation operation) {
        super(amount, accountId, operation);
    }
    
}
