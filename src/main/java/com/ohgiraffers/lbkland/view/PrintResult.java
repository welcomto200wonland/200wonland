package com.ohgiraffers.lbkland.view;

import com.ohgiraffers.lbkland.dto.LogDTO;

import java.util.List;

public class PrintResult {

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
}
