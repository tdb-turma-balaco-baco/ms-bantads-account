package br.net.dac.account.Application.Services.Transactions.Commands.Transfer;

import br.net.dac.account.Application.Services.Transactions.Commands.Common.BaseTransactionCommand;

public class TransferCommand extends BaseTransactionCommand {
    
    private int destinationAccountId;

    public int getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(int destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

}
