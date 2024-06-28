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


    public static void main(String[] args) {

        Application app = new Application();
        ConsumerController consumerController = new ConsumerController();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============WELCOME TO LBK LAND========");
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
            }
        } while (true);

    }

    // 로그인 기능
    private static void staffLoginMain() {
        LoginController loginController = new LoginController();
        System.out.println("직원 로그인 페이지 입니다.");
        loginController.tryStaffLogin(inputStaffIdPw());
    }

    public static void consumerLoginMain() {
        LoginController loginController = new LoginController();
        System.out.println("회원 로그인 페이지 입니다.");
        loginController.tryConsumerLogin(inputConsumerIdPw());
    }

    private static void vipLoginMain() {
        LoginController loginController = new LoginController();
        System.out.println("VIP 로그인 페이지 입니다.");
        loginController.tryVipLogin(inputVipIdPw());
    }

    // ID & PW 입력
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

    private static Map<String, String> inputStaffIdPw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("직원 로그인 페이지입니다.");
        System.out.println("ID를 입력하세요 : ");
        String staffId = sc.nextLine();

        System.out.println("패스워드를 입력하세요 : ");
        String staffPassword = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPassword", staffPassword);

        return parameter;

    }

    private static Map<String, String> inputConsumerSignUp() {

        Scanner sc = new Scanner(System.in);

        System.out.println("사용하실 ID를 입력해주세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("사용하실 PASSWORD를 입력해주세요 : ");
        String consumerPw = sc.nextLine();

        System.out.println("이름을 입력해주세요 : ");
        String consumerName = sc.nextLine();

        System.out.println("전화번호를 입력해주세요(-포함) : ");
        String consumerPhone = sc.nextLine();

        System.out.println("가입 날짜를 입력해주세요(오늘 날짜로 입력해주세요, YYYY-MM-DD) : ");
        String consumerDate = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);
        parameter.put("consumerName", consumerName);
        parameter.put("consumerPhone", consumerPhone);
        parameter.put("consumerDate", consumerDate);

        return parameter;

    }

    private static Map<String, String> inputConsumerIdPw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 로그인 페이지입니다.");
        System.out.println("ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("패스워드를 입력하세요 : ");
        String consumerPw = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);

        return parameter;
    }

    // 로그인 후 사용 가능한 기능 main 페이지
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
                case 1: rideController.selectAllRide(); break;
                case 2: rideController.selectRideByCode(inputRideCode1()); break;
                case 3: consumerController.selectConsumerById(inputConsumerCode()); break;
                case 4: consumerController.modifyConsumer(modifyConsumerByConsumer()); break;
                case 5: consumerController.delectConsumer(inputConsumerCode()); break;
                case 0: return;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }
        } while (true);
    }

    public static void consumerLogin() {
        Scanner sc = new Scanner(System.in);
        RideController rideController = new RideController();
        ConsumerController consumerController = new ConsumerController();
        do {
            System.out.println("============회원님의 관리 메뉴========");
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
                    selectModifyConsumer();
                    break;
//                    consumerController.modifyConsumer(modifyConsumerByConsumer());
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

    public static void staffLogin() {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("============IBK랜드 점검 관리 시스템========");
            System.out.println("1. 직원 관리");
            System.out.println("2. 놀이기구 관리");
            System.out.println("3. 점검일지 관리");
            System.out.println("4. 고객정보 관리");
            System.out.println("0. 나가기");
            System.out.println("관리 번호를 입력해주세요: ");
            int no = sc.nextInt();

            switch (no) {
                case 1: staffManagementSubMenu(); break;
                case 2: selectRide(); break;
                case 3: selectLog(); break;
                case 4: selectConsumer(); break;
                case 0: return;
                default:
                    System.out.println(" 잘못된 번호를 입력하셨습니다. ");
                    break;
            }

        } while (true);

    }


    // 점검일지 메뉴 및 기능
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
        System.out.println("직원 ID를 입력하세요 : ");
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


    // 놀이기구 메뉴 및 기능
    public static void selectRide() {
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
    public static Map<String,String> inputRideCode1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("놀이기구 코드를 입력하세요 : ");
        String rideId = sc.nextLine();
        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideId", rideId);
        return parameter;
    }

    private static Map<String, String> inputRide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("놀이기구 코드를 입력하세요.");
        String rideId = sc.nextLine();
        System.out.println("놀이기구 이름을 입력하세요.");
        String rideName = sc.nextLine();
        System.out.println("담당 직원을 입력하세요.");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideId", rideId);
        parameter.put("rideName", rideName);
        parameter.put("staffId", staffId);

        return parameter;

    }

    private static Map<String, String> inputModifyRide() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 놀이기구 코드을 입력하세요.");
        String rideId = sc.nextLine();
        System.out.println("수정할 놀이기구 이름을 입력하세요.");
        String rideName = sc.nextLine();
        System.out.println("수정할 담당 직원을 입력하세요.");
        String staffId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("rideId", rideId);
        parameter.put("rideName", rideName);
        parameter.put("staffId", staffId);
        return parameter;

    }


    // 직원 메뉴 및 기능
    private static void staffManagementSubMenu() {

        Scanner sc = new Scanner(System.in);
        StaffController staffController = new StaffController();

        do {
            System.out.println("========= <직원관리> 메뉴 =========");
            System.out.println("1. 직원 전체 조회하기");
            System.out.println("2. 직원 ID로 조회하기");
            System.out.println("3. 놀이기구 코드로 담당직원 조회하기");
            System.out.println("4. 신규직원 정보 추가하기");
            System.out.println("5. 직원정보 수정하기");
            System.out.println("6. 퇴사직원 정보 삭제하기");
            System.out.println("7. 고객관리 메뉴 진입");
            System.out.println("0. 이전메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    staffController.selectAllStaff();
                    break;
                case 2:
                    staffController.selectStaffById(inputStaffId());
                    break;
                case 3:
                    staffController.selectRideByCode(inputRideCode());
                    break;
                case 4:
                    staffController.registStaff(inputStaff());
                    break;
                case 5:
                    staffManagementSubMenu1();
                    break;
                case 6:
                    staffController.deleteStaff(inputStaffId());
                    break;
                case 7:
                    selectConsumer();
                    break;
                case 0:
                    return;
            }
        } while (true);

    }

    // 직원정보 세부수정 메뉴
    private static void staffManagementSubMenu1() {

        Scanner sc = new Scanner(System.in);
        StaffController staffController = new StaffController();

        do {
            System.out.println("========= <직원정보 수정> 메뉴 =========");
            System.out.println("1. PASSWORD 수정");
            System.out.println("2. 이름 수정");
            System.out.println("3. 핸드폰번호 수정");
            System.out.println("4. 직급 수정");
            System.out.println("5. 담당 놀이기구 코드 수정");
            System.out.println("6. 점검일지 작성 수 수정");
            System.out.println("0. 이전메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    staffController.modifyStaffPassword(inputStaffPassword());
                    break;
                case 2:
                    staffController.modifyStaffName(inputStaffName());
                    break;
                case 3:
                    staffController.modifyStaffPhone(inputStaffPhone());
                    break;
                case 4:
                    staffController.modifyStaffRank(inputStaffRank());
                    break;
                case 5:
                    staffController.modifyStaffRideCode(inputStaffRideCode());
                    break;
                case 6:
                    staffController.modifyStaffLogCount(inputStaffLogCount());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    // 직원 점검일지 작성 수만 수정
    private static Map<String, String> inputStaffLogCount() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 점검일지 작성 수를 입력하세요 : ");
        String staffLogCount = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffLogCount", staffLogCount);

        return parameter;

    }

    // 직원 담당 놀이기구 코드만 수정
    private static Map<String, String> inputStaffRideCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 담당 놀이기구 코드를 입력하세요 : ");
        String staffRideCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffRideCode", staffRideCode);

        return parameter;

    }

    // 직원 직급만 수정
    private static Map<String, String> inputStaffRank() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 직급을 입력하세요 : ");
        String staffRank = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffRank", staffRank);

        return parameter;

    }

    // 직원 핸드폰번호만 수정
    private static Map<String, String> inputStaffPhone() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 핸드폰번호를 입력하세요 : ");
        String staffPhone = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPhone", staffPhone);

        return parameter;

    }

    // 직원 이름만 수정
    private static Map<String, String> inputStaffName() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 이름을 입력하세요 : ");
        String staffName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffName", staffName);

        return parameter;

    }

    // 직원 패스워드만 수정
    private static Map<String, String> inputStaffPassword() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원의 ID를 입력하세요 : ");
        String staffId = sc.nextLine();
        System.out.print("수정할 직원의 패스워드를 입력하세요 : ");
        String staffPassword = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("staffId", staffId);
        parameter.put("staffPassword", staffPassword);

        return parameter;

    }

    private static Map<String, String> inputStaffId () {

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
            System.out.print("직원의 설정할 패스워드를 입력하세요 : ");
            String staffPassword = sc.nextLine();
            System.out.print("직원의 이름을 입력하세요 : ");
            String staffName = sc.nextLine();
            System.out.print("직원의 핸드폰번호를 입력하세요(-포함) : ");
            String staffPhone = sc.nextLine();
            System.out.print("직원의 직급을 입력하세요 : ");
            String staffRank = sc.nextLine();
            System.out.print("직원이 담당하고 있는 놀이기구의 코드를 입력하세요 : ");
            String rideCode = sc.nextLine();

            Map<String, String> parameter = new HashMap<>();
            parameter.put("staffId", staffId);
            parameter.put("staffPhone", staffPhone);
            parameter.put("staffRank", staffRank);
            parameter.put("rideCode", rideCode);
            parameter.put("staffName", staffName);
            parameter.put("staffPassword", staffPassword);

            return parameter;
        }

//        private static Map<String, String> inputModifyStaff () {
//
//            Scanner sc = new Scanner(System.in);
//
//            System.out.print("수정할 직원의 ID를 입력하세요 : ");
//            String staffId = sc.nextLine();
//            System.out.print("수정할 직원의 패스워드를 입력하세요 : ");
//            String staffPassword = sc.nextLine();
//            System.out.print("수정할 직원의 이름을 입력하세요 : ");
//            String staffName = sc.nextLine();
//            System.out.print("수정할 직원의 핸드폰번호를 입력하세요(-포함) : ");
//            String staffPhone = sc.nextLine();
//            System.out.print("수정할 직원의 직급을 입력하세요 : ");
//            String staffRank = sc.nextLine();
//            System.out.print("수정할 직원의 담당하고 있는 놀이기구의 코드를 입력하세요 : ");
//            String rideCode = sc.nextLine();
//            System.out.print("수정할 직원의 작업일지 작성수를 입력하세요 : ");
//            String logCount = sc.nextLine();
//
//            Map<String, String> parameter = new HashMap<>();
//            parameter.put("staffId", staffId);
//            parameter.put("staffPhone", staffPhone);
//            parameter.put("staffRank", staffRank);
//            parameter.put("rideCode", rideCode);
//            parameter.put("logCount", logCount);
//            parameter.put("staffName", staffName);
//            parameter.put("staffPassword", staffPassword);
//
//            return parameter;
//
//        }

    // 고객관리 메뉴 및 기능

    private static void selectConsumer() {

        Scanner sc = new Scanner(System.in);

        ConsumerController consumerController = new ConsumerController();

        do {
            System.out.println("=============== 고객정보 관리 시스템 ===============");
            System.out.println("1. 전체 고객 명단 조회하기");
            System.out.println("2. 고객 ID로 조회하기");
            System.out.println("3. 고객 추가하기");
            System.out.println("4. 고객 수정하기");
            System.out.println("5. 고객 삭제하기");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("원하는 번호를 입력해주세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    consumerController.selectAllConsumer();
                    break;
                case 2:
                    consumerController.selectConsumerById(inputConsumerCode());
                    break;
                case 3:
                    consumerController.registerConsumer(registerConsumer());
                    break;
                case 4:
                    consumerController.modifyConsumerByStaff(modifyConsumerByStaff());
                    break;
                case 5:
                    consumerController.delectConsumer(inputConsumerCode());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    private static Map<String, String> inputConsumerCode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("고객 ID를 입력하세요 : ");
        String id = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);

        return parameter;


    }

    private static Map<String, String> registerConsumer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("등록할 고객 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("고객 PASSWORD를 입력하세요 : ");
        String consumerPw = sc.nextLine();

        System.out.println("고객 이름을 입력하세요 : ");
        String consumerName = sc.nextLine();

        System.out.println("고객 전화번호를 입력하세요 : ");
        String consumerPhone = sc.nextLine();

        System.out.println("고객 등급을 입력하세요 : ");
        String consumerRank = sc.nextLine();

        System.out.println("고객 가입 날짜를 입력하세요 : ");
        String consumerDate = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);
        parameter.put("consumerName", consumerName);
        parameter.put("consumerPhone", consumerPhone);
        parameter.put("consumerRank", consumerRank);
        parameter.put("consumerDate", consumerDate);

        return parameter;
    }

    private static Map<String, String> modifyConsumerByConsumer() {

        Scanner sc = new Scanner(System.in);

        System.out.println("수정하실 ID를 입력하세요.");
        String consumerId = sc.nextLine();

        System.out.println("수정하실 비밀번호를 입력하세요.");
        String consumerPw = sc.nextLine();

        System.out.println("수정하실 고객 이름을 입력하세요.");
        String consumerName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);
        parameter.put("consumerName", consumerName);

        return parameter;

    }

    // 스탭이 고객 정보 수정할 때
    private static Map<String, String> modifyConsumerByStaff() {

        Scanner sc = new Scanner(System.in);

        System.out.println("고객 ID를 입력하세요.");
        String consumerId = sc.nextLine();

        System.out.println("고객 비밀번호를 입력하세요.");
        String consumerPw = sc.nextLine();

        System.out.println("고객 이름을 입력하세요.");
        String consumerName = sc.nextLine();

        System.out.println("고객 등급을 입력하세요.");
        String consumerRank = sc.nextLine();


        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);
        parameter.put("consumerName", consumerName);
        parameter.put("consumerRank", consumerRank);


        return parameter;

    }


    // 수정 세분화 메소드 - 회원이 회원 정보 수정
    private static void selectModifyConsumer() {
        Scanner sc = new Scanner(System.in);

        ConsumerController consumerController = new ConsumerController();

        do {
            System.out.println("=============== 회원 정보 수정 시스템 ===============");
            System.out.println("1. 비밀번호 변경하기");
            System.out.println("2. 이름 수정하기");
            System.out.println("3. 전화번호 수정하기");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("원하는 번호를 입력해주세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1:
                    consumerController.modifyConsumerPwByConsumer(inputConsumerPw());
                    break;
                case 2:
                    consumerController.modifyConsumerNameByConsumer(inputConsumerName());
                    break;
                case 3:
                    consumerController.modifyConsumerphoneByConsumer(inputConsumerphone());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;

            }
        } while (true);
    }

    private static Map<String,String> inputConsumerPw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("비밀번호 변경을 위해 아이디를 입력해주세요");
        String consumerId = sc.nextLine();
        System.out.println("변경할 새로운 비밀번호를 입력하세요 : ");
        String consumerPw = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);

        return parameter;

    }
    private static Map<String,String> inputConsumerName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력해주세요");
        String consumerId = sc.nextLine();
        System.out.println("변경할 새로운 이름을 입력하세요 : ");
        String consumerName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerName", consumerName);

        return parameter;

    }
    private static Map<String,String> inputConsumerphone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력해주세요");
        String consumerId = sc.nextLine();
        System.out.println("변경할 새로운 전화번호를 입력하세요 : ");
        String consumerPhone = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPhone", consumerPhone);

        return parameter;

    }

    private static void modifyConsumerMenu() {
        Scanner sc = new Scanner(System.in);

        ConsumerController consumerController = new ConsumerController();

        do {
            System.out.println("=============== 고객정보 수정 시스템 ===============");
            System.out.println("1. PW 수정");
            System.out.println("2. 이름 수정");
            System.out.println("3. 등급 수정");
            System.out.println("4. 전화번호 수정");
            System.out.println("5. 전체 수정");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("원하는 번호를 입력해주세요 : ");

            int no = sc.nextInt();

            switch (no) {
                case 1 : consumerController.modifyConsumerByPw(modifyConsumerByPw()); break;
                case 2 : consumerController.modifyConsumerByName(modifyConsumerByName()); break;
                case 3 : consumerController.modifyConsumerByRank(modifyConsumerByRank()); break;
                case 4 : consumerController.modifyConsumerByPhone(modifyConsumerByPhone()); break;
                case 5 : consumerController.modifyConsumerByStaff(modifyConsumerByStaff()); break;
                case 0 : return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while (true);
    }

    // 스탭이 직원 수정하는 기능
    private static Map<String, String> modifyConsumerByPw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("변경할 고객 PW를 입력하세요 : ");
        String consumerPw = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPw", consumerPw);

        return parameter;
    }
    private static Map<String, String> modifyConsumerByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("변경할 고객 이름을 입력하세요 : ");
        String consumerName = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerName", consumerName);

        return parameter;
    }
    private static Map<String, String> modifyConsumerByPhone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("변경할 고객 전화번호를 입력하세요 : ");
        String consumerPhone = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerPhone", consumerPhone);

        return parameter;
    }
    private static Map<String, String> modifyConsumerByRank() {
        Scanner sc = new Scanner(System.in);
        System.out.println("고객 ID를 입력하세요 : ");
        String consumerId = sc.nextLine();

        System.out.println("변경할 고객 등급을 입력하세요 : ");
        String consumerRank = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("consumerId", consumerId);
        parameter.put("consumerRank", consumerRank);

        return parameter;

    }
}







