package br.net.dac.account.Infrastructure.Persistence.RepositoriesWrite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.dac.account.Domain.Entities.Write.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    
    Manager findByCpf(@Param("cpf") String cpf);
}
