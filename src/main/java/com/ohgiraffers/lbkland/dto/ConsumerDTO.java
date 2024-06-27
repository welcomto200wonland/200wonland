package com.ohgiraffers.lbkland.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConsumerDTO {

    private String consumerId;
    private String consumerPw;
    private String consumerName;
    private String consumerPhone;
    private String consumerRank;
    private String consumerDate;

}
