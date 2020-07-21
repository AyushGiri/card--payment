package com.ayush.cardpayment.model;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CardDTO {

    private int cardId;
    private String cardNo;
    private String cardHolderName;
    private short cardType;
    private int cvv;
    private Date expiryDate;
    private String cardBank;
    private double cardAmount;

}
