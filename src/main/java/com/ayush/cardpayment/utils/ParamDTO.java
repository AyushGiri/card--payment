package com.ayush.cardpayment.utils;

import com.ayush.cardpayment.model.CardDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ParamDTO {
    private CardDTO dto;
    private String errMsg;
}
