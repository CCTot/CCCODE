package com.hnust.system.service.impl;

import com.hnust.system.mapper.PunishmentMapper;
import com.hnust.system.mapper.impl.PunishmentMapperImpl;
import com.hnust.system.service.PunishmentService;
import com.hnust.system.pojo.vo.PunishmentVo;

import java.util.List;

public class PunishmentServiceImpl implements PunishmentService {

    private final PunishmentMapper punishmentMapper = new PunishmentMapperImpl();

    @Override
    public int insertPunishment(PunishmentVo punishmentVo)  {
        return punishmentMapper.insertPunishment(punishmentVo);
    }

    @Override
    public List<Object> finAllPunishments() {
        return punishmentMapper.findAllPunishments();
    }

    @Override
    public int deleteById(int id) {
        return punishmentMapper.deleteById(id);
    }
}
