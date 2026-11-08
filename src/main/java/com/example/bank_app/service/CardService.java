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
    public BankCard findCard(Integer number){
        return repository.findByNumber(number);
    }
    public BankCard sendBalance(Integer number1, Integer number2, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }

        if (number1 == null || number2 == null || number1.equals(number2)) {
            throw new IllegalArgumentException("Некорректные номера карт");
        }

        int debited = repository.debit(number1, value);

        if (debited != 1) {
            throw new IllegalArgumentException(
                    "Карта отправителя не найдена или недостаточно средств"
            );
        }

        int credited = repository.credit(number2, value);

        if (credited != 1) {
            throw new IllegalArgumentException("Карта получателя не найдена");
        }

        return repository.findByNumber(number2);
    }
    public BankCard blockCard(Integer number){
        if (number == null) {
            throw new IllegalArgumentException("Некорректный номер кары");
        }
        boolean block = repository.block(number) > 0;
        
        System.out.println("статус выполнения блокировки карты" + block);
        return  repository.findByNumber(number);
    }

}
