package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.StaffDTO;

public interface StaffLoginMapper {
    StaffDTO findStaffById(String staffId);
}
