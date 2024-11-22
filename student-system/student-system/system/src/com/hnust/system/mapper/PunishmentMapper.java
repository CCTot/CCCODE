package com.hnust.system.mapper;

import com.hnust.system.pojo.vo.PunishmentVo;

import java.util.List;

public interface PunishmentMapper {

    /**
     * 根据输入的处罚信息进行数据库的插入
     * @param punishmentVo 输入的处罚信息封装的Vo对象
     * @return 返回影响的行数
     */
    int insertPunishment(PunishmentVo punishmentVo);

    /**
     * 查询所有的处罚记录
     * @return 返回所有的处罚记录，并且是以集合形式返回
     */
    List<Object> findAllPunishments();

    /**
     * 根据id删除对应的记录号
     * @param id 要删除的记录号
     * @return 返回影响行数
     */
    int deleteById(int id);
}
