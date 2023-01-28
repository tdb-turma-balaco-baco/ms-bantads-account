package br.net.dac.account.Application.Services.Transaction.Commands.Deposit;

import br.net.dac.account.Application.Services.Transaction.Commands.Common.BaseTransactionCommand;
import br.net.dac.account.Domain.Enums.Operation;

public class DepositCommand extends BaseTransactionCommand {

    public DepositCommand(double amount, Long accountId, Operation operation) {
        super(amount, accountId, operation);
    }
    
}
