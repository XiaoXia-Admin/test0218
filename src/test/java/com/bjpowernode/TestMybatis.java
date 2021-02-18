package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MybatisUtil;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口的)
     * getMapper()能获取dao接口对于的实现类对象。
     */
    @Test
    public void testSelectStudents(){

        SqlSession sqlSession= MybatisUtil.getSqlSession();

        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //调用dao的方法来执行数据库的操作
        List<Student> list=dao.selectStudents();
        for(Student l:list){
            System.out.println("学生:"+l);
        }
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student(1006,"盾山","dunshan@163.com",30);
        int num=dao.insertStudent(student);
        System.out.println("执行结果num="+num);
        System.out.println("哈哈");
    }

}
