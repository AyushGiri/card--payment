package com.ayush.cardpayment.utils;

import com.ayush.cardpayment.model.CardDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReplyDTO {
    private CardDTO dto;
    private List<CardDTO> dtos;
    private String errMsg;
}
