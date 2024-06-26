package com.ohgiraffers.lbkland.service;

import com.ohgiraffers.lbkland.dto.LogDTO;
import com.ohgiraffers.lbkland.mapper.LogMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.lbkland.common.Template.getSqlSession;

public class LogService {

    private LogMapper logMapper;

    public List<LogDTO> selectAllLog() {

        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        List<LogDTO> logList = logMapper.selectAllLog();

        sqlSession.close();

        return logList;
    }
}
