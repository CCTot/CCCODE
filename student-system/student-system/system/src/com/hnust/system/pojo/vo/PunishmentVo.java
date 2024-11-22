package com.hnust.system.pojo.vo;

import java.util.Date;

public class PunishmentVo {
    private Integer id;
    private String studentId;
    private Integer levels;
    private Date recTime;
    private String enable;
    private String description;


    public PunishmentVo() {
    }

    public PunishmentVo(Integer id, String studentId, Integer levels, Date recTime, String enable, String description) {
        this.id = id;
        this.studentId = studentId;
        this.levels = levels;
        this.recTime = recTime;
        this.enable = enable;
        this.description = description;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取
     * @return levels
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * 设置
     * @param levels
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * 获取
     * @return recTime
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 设置
     * @param recTime
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * 获取
     * @return enable
     */
    public String getEnable() {
        return enable;
    }

    /**
     * 设置
     * @param enable
     */
    public void setEnable(String enable) {
        this.enable = enable;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "PunishmentVo{id = " + id + ", studentId = " + studentId + ", levels = " + levels + ", recTime = " + recTime + ", enable = " + enable + ", description = " + description + "}";
    }
}
