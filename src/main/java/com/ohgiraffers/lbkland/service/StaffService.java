package com.ohgiraffers.lbkland.service;

import com.ohgiraffers.lbkland.dto.StaffDTO;
import com.ohgiraffers.lbkland.mapper.StaffMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.lbkland.common.Template.getSqlSession;

public class StaffService {

    private StaffMapper staffMapper;

    public List<StaffDTO> selectAllStaff() {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        List<StaffDTO> staffList = staffMapper.selectAllStaff();

        sqlSession.close();

        return staffList;
    }
}
