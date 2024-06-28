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

    // 스탭이 회원 수정하는 여러가지 회원 수정
    int modifyConsumerByStaff(ConsumerDTO consumer);
    int modifyConsumerByPw(ConsumerDTO consumer);
    int modifyConsumerByName(ConsumerDTO consumer);
    int modifyConsumerByRank(ConsumerDTO consumer);
    int modifyConsumerByPhone(ConsumerDTO consumer);
}
