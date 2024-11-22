package com.hnust.system.service.impl;

import com.hnust.system.mapper.StudentMapper;
import com.hnust.system.mapper.impl.StudentMapperImpl;
import com.hnust.system.pojo.Student;
import com.hnust.system.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper = new StudentMapperImpl();
    @Override
    public int insertStudent(Student student) {
        if(student.getStudentId() != null
                && student.getName() != null
                && student.getSex() != null
                && student.getBirthday() != null
                && student.getClazz() != null
                && student.getDepartment() != null
                && student.getNativePlace() != null){
            //调用mapper层进行数据插入
            return studentMapper.insertStudent(student);
        }else{
            return 0;
        }


    }

    @Override
    public int updateStudent(Student newStudent) {
        return studentMapper.updateStudent(newStudent);
    }

    @Override
    public List<Object> findById(String studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Student selectByName(String name) {
        return studentMapper.selectByName(name);
    }
}
