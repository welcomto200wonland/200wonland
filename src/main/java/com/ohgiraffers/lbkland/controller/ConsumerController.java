package com.ohgiraffers.lbkland.controller;

import com.ohgiraffers.lbkland.service.ConsumerService;
import com.ohgiraffers.lbkland.view.PrintResult;

public class ConsumerController {

    private final PrintResult printResult;
    private final ConsumerService consumerService;

    // 생성자 주입
    public ConsumerController() {
        printResult = new PrintResult();
        consumerService = new ConsumerService();
    }









}
