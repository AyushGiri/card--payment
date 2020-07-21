package com.ayush.cardpayment.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Card {
    @Id
    @GeneratedValue
    private int cardId;

    private String cardNo;
    private String cardHolderName;
    private short cardType;
    private int cvv;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    private String cardBank;
    private double cardAmount;
}
