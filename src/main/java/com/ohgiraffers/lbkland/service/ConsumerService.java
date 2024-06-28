package com.ohgiraffers.lbkland.service;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.mapper.ConsumerMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.lbkland.common.Template.getSqlSession;

public class ConsumerService {

    private ConsumerMapper consumerMapper;

    // 세션 만들어주기
    // 전체 고객 조회
    public List<ConsumerDTO> selectAllconsumer() {
        SqlSession sqlSession = getSqlSession();
        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        List<ConsumerDTO> consumerList = consumerMapper.selectAllConsumer();

        sqlSession.close();

        return consumerList;
    }

    public ConsumerDTO selectConsumerById(String id) {
        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        ConsumerDTO consumer = consumerMapper.selectConsumerById(id);

        sqlSession.close();

        return consumer;
    }

    public boolean registerConsumer(ConsumerDTO consumer) {
        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        int result = consumerMapper.insertConsumer(consumer);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean registerConsumer1(ConsumerDTO consumer) {
        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        int result = consumerMapper.insertConsumer1(consumer);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyConsumer(ConsumerDTO consumer) {

        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        int result = consumerMapper.modifyConsumer(consumer);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;


    }

    public boolean deleteConsumer(String id) {

        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        int result = consumerMapper.deleteConsumer(id);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyConsumerByStaff(ConsumerDTO consumer) {
        SqlSession sqlSession = getSqlSession();

        consumerMapper = sqlSession.getMapper(ConsumerMapper.class);

        int result = consumerMapper.modifyConsumerByStaff(consumer);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
