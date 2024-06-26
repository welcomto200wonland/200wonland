package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.RideController;
import com.ohgiraffers.lbkland.service.RideService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RideController rideController = new RideController();

        do {
            System.out.println("============IBK랜드 점검 관리 시스템========");
            System.out.println("1. 직원 관리");
            System.out.println("2. 놀이기구 관리");
            System.out.println("3. 점검일지 관리");
            System.out.println("0. 나가기");
            System.out.println("관리 번호를 입력해주세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1:break;
                case 2: selectRide();break;
                case 3:break;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }

        }  while (true) ;

    }

    public static void selectRide(){
        Scanner sc = new Scanner(System.in);
       RideController rideController = new RideController();
        do {
            System.out.println("========== 놀이기구 관리 메뉴 ==========");
            System.out.println("1. 놀이기구 전체 조회");
            System.out.println("2. 놀이기구 코드로 조회");
            System.out.println("3. 놀이기구 추가하기");
            System.out.println("4. 놀이기구 수정하기");
            System.out.println("5. 놀이기구 삭제하기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: rideController.selectAllRide(); break;
//                case 2: rideController.selectRideByCode(inputRideCode()); break;
//                case 3: rideController.registRide(inputRide()); break;
//                case 4: rideController.modifyRide(inputModifyRide()); break;
//                case 5: rideController.deleteRide(inputRideCode()); break;
            }
        } while (true);
    }

    private static Map<String,String> inputRideCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("놀이기구 코드를 입력하세요 : ");
        String rideId = sc.nextLine();
        Map<String,String> parameter = new HashMap<>();
        parameter.put("rideId",rideId);
        return parameter;
    }

    private static Map<String,String> inputRide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("놀이기구 코드를 입력하세요.");
        String rideId = sc.nextLine();
        System.out.println("놀이기구 이름을 입력하세요.");
        String rideName = sc.nextLine();
        System.out.println("담당 직원을 입력하세요.");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideId",rideId);
        parameter.put("rideName",rideName);
        parameter.put("staffId",staffId);

        return parameter;

    }


    private static Map<String,String> inputModifyRide() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 놀이기구 코드을 입력하세요.");
        String rideId = sc.nextLine();
        System.out.println("수정할 놀이기구 이름을 입력하세요.");
        String rideName = sc.nextLine();
        System.out.println("수정할 담당 직원을 입력하세요.");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideId",rideId);
        parameter.put("rideName",rideName);
        parameter.put("staffId",staffId);
        return parameter;

    }
}


