package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.LogController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    /*
     * 시스템 요구사항
     * 1. 전체 점검일지 조회
     * 2. 일지 ID로 원하는 점검 일지 조회
     * 3. 직원 ID로 직원별 작성한 점검 일지 조회
     * 4. 점검일지 추가
     * 5. 점검일지 수정(점검일지 ID로)
     * 6. 점검일지 삭제(점검일지 ID로)
     * */

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
                case 1:break;
                case 2:break;
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
}
