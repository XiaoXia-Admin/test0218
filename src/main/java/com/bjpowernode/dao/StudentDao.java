package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

//这是一个接口我们要操作student表
public interface StudentDao {
    //查询student表中的所有数据
    public List<Student> selectStudents();
    //添加insert数据
    public int insertStudent(Student student);
}
