package repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import entity.BankCard;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, String>{
    BankCard findByBankCardNumber(String number);
}
