package com.hnust.system.service;

import com.hnust.system.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 根据输入的学生信息进行插入
     * @param student 输入的学生信息封装成的Student对象
     * @return 返回插入影响行数
     */
    int insertStudent(Student student);

    /**
     * 根据输入学生信息进行数据修改
     * @param newStudent 输入的学生信息
     * @return 返回影响行数
     */
    int updateStudent(Student newStudent);

    /**
     * 根据学生studentId查找学生信息
     * @param studentId 学生的id
     * @return 返回查询到的结果集
     */
    List<Object> findById(String studentId);

    /**
     * 根据学号删除学生信息
     * @param id 学生学号
     * @return 返回影响行数
     */
    int deleteStudent(int id);

    /**
     * 根据名字查找学生对象
     * @param name 学生名字
     * @return 返回查询到的学生信息封装的对象
     */
    Student selectByName(String name);
}
