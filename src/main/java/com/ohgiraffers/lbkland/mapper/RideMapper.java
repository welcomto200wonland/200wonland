package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.RideDTO;

import java.util.List;

public interface RideMapper {
    List<RideDTO> selectAllRide();


    RideDTO selectRideByCode(String rideId);

    int registRide(RideDTO ride);

    int modifyRide(RideDTO ride);

    int deleteRide(String rideId);
}
