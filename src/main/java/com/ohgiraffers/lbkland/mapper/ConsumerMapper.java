package com.ohgiraffers.lbkland.mapper;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;

import java.util.List;

public interface ConsumerMapper {

    List<ConsumerDTO> selectAllConsumer();

    ConsumerDTO selectConsumerById(String id);

    int insertConsumer(ConsumerDTO consumer);

    int modifyConsumer(ConsumerDTO consumer);

    int deleteConsumer(String id);

    int modifyConsumerByStaff(ConsumerDTO consumer);
}
