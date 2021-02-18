package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory=null;
    //因为SQLSessionFactory创建耗费资源还耗费时间，因为有一个就行了所以创建静态代码块。
    static{
        String config="mybatis.xml";//需要和你的项目文件名一样
        try {
            InputStream in= Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            factory=builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory != null) {
            sqlSession=factory.openSession(true);//自动提交事务
        }
        return sqlSession;
    }
}
