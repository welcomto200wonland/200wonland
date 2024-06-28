package com.ohgiraffers.lbkland.run;

import com.ohgiraffers.lbkland.controller.ConsumerController;
import com.ohgiraffers.lbkland.controller.LoginController;
import com.ohgiraffers.lbkland.controller.StaffController;

import com.ohgiraffers.lbkland.controller.LogController;

import com.ohgiraffers.lbkland.controller.RideController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

// main
    public static void main(String[] args) {

        Application app = new Application();
        ConsumerController consumerController = new ConsumerController();

        Scanner sc = new Scanner(System.in);
do {
    System.out.println("============IBK LAND 로그인========");
    System.out.println("IBK LAND 사이트 입니다.");
    System.out.println("1. 회원으로 로그인");
    System.out.println("2. 직원으로 로그인");
    System.out.println("3. VIP로 로그인");
    System.out.println("4. 신규회원 가입");
    System.out.println("0. 프로그램 종료");
    System.out.print("메뉴 번호를 입력해 주세요 : ");

    int no = sc.nextInt();
    switch (no){
        case 1: consumerLoginMain(); break;
        case 2: staffLoginMain(); break;
        case 3: vipLoginMain(); break;
        case 4: consumerController.newMemberSignUp(inputConsumerSignUp()); break;
        case 0: return;
        default:
            System.out.println(" 잘못된 번호를 입력하셨습니다. ");
            break;
        }
    } while(true);

}
    // VIP 로그인 페이지
    private static void vipLoginMain() {
        LoginController loginController= new LoginController();
        System.out.println("VIP 로그인 페이지 입니다.");
        loginController.tryVipLogin(inputVipIdPw());
    }

    // VIP ID&PW 입력
    private static Map<String, String> inputVipIdPw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("회원 PW를 입력하세요 : ");
        String consumerPw = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);

        return parameter;
    }

    // 로그인 후 VIP 사용 가능한 기능 main 페이지
    public void vipLogin() {
        Scanner sc = new Scanner(System.in);
        RideController rideController = new RideController();
        ConsumerController consumerController = new ConsumerController();
        do {
            System.out.println("============ VIP 메뉴 ========");
            System.out.println("1. 놀이기구 전체 조회");
            System.out.println("2. 놀이기구 선택 조회");
            System.out.println("3. 회원 정보 조회");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원탈퇴");
            System.out.println("0. 나가기");
            System.out.println("메뉴 번호를 입력해주세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    rideController.selectAllRide();
                    break;
                case 2:
                    rideController.selectRideByCode(inputRideCode1());
                    break;
                case 3:
                    consumerController.selectConsumerById(inputConsumerCode());
                    break;
                case 4:
                    consumerController.modifyConsumer(modifyConsumerByConsumer());
                    break;
                case 5:
                    consumerController.delectConsumer(inputConsumerCode());
                    break;
                case 0:
                    return;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }

        } while (true);
    }

}




