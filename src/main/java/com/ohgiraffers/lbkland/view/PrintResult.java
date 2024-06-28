package com.ohgiraffers.lbkland.view;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.dto.StaffDTO;

import java.util.List;

import com.ohgiraffers.lbkland.dto.LogDTO;

import com.ohgiraffers.lbkland.dto.RideDTO;
import com.ohgiraffers.lbkland.run.Application;

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

        switch ((successCode)) {
            case "insert":
                successMessage = "insert에 성공했습니다.";
                break;
            case "SignUp" :
                successMessage = "신규 회원가입에 성공했습니다.";
                break;
            case "update":
                successMessage = "update에 성공했습니다.";
                break;
            case "update1" :
                successMessage = "정보 수정에 성공했습니다.";
                break;
            case "delete":
                successMessage = "delete에 성공했습니다.";
                break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList":
                errorMessage = "전체 조회에 실패했습니다.";
                break;
            case "selectOne":
                errorMessage = "단일 조회에 실패했습니다.";
                break;
            case "insert":
                errorMessage = "insert에 실패했습니다.";
                break;
            case "SignUp" :
                errorMessage = "신규 회원가입에 실패했습니다.";
                break;
            case "update":
                errorMessage = "update에 실패했습니다.";
                break;
            case "update1" :
                errorMessage = "정보 수정에 실패했습니다.";
                break;
            case "delete":
                errorMessage = "delete에 실패했습니다.";
                break;
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
        for (RideDTO ride : rideList) {
            System.out.println(ride);
        }
    }

    public void printRide(RideDTO ride) {
        System.out.println(ride);
    }


    public void printLoginStaff(){

    }

    public void printLoginConsumer(){

    }

    public void printConsumerList(List<ConsumerDTO> consumerList) {

        for (ConsumerDTO consumerDTO : consumerList) {
            System.out.println(consumerDTO);
        }
    }

    public void printConsumer(ConsumerDTO consumer) {
        System.out.println(consumer);
    }
}