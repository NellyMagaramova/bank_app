package com.example.bank_app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.bank_app.entity.BankCard;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long>{
    BankCard findByNumber(String number);
}
