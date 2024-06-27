package com.ohgiraffers.lbkland.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StaffDTO {

    private String staffId;
    private String staffPhone;
    private String staffRank;
    private String rideCode;
    private int logCount;
    private String staffName;

}