package com.example.bank_app.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.bank_app.entity.BankCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long>{
    BankCard findByNumber(Integer number);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
              UPDATE BankCard card
              SET card.status = false
              WHERE card.number = :number                
              """)
    int block(
            @Param("number") Integer number
    );

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
              UPDATE BankCard card
              SET card.balance = card.balance - :value
              WHERE card.number = :number
                AND card.balance >= :value
              """)
    int debit(
            @Param("number") Integer number,
            @Param("value") long value
    );


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
              UPDATE BankCard card
              SET card.balance = card.balance + :value
              WHERE card.number = :number
              """)
    int credit(
            @Param("number") Integer number,
            @Param("value") long value
    );
  

}
