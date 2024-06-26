package com.ohgiraffers.lbkland.service;


import com.ohgiraffers.lbkland.dto.RideDTO;
import com.ohgiraffers.lbkland.mapper.RideMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.lbkland.common.Template.getSqlSession;

public class RideService {

    private RideMapper rideMapper;


    public List<RideDTO> selectAllRide() {

        SqlSession sqlSession = getSqlSession();

        rideMapper = sqlSession.getMapper(RideMapper.class);

        List<RideDTO> rideList = rideMapper.selectAllRide();

        sqlSession.close();
        return rideList;
    }
}
