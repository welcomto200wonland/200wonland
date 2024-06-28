package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.dto.LogDTO;
import com.ohgiraffers.lbkland.service.ConsumerService;
import com.ohgiraffers.lbkland.view.PrintResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsumerController {

    private final PrintResult printResult;
    private final ConsumerService consumerService;

    // 생성자 주입
    public ConsumerController() {
        printResult = new PrintResult();
        consumerService = new ConsumerService();
    }

    public void newMemberSignUp(Map<String, String> parameter) {

        String consumerId = parameter.get("consumerId");
        String consumerPw = parameter.get("consumerPw");
        String consumerName = parameter.get("consumerName");
        String consumerPhone = parameter.get("consumerPhone");
        String consumerDate = parameter.get("consumerDate");

        ConsumerDTO consumer = new ConsumerDTO();
        consumer.setConsumerId(consumerId);
        consumer.setConsumerPw(consumerPw);
        consumer.setConsumerName(consumerName);
        consumer.setConsumerPhone(consumerPhone);
        consumer.setConsumerDate(consumerDate);

        if (consumerService.registerConsumer1(consumer)) {
            printResult.printSuccessMessage("SignUp");
        } else {
            printResult.printErrorMessage("SignUp");
        }

    }

    // 전체 고객 조회
    public void selectAllConsumer() {
        List<ConsumerDTO> consumerList = consumerService.selectAllconsumer();

        if (consumerList != null) {
            printResult.printConsumerList(consumerList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    // ID로 고객 조회
    public void selectConsumerById(Map<String, String> parameter) {
        String id = parameter.get("get");

        ConsumerDTO consumer = consumerService.selectConsumerById(id);

        if (consumer != null) {
            printResult.printConsumer(consumer);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registerConsumer(Map<String, String> parameter) {

        String consumerId = parameter.get("consumerId");
        String consumerPw = parameter.get("consumerPw");
        String consumerName = parameter.get("consumerName");
        String consumerPhone = parameter.get("consumerPhone");
        String consumerRank = parameter.get("consumerRank");
        String consumerDate = parameter.get("consumerDate");

        ConsumerDTO consumer = new ConsumerDTO();
        consumer.setConsumerId(consumerId);
        consumer.setConsumerPw(consumerPw);
        consumer.setConsumerName(consumerName);
        consumer.setConsumerPhone(consumerPhone);
        consumer.setConsumerRank(consumerRank);
        consumer.setConsumerDate(consumerDate);

        if (consumerService.registerConsumer(consumer)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyConsumer(Map<String, String> parameter) {
        String consumerId = parameter.get("consumerId");
        String consumerPw = parameter.get("consumerPw");
        String consumerName = parameter.get("consumerName");

        ConsumerDTO consumer = new ConsumerDTO();
        consumer.setConsumerId(consumerId);
        consumer.setConsumerPw(consumerPw);
        consumer.setConsumerName(consumerName);

        if (consumerService.modifyConsumer(consumer)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }


    public void delectConsumer(Map<String, String> parameter) {
        String id = parameter.get("id");

        if (consumerService.deleteConsumer(id)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
