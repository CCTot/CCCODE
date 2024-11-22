package com.hnust.system.service;

import com.hnust.system.pojo.vo.RewardVo;

import java.util.List;

public interface RewardService {

    /**
     *  根据输入的信息插入一条奖励信息
     * @param rewardVo 输入的奖励信息封装的对象
     * @return 返回影响的行数
     */
    int insertReward(RewardVo rewardVo);

    /**
     * 查询所有的学生奖励记录
     * @return 返回所有的学生奖励记录，并且用List集合封装
     */
    List<Object> findAllRewards();


    /**
     * 根据记录号删除对应的奖励记录
     * @param id 记录号
     * @return 返回影响行数
     */
    int deleteById(int id);
}
