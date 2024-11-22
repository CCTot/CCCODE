package com.hnust.system.mapper;

import com.hnust.system.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     *  根据输入的学生信息对数据库中的表进行插入
     * @param student 需要插入的学生信息
     * @return 返回插入影响行数
     */
    int insertStudent(Student student);

    /**
     *  根据输入的学生信息进行更新修改
     * @param newStudent 输入的学生信息
     * @return 返回影响行数
     */
    int updateStudent(Student newStudent);

    /**
     * 根据学生Id查找学生的信息
     *
     * @param studentId 学生的id
     * @return 返回查询到的结果集
     */
    List<Object> findById(String studentId);

    /**
     *  根据学号删除学生对象
     * @param id 学生学号
     * @return 返回影响行数
     */
    int deleteStudent(int id);

    /**
     * 根据学生名字查找学生对象
     * @param name 学生名字
     * @return 返回学生信息封装的对象
     */
    Student selectByName(String name);
}
