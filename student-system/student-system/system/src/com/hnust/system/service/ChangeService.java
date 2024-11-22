package com.hnust.system.service;

import com.hnust.system.pojo.vo.ChangeVo;

import java.util.List;

public interface ChangeService {

    /**
     * 实现学生学籍信息修改的业务
     * @param changeVo 新的学生学籍信息
     * @return 返回影响行数
     */
    int updateStudentStatus(ChangeVo changeVo);

    /**
     * 查询所有的学籍变更信息
     * @return 返回查询到的信息，以list集合形式返回
     */
    List<Object> findChange();

    /**
     * 根据记录号id删除一条记录
     * @param id 记录号
     * @return 返回影响行数
     */
    int deleteById(Integer id);
}
