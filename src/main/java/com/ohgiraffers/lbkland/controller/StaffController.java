package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.StaffDTO;
import com.ohgiraffers.lbkland.service.StaffService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.List;
import java.util.Map;

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

    public void selectStaffById(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");

        StaffDTO staff = staffService.selectStaffById(staffId);

        if(staff != null) {
            printResult.printMenu(staff);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectRideByCode(Map<String, String> parameter) {

        String rideCode = parameter.get("rideCode");

        StaffDTO staff = staffService.selectRideByCode(rideCode);

        if(staff != null) {
            printResult.printMenu(staff);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registStaff(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffPhone = parameter.get("staffPhone");
        String staffRank = parameter.get("staffRank");
        String rideCode = parameter.get("rideCode");
        String staffName = parameter.get("staffName");
        String staffPassword = parameter.get("staffPassword");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setStaffPhone(staffPhone);
        staff.setStaffRank(staffRank);
        staff.setRideCode(rideCode);
        staff.setStaffName(staffName);
        staff.setStaffPassword(staffPassword);

        if(staffService.registStaff(staff)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

//    public void modifyStaff(Map<String, String> parameter) {
//
//        String staffId = parameter.get("staffId");
//        String staffPhone = parameter.get("staffPhone");
//        String staffRank = parameter.get("staffRank");
//        String rideCode = parameter.get("rideCode");
//        int logCount = Integer.parseInt(parameter.get("logCount"));
//        String staffName = parameter.get("staffName");
//        String staffPassword = parameter.get("staffPassword");
//
//        StaffDTO staff = new StaffDTO();
//        staff.setStaffId(staffId);
//        staff.setStaffPhone(staffPhone);
//        staff.setStaffRank(staffRank);
//        staff.setRideCode(rideCode);
//        staff.setLogCount(logCount);
//        staff.setStaffName(staffName);
//        staff.setStaffPassword(staffPassword);
//
//        if(staffService.modifyStaff(staff)) {
//            printResult.printSuccessMessage("update");
//        } else {
//            printResult.printErrorMessage("update");
//        }
//    }

    public void modifyStaffPassword(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffPassword = parameter.get("staffPassword");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setStaffPassword(staffPassword);

        if (staffService.modifyStaffPassword(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }
    }

    public void modifyStaffName(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffName = parameter.get("staffName");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setStaffName(staffName);

        if (staffService.modifyStaffName(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }

    }

    public void modifyStaffPhone(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffPhone = parameter.get("staffPhone");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setStaffPhone(staffPhone);

        if (staffService.modifyStaffPhone(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }

    }

    public void modifyStaffRank(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffRank = parameter.get("staffRank");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setStaffRank(staffRank);

        if (staffService.modifyStaffRank(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }

    }

    public void modifyStaffRideCode(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        String staffRideCode = parameter.get("staffRideCode");

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setRideCode(staffRideCode);

        if (staffService.modifyStaffRideCode(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }

    }

    public void modifyStaffLogCount(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");
        int staffLogCount = Integer.parseInt(parameter.get("staffLogCount"));

        StaffDTO staff = new StaffDTO();
        staff.setStaffId(staffId);
        staff.setLogCount(staffLogCount);

        if (staffService.modifyStaffLogCount(staff)) {
            printResult.printSuccessMessage("update1");
        } else {
            printResult.printErrorMessage("update1");
        }

    }

    public void deleteStaff(Map<String, String> parameter) {

        String staffId = parameter.get("staffId");

        if(staffService.deleteStaff(staffId)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }

    }
}
