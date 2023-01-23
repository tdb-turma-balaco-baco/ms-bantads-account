package br.net.dac.account.Application.Services.Transaction.Commands.Handler;

import br.net.dac.account.Application.Services.Transaction.Commands.Deposit.DepositCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Transfer.TransferCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Withdraw.WithdrawCommand;

public interface ITransactionCommandHandler{

    void makeDeposit(DepositCommand deposit);
    void makeWithdraw(WithdrawCommand withdraw);
    void makeTransfer(TransferCommand transfer);
}