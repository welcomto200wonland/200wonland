package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.run.Application;
import com.ohgiraffers.lbkland.service.LoginService;

import java.util.Map;

public class LoginController {

    private LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    public void tryConsumerLogin(Map<String, String> parameter) {

        Application app = new Application();

        String consumerId = parameter.get("consumerId");
        String consumerPw = parameter.get("consumerPw");

        ConsumerDTO consumer = new ConsumerDTO();
        consumer.setConsumerId(consumerId);
        consumer.setConsumerPw(consumerPw);

        if (loginService.tryConsumerLogin(consumer)) {
            System.out.println("환영합니다.");
            app.consumerLogin();
        } else {
            System.out.println("너 누구야? 나가");
        }
    }

    public void tryStaffLogin(Map<String, String> stringStringMap) {
    }
}
