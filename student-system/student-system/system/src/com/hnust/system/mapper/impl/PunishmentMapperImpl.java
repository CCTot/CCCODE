package com.hnust.system.mapper.impl;

import com.hnust.system.mapper.BaseMapper;
import com.hnust.system.mapper.PunishmentMapper;
import com.hnust.system.pojo.vo.PunishmentVo;

import java.util.List;

public class PunishmentMapperImpl extends BaseMapper implements PunishmentMapper {

    @Override
    public int insertPunishment(PunishmentVo punishmentVo) {
        String sql = "insert into sys_punishment values(default,?,?,now(),?,?)";
        return baseUpdate(sql,punishmentVo.getStudentId(),
                            punishmentVo.getLevels(),
                            punishmentVo.getEnable(),
                            punishmentVo.getDescription());
    }

    @Override
    public List<Object> findAllPunishments() {
        String sql = """
                select 
                    id,
                    studentid studentId,
                    levels,
                    rec_time recTime,
                    enable,
                    description
                from sys_punishment
                """;
        return baseQuery(PunishmentVo.class,sql);
    }

    @Override
    public int deleteById(int id) {
        String sql = """
                delete from sys_punishment where id = ?
                """;
        return baseUpdate(sql,id);
    }
}
