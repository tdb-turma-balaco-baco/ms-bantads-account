package br.net.dac.account.Presentation.Contracts.Transaction;

public class TransferRequest extends BaseTransactionRequest{
    private Long destinationAccountId;

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    
}
