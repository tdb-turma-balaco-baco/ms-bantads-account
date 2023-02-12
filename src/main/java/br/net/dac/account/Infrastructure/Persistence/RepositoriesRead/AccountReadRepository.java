package br.net.dac.account.Infrastructure.Persistence.RepositoriesRead;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import jakarta.websocket.server.PathParam;

@Repository
public interface AccountReadRepository extends JpaRepository<AccountDetails,Long> {
    
    @Query("select a from Account a where a.managerCpf = :cpf AND a.status = 'PENDING'")
    List<AccountDetails> findPendingAccountByManagerCpf(@PathParam("cpf") String cpf);

    @Query("select a from Account a where a.managerCpf = :cpf AND a.status = 'PENDING' ORDER BY a.balance DESC LIMIT 5")
    List<AccountDetails> findTopFiveClientsManager(@PathParam("cpf") String cpf);
}
