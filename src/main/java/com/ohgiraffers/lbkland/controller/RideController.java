package com.ohgiraffers.lbkland.controller;


import com.ohgiraffers.lbkland.dto.RideDTO;
import com.ohgiraffers.lbkland.service.RideService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.List;
import java.util.Map;

public class RideController {

    private final PrintResult printResult;
    private final RideService rideService;

    public RideController() {
        printResult = new PrintResult();
        rideService = new RideService();
    }

    public void selectAllRide() {

        List<RideDTO> rideList = rideService.selectAllRide();

        if(rideList != null){
            printResult.printRideList(rideList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }


    public void selectRideByCode(Map<String, String> parameter) {
    }
}
