package br.net.dac.account.Infrastructure.Persistence.RepositoriesRead;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.dac.account.Domain.Entities.Read.TransactionDetails;

public interface TransactionReadRepository extends JpaRepository<TransactionDetails, UUID> {
    
}
