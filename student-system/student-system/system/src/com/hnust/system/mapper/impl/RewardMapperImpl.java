package com.hnust.system.mapper.impl;

import com.hnust.system.mapper.BaseMapper;
import com.hnust.system.mapper.RewardMapper;
import com.hnust.system.pojo.vo.RewardVo;

import java.util.List;

public class RewardMapperImpl extends BaseMapper implements RewardMapper {
    @Override
    public List<Object> findAllRewards() {
        String sql = """
                select 
                    id,
                    studentid studentId,
                    levels,
                    rec_time recTime,
                    description
                from sys_reward
                """;
        return baseQuery(RewardVo.class, sql);
    }

    @Override
    public int insertReward(RewardVo rewardVo) {
        String sql = """
                insert into sys_reward values(default,?,?,now(),?)
                """;
        return baseUpdate(sql,rewardVo.getStudentId(),rewardVo.getLevels(),rewardVo.getDescription());
    }

    @Override
    public int deleteById(int id) {
        String sql = """
                delete from sys_reward where id = ?
                """;
        return baseUpdate(sql,id);
    }
}
