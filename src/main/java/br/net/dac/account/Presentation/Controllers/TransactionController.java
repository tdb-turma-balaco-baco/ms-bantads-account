package br.net.dac.account.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.dac.account.Application.Services.Transaction.Commands.Deposit.DepositCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Handler.ITransactionCommandHandler;
import br.net.dac.account.Application.Services.Transaction.Commands.Transfer.TransferCommand;
import br.net.dac.account.Application.Services.Transaction.Commands.Withdraw.WithdrawCommand;
import br.net.dac.account.Domain.Enums.Operation;
import br.net.dac.account.Domain.Exceptions.AccountNotFoundException;
import br.net.dac.account.Domain.Exceptions.InsufficientFundsException;
import br.net.dac.account.Presentation.Contracts.Transaction.DepositRequest;
import br.net.dac.account.Presentation.Contracts.Transaction.TransferRequest;
import br.net.dac.account.Presentation.Contracts.Transaction.WithdrawRequest;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    ITransactionCommandHandler _transactionCommandHandler;

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositRequest depositRequest) {

        try
        {
            DepositCommand depositCommand = new DepositCommand(
                    depositRequest.getAmount(),
                    depositRequest.getAccountId(),
                    Operation.DEPOSIT);

            _transactionCommandHandler.makeDeposit(depositCommand);

            return ResponseEntity.status(200).build();
        }catch(AccountNotFoundException ex){
            return ResponseEntity.status(400).body("Conta não existe!");
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawRequest withdrawRequest) {

        try
        {
            WithdrawCommand withdrawCommand = new WithdrawCommand(
                    withdrawRequest.getAmount(),
                    withdrawRequest.getAccountId(),
                    Operation.WITHDRAW);

            _transactionCommandHandler.makeWithdraw(withdrawCommand);

            return ResponseEntity.status(200).build();
        }catch(AccountNotFoundException ex){
            return ResponseEntity.status(400).body("Conta não existe!");
        }catch(InsufficientFundsException ex){
            return ResponseEntity.status(400).body("Salvo insuficiente!");
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferRequest) {
       
        try
        {
            TransferCommand transferCommand = new TransferCommand(
                    transferRequest.getAmount(),
                    transferRequest.getAccountId(),
                    Operation.TRANFER,
                    transferRequest.getDestinationAccountId());

            _transactionCommandHandler.makeTransfer(transferCommand);

            return ResponseEntity.status(200).build();

        }catch(AccountNotFoundException ex){
            return ResponseEntity.status(400).body("Conta não existe!");
        }catch(InsufficientFundsException ex){
            return ResponseEntity.status(400).body("Salvo insuficiente!");
        }

    }
}
