package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.StaffDTO;

import java.util.List;

public interface StaffMapper {

    List<StaffDTO> selectAllStaff();

    StaffDTO selectStaffById(String staffId);

    StaffDTO selectRideByCode(String rideCode);

    int registStaff(StaffDTO staff);

    int modifyStaff(StaffDTO staff);

    int deleteStaff(String staffId);
}
