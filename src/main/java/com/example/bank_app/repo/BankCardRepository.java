package com.example.bank_app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.bank_app.entity.BankCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long>{
    BankCard findByNumber(String number);

    @Query("UPDATE public.'BankCard' SET  balance= balance-value  WHERE 'number' = 'number1';  " +
            "UPDATE public.'BankCard'  SET  balance= balance+value  WHERE 'number' = 'number2';"+
            +

    "COMMIT;")
        // искать по всем переданным параметрам (пустые параметры учитываться не будут)


    BankCard sendBalance(@Param("number")String number1,@Param("number")String number2, int value);
}
