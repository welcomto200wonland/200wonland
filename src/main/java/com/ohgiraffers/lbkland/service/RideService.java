
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

    public RideDTO selectRideByCode(String rideId) {
        SqlSession sqlSession =getSqlSession();

        rideMapper = sqlSession.getMapper(RideMapper.class);

        RideDTO ride = rideMapper.selectRideByCode(rideId);

        sqlSession.close();
        return ride;
    }

    public boolean registRide(RideDTO ride) {
        SqlSession sqlSession = getSqlSession();

        rideMapper = sqlSession.getMapper(RideMapper.class);

        int result = rideMapper.registRide(ride);

        if(result >0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true :false;
    }

    public boolean modifyRide(RideDTO ride) {
        SqlSession sqlSession = getSqlSession();

        rideMapper = sqlSession.getMapper(RideMapper.class);

        int result = rideMapper.modifyRide(ride);

        if(result>0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;

    }

    public boolean deleteRide(String rideId) {
        SqlSession sqlSession = getSqlSession();

        rideMapper= sqlSession.getMapper(RideMapper.class);

        int result = rideMapper.deleteRide(rideId);

        if(result >0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return  result > 0? true:false;

    }
}