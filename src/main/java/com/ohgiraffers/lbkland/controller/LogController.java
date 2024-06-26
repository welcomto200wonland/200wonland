package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.LogDTO;
import com.ohgiraffers.lbkland.service.LogService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.List;

public class LogController {

    private final PrintResult printResult;
    private final LogService logService;

    // 생성자 주입
    public LogController() {
        printResult = new PrintResult();
        logService = new LogService();
    }

    // 전체 점검일지 조회
    public void selectAllLog() {
        List<LogDTO> logList = logService.selectAllLog();

        if (logList != null) {
            printResult.printLogList(logList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }
}
