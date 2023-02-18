package br.net.dac.account.Infrastructure.Persistence.RepositoriesRead;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Read.AccountDetails;
import br.net.dac.account.Domain.Enums.Status;
import jakarta.websocket.server.PathParam;

@Repository
public interface AccountReadRepository extends JpaRepository<AccountDetails,Long> {
    
    @Query("select a from AccountDetails a where a.managerCpf = :cpf AND a.status = 'PENDING'")
    List<AccountDetails> findPendingAccountByManagerCpf(@PathParam("cpf") String cpf);

    @Query("select a from AccountDetails a where a.managerCpf = :cpf AND a.status = 'APPROVED' ORDER BY a.balance DESC LIMIT 5")
    List<AccountDetails> findTopFiveClientsManager(@PathParam("cpf") String cpf);

    @Query("select a from AccountDetails a where a.managerCpf = :cpf AND a.status = 'APPROVED' ORDER BY a.clientName")
    List<AccountDetails> findClientsManager(@PathParam("cpf") String cpf);

    AccountDetails findByClientCpf(@Param("clientCpf") String cpf);

    List<AccountDetails> findAllByManagerCpf(@Param("managerCpf") String cpf);

    List<AccountDetails> findAllByStatusOrderByClientNameDesc(@Param("status") Status status);

}
