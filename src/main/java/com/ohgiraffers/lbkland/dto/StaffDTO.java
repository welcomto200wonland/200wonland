package com.ohgiraffers.lbkland.dto;

public class StaffDTO {

    private String staffId;
    private String staffPhone;
    private String staffRank;
    private String rideCode;
    private int logCount;
    private String staffName;

    public StaffDTO() {
    }

    public StaffDTO(String staffId, String staffPhone, String staffRank, String rideCode, int logCount, String staffName) {
        this.staffId = staffId;
        this.staffPhone = staffPhone;
        this.staffRank = staffRank;
        this.rideCode = rideCode;
        this.logCount = logCount;
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffRank() {
        return staffRank;
    }

    public void setStaffRank(String staffRank) {
        this.staffRank = staffRank;
    }

    public String getRideCode() {
        return rideCode;
    }

    public void setRideCode(String rideCode) {
        this.rideCode = rideCode;
    }

    public int getLogCount() {
        return logCount;
    }

    public void setLogCount(int logCount) {
        this.logCount = logCount;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "staffId='" + staffId + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffRank='" + staffRank + '\'' +
                ", rideCode='" + rideCode + '\'' +
                ", logCount=" + logCount +
                ", staffName='" + staffName + '\'' +
                '}';
    }
}
