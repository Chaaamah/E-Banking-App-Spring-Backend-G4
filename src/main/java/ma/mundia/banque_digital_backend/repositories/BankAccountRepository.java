package ma.mundia.banque_digital_backend.repositories;

import ma.mundia.banque_digital_backend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
    List<BankAccount> getBankAccountByCustomer_Id(Long customerId);
}
