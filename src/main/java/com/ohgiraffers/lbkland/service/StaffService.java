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

    public StaffDTO selectStaffById(String staffId) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        StaffDTO staff = staffMapper.selectStaffById(staffId);

        sqlSession.close();

        return staff;
    }

    public StaffDTO selectRideByCode(String rideCode) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        StaffDTO staff = staffMapper.selectRideByCode(rideCode);

        sqlSession.close();

        return staff;
    }

    public boolean registStaff(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.registStaff(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

//    public boolean modifyStaff(StaffDTO staff) {
//
//        SqlSession sqlSession = getSqlSession();
//
//        staffMapper = sqlSession.getMapper(StaffMapper.class);
//
//        int result = staffMapper.modifyStaff(staff);
//
//        if(result > 0) {
//            sqlSession.commit();
//        } else {
//            sqlSession.rollback();
//        }
//
//        sqlSession.close();
//
//        return result > 0 ? true : false;
//    }

    public boolean deleteStaff(String staffId) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.deleteStaff(staffId);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyStaffPassword(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffPassword(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyStaffName(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffName(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyStaffPhone(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffPhone(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyStaffRank(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffRank(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyStaffRideCode(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffRideCode(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyStaffLogCount(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffMapper = sqlSession.getMapper(StaffMapper.class);

        int result = staffMapper.modifyStaffLogCount(staff);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
