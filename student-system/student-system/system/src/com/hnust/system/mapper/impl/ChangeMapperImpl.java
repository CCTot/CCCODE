package com.hnust.system.mapper.impl;

import com.hnust.system.mapper.BaseMapper;
import com.hnust.system.mapper.ChangeMapper;
import com.hnust.system.pojo.vo.ChangeVo;

import java.sql.SQLData;
import java.util.List;

public class ChangeMapperImpl extends BaseMapper implements ChangeMapper {
    @Override
    public List<Object> findChange() {
        String sql = """
                select
                    id,
                    studentid studentId,
                    `change`,
                    rec_time recTime,
                    description
                from sys_change;
                """;

        return baseQuery(ChangeVo.class,sql);
    }

    @Override
    public int updateStudentStatus(ChangeVo changeVo) {
        String sql = """
                insert into sys_change values(default,?,?,now(),?);
                """;

        return baseUpdate(sql,changeVo.getStudentId(),changeVo.getChange(),changeVo.getDescription());
    }

    @Override
    public int deleteById(Integer id) {
        String sql = """
                delete from sys_change where id = ?
                """;
        return baseUpdate(sql,id);
    }
}
