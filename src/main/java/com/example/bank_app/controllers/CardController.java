package com.example.bank_app.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bank_app.entity.BankCard;
import org.springframework.web.bind.annotation.*;
import com.example.bank_app.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @PostMapping("/number")
    public ResponseEntity<BankCard> findByNumber(@RequestBody String number){
        return ResponseEntity.ok(cardService.findCard(number));

    }

    @PostMapping("/sendBalance")
    public ResponseEntity<BankCard> sendBalance(@RequestBody String number1, String number2, int value){
        return ResponseEntity.ok(cardService.sendBalance(number1, number2, value));
    }



}
