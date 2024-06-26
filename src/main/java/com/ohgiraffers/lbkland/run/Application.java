package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.StaffController;

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
            System.out.println("3. 놀이기구 코드로 직원 조회하기");
            System.out.println("4. 신규직원 정보 추가하기");
            System.out.println("5. 직원정보 수정하기");
            System.out.println("6. 퇴사직원 정보 삭제하기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: staffController.selectAllStaff(); break;
//                case 2: StaffController.selectStaffById(inputStaffId()); break;
//                case 3: StaffController.selectRideByCode(inputRideCode); break;
//                case 4: StaffController.registStaff(inputStaff); break;
//                case 5: StaffController.modifyStaff(inputModifyStaff); break;
//                case 6: StaffController.deleteStaff(inputStaffId); break;
            }
        } while (true);

    }


}
