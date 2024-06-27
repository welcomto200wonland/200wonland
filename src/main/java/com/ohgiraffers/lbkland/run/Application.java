package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.StaffController;

import com.ohgiraffers.lbkland.controller.LogController;

import com.ohgiraffers.lbkland.controller.RideController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                case 2: selectRide(); break;
                case 3: selectLog(); break;
                case 0: return;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }

        }  while (true) ;

    }

    private static void selectLog() {
        Scanner sc = new Scanner(System.in);

        LogController logController = new LogController();

        do {
            System.out.println("=============== 점검일지 관리 시스템 ===============");
            System.out.println("1. 전체 점검일지 조회하기");
            System.out.println("2. 일지 ID로 원하는 점검 일지 조회하기");
            System.out.println("3. 직원 ID로 직원별 작성한 점검 일지 조회하기");
            System.out.println("4. 점검일지 추가하기");
            System.out.println("5. 점검일지 수정하기(점검일지 ID로)");
            System.out.println("6. 점검일지 삭제하기(점검일지 ID로)");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("원하는 번호를 입력해주세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1 : logController.selectAllLog(); break;
                case 2 : logController.selectLogByCode(inputLogCode()); break;
                case 3 : logController.selectLogByStaffId(inputStaffCode()); break;
                case 4 : logController.registerLog(registerLog()); break;
                case 5 : logController.modifyLog(inputModifyLog()); break;
                case 6 : logController.deleteLog(inputLogCode()); break;
                case 0 : return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputLogCode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("점검일지 ID를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;

    }

    private static Map<String, String> inputStaffCode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("STAFF ID를 입력하세요 : ");
        String staId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staId", staId);

        return parameter;

    }

    private static Map<String, String> registerLog() {

        Scanner sc = new Scanner(System.in);
        System.out.println("등록할 점검일지 ID를 입력하세요 : ");
        String logId = sc.nextLine();

        System.out.println("점검일지 내용을 입력하세요 : ");
        String logContents = sc.nextLine();

        System.out.println("점검일지 제목을 입력하세요 : ");
        String logTitle = sc.nextLine();

        System.out.println("놀이기구 코드를 입력하세요 : ");
        String rideCode = sc.nextLine();

        System.out.println("점검일지 작성 일시를 입력하세요 : ");
        String logDate = sc.nextLine();

        System.out.println("담당 직원 ID를 입력하세요 : ");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("logId", logId);
        parameter.put("logContents", logContents);
        parameter.put("rideCode", rideCode);
        parameter.put("logTitle", logTitle);
        parameter.put("logDate", logDate);
        parameter.put("staffId", staffId);

        return parameter;

    }

    private static Map<String, String> inputModifyLog() {

        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 점검일지 ID를 입력하세요 : ");
        String logId = sc.nextLine();

        System.out.println("수정할 점검일지 내용을 입력하세요 : ");
        String logContents = sc.nextLine();

        System.out.println("놀이기구 코드를 입력하세요 : ");
        String rideCode = sc.nextLine();

        System.out.println("점검일지 제목을 입력하세요 : ");
        String logTitle = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("logId", logId);
        parameter.put("logContents", logContents);
        parameter.put("rideCode", rideCode);
        parameter.put("logTitle", logTitle);

        return parameter;
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
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: rideController.selectAllRide(); break;
                case 2: rideController.selectRideByCode(inputRideCode1()); break;
                case 3: rideController.registRide(inputRide()); break;
                case 4: rideController.modifyRide(inputModifyRide()); break;
                case 5: rideController.deleteRide(inputRideCode1()); break;
                case 0: return;
            }
        } while (true);
    }

    private static Map<String,String> inputRideCode1() {
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
            System.out.println("0. 이전메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: staffController.selectAllStaff(); break;
                case 2: staffController.selectStaffById(inputStaffId()); break;
                case 3: staffController.selectRideByCode(inputRideCode()); break;
                case 4: staffController.registStaff(inputStaff()); break;
                case 5: staffController.modifyStaff(inputModifyStaff()); break;
                case 6: staffController.deleteStaff(inputStaffId()); break;
                case 0: return;
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
        System.out.print("직원의 설정할 패스워드를 입력하세요 : ");
        String staffPassword = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPhone", staffPhone);
        parameter.put("staffRank", staffRank);
        parameter.put("rideCode", rideCode);
        parameter.put("staffName", staffName);
        parameter.put("staffPassword", staffPassword);

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
        System.out.print("수정할 직원의 패스워드를 입력하세요 : ");
        String staffPassword = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPhone", staffPhone);
        parameter.put("staffRank", staffRank);
        parameter.put("rideCode", rideCode);
        parameter.put("logCount", logCount);
        parameter.put("staffName", staffName);
        parameter.put("staffPassword", staffPassword);

        return parameter;

    }
}



