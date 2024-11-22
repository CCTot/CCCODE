package com.hnust.system.service;

import com.hnust.system.pojo.vo.PunishmentVo;

import java.util.List;

public interface PunishmentService {


    /**
     *  根据输入的信息添加处分的方法
     * @param punishmentVo 新的处分记录
     * @return 返回影响的行数
     */
    int insertPunishment(PunishmentVo punishmentVo);

    /**
     *  查询所有处罚记录并返回
     * @return 返回所有的处罚记录，并且使用list集合封装。
     */
    List<Object> finAllPunishments();

    /**
     * 根据id记录号删除数据库中表中的处罚记录
     * @param id 要删除的记录的id
     * @return 返回影响行数
     */
    int deleteById(int id);
}
