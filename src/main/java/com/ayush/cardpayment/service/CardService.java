package com.ayush.cardpayment.service;

import com.ayush.cardpayment.exception.NotEnoughBalanceException;
import com.ayush.cardpayment.model.Card;
import com.ayush.cardpayment.model.CardDTO;
import com.ayush.cardpayment.repository.CardRepository;
import com.ayush.cardpayment.utils.CardUtil;
import com.ayush.cardpayment.utils.ErrorMessage;
import com.ayush.cardpayment.utils.ParamDTO;
import com.ayush.cardpayment.utils.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private CardRepository cardRepo;
    public ReplyDTO replyDTO = new ReplyDTO();

    @Autowired
    public CardService(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    public ReplyDTO updateCard(ParamDTO paramDTO) {
        CardDTO cardDTO = paramDTO.getDto();
        Card card = CardUtil.DtoToEntity(cardDTO);
        cardRepo.save(card);
        replyDTO.setDto(cardDTO);
        replyDTO.setErrMsg(ErrorMessage.SUCCESSFULLY_UPDATED);
        return replyDTO;
    }

    public ReplyDTO deleteCard(ParamDTO paramDTO) {
        int cardId = paramDTO.getDto().getCardId();
        Card card = cardRepo.findOne(cardId);
        if (card == null) {
            replyDTO.setErrMsg(ErrorMessage.CARD_NOT_FOUND);
            return replyDTO;
        }
        cardRepo.delete(cardId);
        CardDTO cardDTO = CardUtil.entityToDto(card);
        replyDTO.setDto(cardDTO);
        replyDTO.setErrMsg(ErrorMessage.SUCCESSFULLY_DELETED);
        return replyDTO;
    }

    public ReplyDTO getCard(ParamDTO paramDTO) {
        int cardId = paramDTO.getDto().getCardId();
        Card card = cardRepo.findOne(cardId);
        if (CardUtil.isEmpty(card)) {
            replyDTO.setErrMsg(ErrorMessage.CARD_NOT_FOUND);
            return replyDTO;
        }
        CardDTO cardDTO = CardUtil.entityToDto(card);
        replyDTO.setDto(cardDTO);
        replyDTO.setErrMsg(ErrorMessage.CARD_FOUND);
        return replyDTO;
    }

    public ReplyDTO getAllCards() {
        List<Card> cards = cardRepo.findAll();
        if (CardUtil.isEmpty(cards)) {
            replyDTO.setErrMsg(ErrorMessage.NO_CARDS);
            return replyDTO;
        }
        List<CardDTO> cardDTOS = new ArrayList<>();
        for (Card card : cards) {
            CardDTO cardDTO = CardUtil.entityToDto(card);
            cardDTOS.add(cardDTO);
        }
        replyDTO.setDtos(cardDTOS);
        replyDTO.setErrMsg(ErrorMessage.ALL_CARDS);
        return replyDTO;
    }

    public ReplyDTO withdraw (ParamDTO paramDTO) throws NotEnoughBalanceException {
        int cardId = paramDTO.getDto().getCardId();
        double amount = paramDTO.getDto().getCardAmount();
        Card card = cardRepo.findOne(cardId);
        if (CardUtil.isEmpty(card)) {
            replyDTO.setErrMsg(ErrorMessage.CARD_NOT_FOUND);
            return replyDTO;
        }
        double currAmount = card.getCardAmount();
        if (currAmount < amount) {
            replyDTO.setErrMsg(ErrorMessage.INSUFFICIENT_BALANCE);
            throw new NotEnoughBalanceException();
        }
        currAmount = currAmount - amount;
        card.setCardAmount(currAmount);
        cardRepo.save(card);
        CardDTO cardDTO = CardUtil.entityToDto(card);
        replyDTO.setErrMsg(ErrorMessage.SUCCESSFULLY_WITHDRAWN);
        replyDTO.setDto(cardDTO);
        return replyDTO;
    }

    public ReplyDTO refund(ParamDTO paramDTO) {
        int cardId = paramDTO.getDto().getCardId();
        double amount = paramDTO.getDto().getCardAmount();
        Card card = cardRepo.findOne(cardId);
        if (CardUtil.isEmpty(card)) {
            replyDTO.setErrMsg(ErrorMessage.CARD_NOT_FOUND);
            return replyDTO;
        }
        double currAmount = card.getCardAmount();
        currAmount = currAmount + amount;
        card.setCardAmount(currAmount);
        cardRepo.save(card);
        CardDTO cardDTO = CardUtil.entityToDto(card);
        replyDTO.setDto(cardDTO);
        replyDTO.setErrMsg(ErrorMessage.SUCCESSFULLY_REFUND);
        return replyDTO;
    }


}
