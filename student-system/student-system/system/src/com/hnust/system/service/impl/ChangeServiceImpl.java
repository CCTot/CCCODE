package com.hnust.system.service.impl;

import com.hnust.system.mapper.ChangeMapper;
import com.hnust.system.mapper.impl.ChangeMapperImpl;
import com.hnust.system.pojo.vo.ChangeVo;
import com.hnust.system.service.ChangeService;

import java.util.List;

public class ChangeServiceImpl implements ChangeService {

    private final ChangeMapper changeMapper = new ChangeMapperImpl();

    @Override
    public int updateStudentStatus(ChangeVo changeVo) {
        return changeMapper.updateStudentStatus(changeVo);

    }

    @Override
    public List<Object> findChange() {
        return changeMapper.findChange();
    }

    @Override
    public int deleteById(Integer id) {
        return changeMapper.deleteById(id);
    }
}
