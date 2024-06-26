package com.ohgiraffers.lbkland.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LogDTO {

    private String logId;
    private String logContents;
    private String rideCode;
    private String logTitle;
    private String logDate;
    private String staffId;

}
