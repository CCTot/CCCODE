package com.hnust.system.service.impl;

import com.hnust.system.mapper.RewardMapper;
import com.hnust.system.mapper.impl.RewardMapperImpl;
import com.hnust.system.pojo.vo.RewardVo;
import com.hnust.system.service.RewardService;

import java.util.List;

public class RewardServiceImpl implements RewardService {

    private final RewardMapper rewardMapper = new RewardMapperImpl();

    @Override
    public int insertReward(RewardVo rewardVo) {
        return rewardMapper.insertReward(rewardVo);
    }

    @Override
    public List<Object> findAllRewards() {
        return rewardMapper.findAllRewards();
    }

    @Override
    public int deleteById(int id) {
        return rewardMapper.deleteById(id);
    }
}
