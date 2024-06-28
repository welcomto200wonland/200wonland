package com.ohgiraffers.lbkland.service;

import com.ohgiraffers.lbkland.dto.ConsumerDTO;
import com.ohgiraffers.lbkland.dto.StaffDTO;
import com.ohgiraffers.lbkland.mapper.ConsumerLoginMapper;
import com.ohgiraffers.lbkland.mapper.StaffLoginMapper;
import org.apache.ibatis.session.SqlSession;
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

    public boolean tryVipLogin(ConsumerDTO consumer) {

        SqlSession sqlSession =getSqlSession();

        consumerLoginMapper = sqlSession.getMapper(ConsumerLoginMapper.class);

        // 입력받은 id로 회원 한명의 정보를 가져오기
        ConsumerDTO foundConsumer = consumerLoginMapper.findConsumerById(consumer.getConsumerId());

        // 찾아온 회원의 비밀번호와 입력받은 비밀번호가 일치하는지 확인
        boolean result = foundConsumer.getConsumerPw().equals(consumer.getConsumerPw());

        // VIP면 로그인 한다 ?
         if(foundConsumer.getConsumerRank().equals("VIP")){
             System.out.println("VIP 고객님 환영합니다.");
         } else {
             System.out.println("VIP 고객이 아닙니다.");
         }

        sqlSession.close();

        return result;

    }
}
