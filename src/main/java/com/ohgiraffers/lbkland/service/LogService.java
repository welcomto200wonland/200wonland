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

    public LogDTO selectLogByCode(String code) {

        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        LogDTO log = logMapper.selectLogByCode(code);

        sqlSession.close();

        return log;
    }

    public LogDTO selectLogByStaffId(String staId) {

        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        LogDTO log = logMapper.selectLogByStaffId(staId);

        sqlSession.close();

        return log;
    }

    public boolean registerLog(LogDTO log) {
        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        int result = logMapper.insertLog(log);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyLog(LogDTO log) {

        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        int result = logMapper.modifyLog(log);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteLog(String code) {

        SqlSession sqlSession = getSqlSession();

        logMapper = sqlSession.getMapper(LogMapper.class);

        int result = logMapper.deleteLog(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }
}
