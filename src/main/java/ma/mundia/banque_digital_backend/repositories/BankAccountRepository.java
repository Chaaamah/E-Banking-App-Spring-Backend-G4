package ma.mundia.banque_digital_backend.repositories;

import ma.mundia.banque_digital_backend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
}
