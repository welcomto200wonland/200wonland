package com.ohgiraffers.lbkland.service;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.dto.StaffDTO;
import com.ohgiraffers.lbkland.mapper.ConsumerLoginMapper;
import com.ohgiraffers.lbkland.mapper.StaffLoginMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.ohgiraffers.lbkland.common.Template.getSqlSession;

public class LoginService {
    private ConsumerLoginMapper consumerLoginMapper;
    private StaffLoginMapper staffLoginMapper;

    public boolean tryConsumerLogin(ConsumerDTO consumer) {

        SqlSession sqlSession =getSqlSession();

        consumerLoginMapper = sqlSession.getMapper(ConsumerLoginMapper.class);

        // 입력받은 id로 회원 한명의 정보를 가져오기
        ConsumerDTO foundConsumer = consumerLoginMapper.findConsumerById(consumer.getConsumerId());

        // 찾아온 회원의 비밀번호와 입력받은 비밀번호가 일치하는지 확인
        boolean result = foundConsumer.getConsumerPw().equals(consumer.getConsumerPw());

        sqlSession.close();

        return result;
    }

    public boolean tryStaffLogin(StaffDTO staff) {

        SqlSession sqlSession = getSqlSession();

        staffLoginMapper = sqlSession.getMapper(StaffLoginMapper.class);

        StaffDTO foundStaff = staffLoginMapper.findStaffById(staff.getStaffId());

        boolean result = foundStaff.getStaffPassword().equals(staff.getStaffPassword());

        sqlSession.close();

        return result;
    }

    // VIP 회원의 로그인
    // VIP 회원이 로그인 <-> 일반회원 로그인 차이(RANK가 다름, VIP의 메뉴를 보여주고싶음)
    public Map<String, Boolean> tryVipLogin(ConsumerDTO consumer) {

        SqlSession sqlSession =getSqlSession();

        consumerLoginMapper = sqlSession.getMapper(ConsumerLoginMapper.class);

        // 입력받은 id로 회원 한명의 정보를 가져오기
        ConsumerDTO foundConsumer = consumerLoginMapper.findConsumerById(consumer.getConsumerId());

        // 찾아온 회원의 비밀번호와 입력받은 비밀번호가 일치하는지 확인
        boolean loginResult = foundConsumer.getConsumerPw().equals(consumer.getConsumerPw());
        boolean isVIP = foundConsumer.getConsumerRank().equals("VIP");

        // 입력한 애가 VIP인지 아닌지
        // VIP인지 아닌지 결과를 담는 변수

        Map<String, Boolean> result = new HashMap<>();

        result.put("loginResult", loginResult);
        result.put("isVIP", isVIP);


        sqlSession.close();

        return result;

    }
}
