package com.ayush.cardpayment.utils;

import com.ayush.cardpayment.model.Card;
import com.ayush.cardpayment.model.CardDTO;

public class CardUtil {

    public static CardDTO entityToDto(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardNo(card.getCardNo());
        cardDTO.setCardHolderName(card.getCardHolderName());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setCvv(card.getCvv());
        cardDTO.setExpiryDate(card.getExpiryDate());
        cardDTO.setCardBank(card.getCardBank());
        card.setCardAmount(card.getCardAmount());
        return cardDTO;
    }

    public static Card DtoToEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setCardNo(cardDTO.getCardNo());
        card.setCardHolderName(cardDTO.getCardHolderName());
        card.setCardType(cardDTO.getCardType());
        card.setCvv(cardDTO.getCvv());
        card.setExpiryDate(cardDTO.getExpiryDate());
        card.setCardBank(cardDTO.getCardBank());
        card.setCardAmount(cardDTO.getCardAmount());
        return card;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }
 }
