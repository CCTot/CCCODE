package com.hnust.system.pojo.vo;

import java.util.Date;

public class ChangeVo {
    private Integer id;
    private String studentId;
    private Integer change;
    private Date recTime;
    private String description;

    public ChangeVo() {
    }

    public ChangeVo(Integer id, String studentId, Integer change, Date recTime, String description) {
        this.id = id;
        this.studentId = studentId;
        this.change = change;
        this.recTime = recTime;
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
     * @return change
     */
    public Integer getChange() {
        return change;
    }

    /**
     * 设置
     * @param change
     */
    public void setChange(Integer change) {
        this.change = change;
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
        return "ChangeVo{id = " + id + ", studentId = " + studentId + ", change = " + change + ", recTime = " + recTime + ", description = " + description + "}";
    }
}
