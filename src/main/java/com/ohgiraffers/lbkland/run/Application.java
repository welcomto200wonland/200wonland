package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.StaffController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StaffController staffController = new StaffController();

        do {
            System.out.println("============IBK랜드 점검 관리 시스템========");
            System.out.println("1. 직원 관리");
            System.out.println("2. 놀이기구 관리");
            System.out.println("3. 점검일지 관리");
            System.out.println("0. 나가기");
            System.out.println("관리 번호를 입력해주세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1: staffManagementSubMenu(); break;
                case 2:break;
                case 3:break;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }

        }  while (true) ;

    }

    private static void staffManagementSubMenu() {

        Scanner sc = new Scanner(System.in);
        StaffController staffController = new StaffController();

        do {
            System.out.println("========= <직원관리> 서브 메뉴 =========");
            System.out.println("1. 직원 전체 조회하기");
            System.out.println("2. 직원 ID로 조회하기");
            System.out.println("3. 놀이기구 코드로 담당직원 조회하기");
            System.out.println("4. 신규직원 정보 추가하기");
            System.out.println("5. 직원정보 수정하기");
            System.out.println("6. 퇴사직원 정보 삭제하기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: staffController.selectAllStaff(); break;
                case 2: staffController.selectStaffById(inputStaffId()); break;
                case 3: staffController.selectRideByCode(inputRideCode()); break;
                case 4: staffController.registStaff(inputStaff()); break;
                case 5: staffController.modifyStaff(inputModifyStaff()); break;
                case 6: staffController.deleteStaff(inputStaffId()); break;
            }
        } while (true);

    }

    private static Map<String, String> inputStaffId() {

        Scanner sc = new Scanner(System.in);
        System.out.print("직원의 ID를 입력해 주세요 : ");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);

        return parameter;
    }

    private static Map<String, String> inputRideCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("놀이기구 코드를 입력해 주세요 : ");
        String rideCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideCode", rideCode);

        return parameter;
    }



    private static Map<String, String> inputStaff() {

        Scanner sc = new Scanner(System.in);

        System.out.print("직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("직원의 핸드폰번호를 입력하세요(-포함) : ");
        String staffPhone = sc.nextLine();
        System.out.print("직원의 직급을 입력하세요 : ");
        String staffRank = sc.nextLine();
        System.out.print("직원이 담당하고 있는 놀이기구의 코드를 입력하세요 : ");
        String rideCode = sc.nextLine();
        System.out.print("직원의 이름을 입력하세요 : ");
        String staffName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPhone", staffPhone);
        parameter.put("staffRank", staffRank);
        parameter.put("rideCode", rideCode);
        parameter.put("staffName", staffName);

        return parameter;
    }

    private static Map<String, String> inputModifyStaff() {

        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 핸드폰번호를 입력하세요(-포함) : ");
        String staffPhone = sc.nextLine();
        System.out.print("수정할 직원의 직급을 입력하세요 : ");
        String staffRank = sc.nextLine();
        System.out.print("수정할 직원의 담당하고 있는 놀이기구의 코드를 입력하세요 : ");
        String rideCode = sc.nextLine();
        System.out.print("수정할 직원의 작업일지 작성수를 입력하세요 : ");
        String logCount = sc.nextLine();
        System.out.print("수정할 직원의 이름을 입력하세요 : ");
        String staffName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPhone", staffPhone);
        parameter.put("staffRank", staffRank);
        parameter.put("rideCode", rideCode);
        parameter.put("logCount", logCount);
        parameter.put("staffName", staffName);

        return parameter;

    }
}
