package com.hnust.system.mapper.impl;

import com.hnust.system.mapper.BaseMapper;
import com.hnust.system.mapper.StudentMapper;
import com.hnust.system.pojo.Student;

import java.util.List;

public class StudentMapperImpl extends BaseMapper implements StudentMapper {
    @Override
    public int insertStudent(Student student) {
        String sql = "insert into sys_student values(?,?,?,?,?,?,?)";
        int rows = 0;
        try {
            rows = baseUpdate(sql,
                    student.getStudentId(),
                    student.getName(),
                    student.getSex(),
                    student.getClazz(),
                    student.getDepartment(),
                    student.getBirthday(),
                    student.getNativePlace());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return rows;
        }


    }

    @Override
    public int updateStudent(Student newStudent) {
        String sql = "update sys_student " +
                "set name = ?, sex = ?, clazz = ?, department = ?, birthday = ?, native_place = ? " +
                "where studentid = ?";
        return baseUpdate(sql,newStudent.getName(),
                        newStudent.getSex(),
                        newStudent.getClazz(),
                        newStudent.getDepartment(),
                        newStudent.getBirthday(),
                        newStudent.getNativePlace(),
                        newStudent.getStudentId());
    }

    @Override
    public List<Object> findById(String studentId) {
        String sql = """
                select
                    studentid studentId,
                    name,
                    sex,
                    clazz,
                    department,
                    birthday,
                    native_place nativePlace
                from sys_student
                """;
        if(!studentId.isEmpty()){
            sql += "where studentid = ?";
            return baseQuery(Student.class,sql,studentId);
        }

        return baseQuery(Student.class,sql);
    }

    @Override
    public int deleteStudent(int id) {
        String sql = """
                delete from sys_student where studentid = ?
                """;
        return baseUpdate(sql,id);
    }

    @Override
    public Student selectByName(String name) {
        String sql = """
                select 
                    studentid studentId,
                    name,
                    sex,
                    clazz,
                    department,
                    birthday,
                    native_place nativePlace
                from sys_student
                where name = ?
                """;
        List<Object> objects = baseQuery(Student.class, sql, name);
        if(objects.isEmpty()){
            return null;
        }
        return (Student) objects.getFirst();
    }
}
