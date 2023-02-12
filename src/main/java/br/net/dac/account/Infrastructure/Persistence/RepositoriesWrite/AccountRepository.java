package br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Write.Account;
import jakarta.websocket.server.PathParam;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    
    @Query(value = "SELECT balance from Account WHERE accountId = :accountId", nativeQuery = true)
    Double getBalanceByAccountId(@PathParam("accountId") Long accountId);

    @Query(value = "SELECT a.accountNumber from Account a INNER JOIN Client c on a.clientId = c.clientId WHERE c.cpf = :cpf", nativeQuery = true)
    Long findAccountIdByCpf(@PathParam("cpf") String cpf);

    @Query("select a from Account a inner join a.client c where c.cpf = :cpf")
    Account findAccountByClientCpf(@PathParam("cpf") String cpf);

    @Query("select a from Account a inner join a.manager m where m.cpf = :cpf AND a.status != 'PENDING'")
    List<Account> findAccountByManagerCpf(@PathParam("cpf") String cpf);


}
