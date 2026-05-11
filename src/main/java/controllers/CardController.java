package controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import entity.BankCard;
import org.springframework.web.bind.annotation.*;
import service.CardService;

@RestController
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @PostMapping("/card")
    public ResponseEntity<BankCard> findByNumber(@RequestBody String number){
        return ResponseEntity.ok(cardService.findCard(number));

    }

}
