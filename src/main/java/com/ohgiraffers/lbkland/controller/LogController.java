package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.LogDTO;
import com.ohgiraffers.lbkland.service.LogService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.List;
import java.util.Map;

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

    public void selectLogByCode(Map<String, String> parameter) {

        String code = parameter.get("code");

        LogDTO log = logService.selectLogByCode(code);

        if (log != null) {
            printResult.printLog(log);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectLogByStaffId(Map<String, String> parameter) {

        String staId = parameter.get("staId");

        LogDTO log = logService.selectLogByStaffId(staId);

        if (log != null) {
            printResult.printLog(log);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registerLog(Map<String, String> parameter) {

        String logId = parameter.get("logId");
        String logContents = parameter.get("logContents");
        String rideCode = parameter.get("rideCode");
        String logTitle = parameter.get("logTitle");
        String logDate = parameter.get("logDate");
        String staffId = parameter.get("staffId");

        LogDTO log = new LogDTO();
        log.setLogId(logId);
        log.setLogContents(logContents);
        log.setRideCode(rideCode);
        log.setLogTitle(logTitle);
        log.setLogDate(logDate);
        log.setStaffId(staffId);

        if (logService.registerLog(log)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }

    }

    public void modifyLog(Map<String, String> parameter) {

        String logId = parameter.get("logId");
        String logContents = parameter.get("logContents");
        String rideCode = parameter.get("rideCode");
        String logTitle = parameter.get("logTitle");

        LogDTO log = new LogDTO();
        log.setLogId(logId);
        log.setLogContents(logContents);
        log.setRideCode(rideCode);
        log.setLogTitle(logTitle);

        if (logService.modifyLog(log)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }

    }

    public void deleteLog(Map<String, String> parameter) {

        String code = parameter.get("code");

        if (logService.deleteLog(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }
}
