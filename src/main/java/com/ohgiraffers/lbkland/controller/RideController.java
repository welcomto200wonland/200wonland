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

        String rideId = parameter.get("rideId");

        RideDTO ride = rideService.selectRideByCode(rideId);

        if(ride != null){
            printResult.printRide(ride);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registRide(Map<String, String> parameter) {

        String rideId = parameter.get("rideId");
        String rideName = parameter.get("rideName");
        String staffId = parameter.get("staffId");

        RideDTO ride = new RideDTO();
        ride.setRideId(rideId);
        ride.setRideName(rideName);
        ride.setStaffId(staffId);

        if(rideService.registRide(ride)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }


    }

    public void modifyRide(Map<String, String> parameter) {

        String rideId = parameter.get("rideId");
        String rideName = parameter.get("rideName");
        String staffId = parameter.get("staffId");

        RideDTO ride = new RideDTO();
        ride.setRideId(rideId);
        ride.setRideName(rideName);
        ride.setStaffId(staffId);

        if(rideService.modifyRide(ride)){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }



    }

    public void deleteRide(Map<String, String> parameter) {
        String rideId = parameter.get("rideId");

        if(rideService.deleteRide(rideId)){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
