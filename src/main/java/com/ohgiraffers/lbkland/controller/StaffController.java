package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.StaffDTO;
import com.ohgiraffers.lbkland.service.StaffService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.List;

public class StaffController {

    private final PrintResult printResult;
    private final StaffService staffService;

    public StaffController() {
        printResult = new PrintResult();
        staffService = new StaffService();
    }

    public void selectAllStaff() {

        List<StaffDTO> staffList = staffService.selectAllStaff();

        if(staffList != null) {
            printResult.printStaffList(staffList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }
}
