package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.LogDTO;

import java.util.List;

public interface LogMapper {

    List<LogDTO> selectAllLog();

    LogDTO selectLogByCode(String code);

    LogDTO selectLogByStaffId(String staId);

    int insertLog(LogDTO log);

    int modifyLog(LogDTO log);

    int deleteLog(String code);
}
