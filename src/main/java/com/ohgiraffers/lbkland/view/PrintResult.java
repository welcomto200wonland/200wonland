package com.ohgiraffers.lbkland.view;

import com.ohgiraffers.lbkland.dto.StaffDTO;

import java.util.List;

import com.ohgiraffers.lbkland.dto.LogDTO;

import com.ohgiraffers.lbkland.dto.RideDTO;

public class PrintResult {

    public void printStaffList(List<StaffDTO> staffList) {

        for (StaffDTO staff : staffList) {
            System.out.println(staff);
        }
    }

    public void printMenu(StaffDTO staff) {
        System.out.println(staff);
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch ((successCode)){
            case "insert" : successMessage = "insert에 성공했습니다."; break;
            case "update" : successMessage = "update에 성공했습니다."; break;
            case "delete" : successMessage = "delete에 성공했습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode){

        String errorMessage= "";
        switch (errorCode){
            case "selectList" : errorMessage = "전체 조회에 실패했습니다."; break;
            case "selectOne" : errorMessage = "단일 조회에 실패했습니다."; break;
            case "insert" : errorMessage = "insert에 실패했습니다."; break;
            case "update" : errorMessage = "update에 실패했습니다."; break;
            case "delete" : errorMessage = "delete에 실패했습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printLogList(List<LogDTO> logList) {

        for (LogDTO logDTO : logList) {
            System.out.println(logDTO);
        }
    }

    public void printLog(LogDTO log) {
        System.out.println(log);
    }

    public void printRideList(List<RideDTO> rideList) {
        for(RideDTO ride: rideList){
            System.out.println(ride);
        }
    }

    public void printRide(RideDTO ride) {
        System.out.println(ride);
    }
}
