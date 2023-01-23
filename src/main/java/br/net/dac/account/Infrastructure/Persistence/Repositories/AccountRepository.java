package br.net.dac.account.Infrastructure.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.net.dac.account.Domain.Entities.Account;
import jakarta.websocket.server.PathParam;

public interface AccountRepository extends JpaRepository<Account,Long>{
    
    @Query("SELECT balance from Account WHERE accountId = :accountId")
    Double getBalanceByAccountId(@PathParam("accountId") Long accountId);

    @Query("SELECT a.accountNumber from Account a INNER JOIN Client c on a.clientId = c.clientId WHERE c.cpf = :cpf")
    Long findAccountIdByCpf(@PathParam("cpf") String cpf);
}
