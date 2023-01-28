package br.net.dac.account.Infrastructure.Persistence.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.net.dac.account.Domain.Entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    
}
