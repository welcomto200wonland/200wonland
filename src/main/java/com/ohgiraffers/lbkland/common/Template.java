package com.ohgiraffers.lbkland.common;

import com.ohgiraffers.lbkland.mapper.LogMapper;
import com.ohgiraffers.lbkland.mapper.RideMapper;
import com.ohgiraffers.lbkland.mapper.StaffMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/land_db";
    private static String USER = "ohgeraffers";
    private static String PASSWORD ="ohgeraffers";

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            Environment environment = new Environment("dev",new JdbcTransactionFactory()
                    ,new PooledDataSource(DRIVER,URL,USER,PASSWORD));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(RideMapper.class);
            configuration.addMapper(StaffMapper.class);
            configuration.addMapper(LogMapper.class);


            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);

    }



}
