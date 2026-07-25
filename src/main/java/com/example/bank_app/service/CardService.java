package com.example.bank_app.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import com.example.bank_app.entity.BankCard;
import com.example.bank_app.repo.BankCardRepository;


@Service
@Transactional
public class CardService {
    private final BankCardRepository repository;
    public CardService(BankCardRepository repository){
        this.repository = repository;
    }
    public BankCard findCard(String number){
        return repository.findByNumber(number);
    }

}
