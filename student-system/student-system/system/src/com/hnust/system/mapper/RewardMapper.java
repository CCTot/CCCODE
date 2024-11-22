package com.hnust.system.mapper;

import com.hnust.system.pojo.vo.RewardVo;

import java.util.List;

public interface RewardMapper {

    /**
     * 查找数据库表中所有的奖励记录
     * @return 返回所有的奖励记录，以集合形式返回
     */
    List<Object> findAllRewards();

    /**
     * 根据传入的信息插入一条新的奖励记录
     * @param rewardVo 奖励记录
     * @return 返回影响行数
     */
    int insertReward(RewardVo rewardVo);

    /**
     * 根据记录号id删除数据库表中的奖励记录
     * @param id 记录号
     * @return 返回影响行数
     */
    int deleteById(int id);
}
