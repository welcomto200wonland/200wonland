package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;

public interface ConsumerLoginMapper {

    ConsumerDTO findConsumerById(String consumerId);
}
