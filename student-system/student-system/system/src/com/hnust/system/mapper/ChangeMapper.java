package com.hnust.system.mapper;

import com.hnust.system.pojo.vo.ChangeVo;

import java.lang.invoke.CallSite;
import java.util.List;

public interface ChangeMapper {

    /**
     * 查询所有学籍变更信息
     * @return 返回查询结果
     */
    List<Object> findChange();

    /**
     * 实现对数据库的数据更新
     * @param changeVo 新的学生学籍变化信息
     * @return 返回影响行数
     */
    int updateStudentStatus(ChangeVo changeVo);

    /**
     * 根据对应的Id记录号删除对应的学籍修改记录
     * @param id 学籍修改表中的记录号
     * @return 返回影响的行数
     */
    int deleteById(Integer id);
}
