package service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import entity.BankCard;
import repo.BankCardRepository;


@Service
@Transactional
public class CardService {
    private final BankCardRepository repository;
    public CardService(BankCardRepository repository){
        this.repository = repository;
    }
    public BankCard findCard(String number){
        return repository.findByBankCardNumber(number);
    }

}
