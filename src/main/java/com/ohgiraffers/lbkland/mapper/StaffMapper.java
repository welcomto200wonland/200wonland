package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.StaffDTO;

import java.util.List;

public interface StaffMapper {

    List<StaffDTO> selectAllStaff();
}
