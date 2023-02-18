package br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Write.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    
}
