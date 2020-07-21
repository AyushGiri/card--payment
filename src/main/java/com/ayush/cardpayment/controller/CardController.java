package com.ayush.cardpayment.controller;

import com.ayush.cardpayment.exception.NotEnoughBalanceException;
import com.ayush.cardpayment.service.CardService;
import com.ayush.cardpayment.utils.ParamDTO;
import com.ayush.cardpayment.utils.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateCard")
    public ReplyDTO updateCard(ParamDTO paramDTO) {
        return cardService.updateCard(paramDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCard")
    public ReplyDTO deleteCard(ParamDTO paramDTO) {
        return cardService.deleteCard(paramDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCard")
    public ReplyDTO getCard(ParamDTO paramDTO) {
        return cardService.getCard(paramDTO);
    }

    public ReplyDTO getAllCards() {
        return cardService.getAllCards();
    }

    @RequestMapping("/withdraw")
    public ReplyDTO withdraw (ParamDTO paramDTO) throws NotEnoughBalanceException {
        return cardService.withdraw(paramDTO);
    }

    @RequestMapping("/refund")
    public ReplyDTO refund(ParamDTO paramDTO) {
        return cardService.refund(paramDTO);
    }
}
