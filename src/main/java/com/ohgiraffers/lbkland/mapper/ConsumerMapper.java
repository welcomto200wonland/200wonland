package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;

import java.util.List;

public interface ConsumerMapper {

    List<ConsumerDTO> selectAllConsumer();

    ConsumerDTO selectConsumerById(String id);

    int insertConsumer(ConsumerDTO consumer);

    int modifyConsumer(ConsumerDTO consumer);

    int deleteConsumer(String id);

    int insertConsumer1(ConsumerDTO consumer);
    int modifyConsumerByStaff(ConsumerDTO consumer);

    int modifyConsumerPwByConsumer(ConsumerDTO consumer);

    int modifyConsumerNameByConsumer(ConsumerDTO consumer);

    int modifyConsumerphoneByConsumer(ConsumerDTO consumer);
}
