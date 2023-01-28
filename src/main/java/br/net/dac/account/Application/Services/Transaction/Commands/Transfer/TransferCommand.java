package br.net.dac.account.Application.Services.Transaction.Commands.Transfer;

import br.net.dac.account.Application.Services.Transaction.Commands.Common.BaseTransactionCommand;
import br.net.dac.account.Domain.Enums.Operation;

public class TransferCommand extends BaseTransactionCommand {
    
    private Long destinationAccountId;

    public TransferCommand(double amount, Long accountId, Operation operation, Long destinationAccountId) {
        super(amount, accountId, operation);
        this.destinationAccountId = destinationAccountId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

}
