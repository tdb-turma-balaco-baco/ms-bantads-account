package br.net.dac.account.Infrastructure.Persistence.RepositoriesRead;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Read.TransactionDetails;

@Repository
public interface TransactionReadRepository extends JpaRepository<TransactionDetails, UUID> {
    
    @Query("select t from TransactionDetails t where (t.sourceAccount = :sourceAccount OR t.destinationAccount = :sourceAccount) AND t.operationDate BETWEEN :dtStart AND :dtEnd ORDER BY t.operationDate ASC")
    List<TransactionDetails> findTransactionsByClientAndDate(
            @Param("sourceAccount") Long sourceAccount,
            @Param("dtStart") Date operationDateStart,
            @Param("dtEnd") Date operationDateEnd);
}
