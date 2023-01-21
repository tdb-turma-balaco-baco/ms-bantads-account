package br.net.dac.account.Application.Services.Transactions.Commands.Common;

import br.net.dac.account.Application.Services.Transactions.Commands.Deposit.DepositCommand;
import br.net.dac.account.Application.Services.Transactions.Commands.Transfer.TransferCommand;
import br.net.dac.account.Application.Services.Transactions.Commands.Withdraw.WithdrawCommand;

public interface ITransactionHandler{

    void makeDeposit(DepositCommand deposit);
    void makeWithdraw(WithdrawCommand withdraw);
    void makeTransfer(TransferCommand transfer);
}