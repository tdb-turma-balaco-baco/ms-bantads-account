package br.net.dac.account.Infrastructure.Persistence.RepositoriesRead;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Read.TransactionDetails;

@Repository
public interface TransactionReadRepository extends JpaRepository<TransactionDetails, UUID> {
    
}
