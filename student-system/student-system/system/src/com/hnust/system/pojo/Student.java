package com.hnust.system.pojo;

import java.util.Date;

public class Student {
    private String studentId;
    private String name;
    private String sex;
    private Integer clazz;
    private Integer department;
    private Date birthday;
    private String nativePlace;

    public Student() {
    }

    public Student(String studentId, String name, String sex, Integer clazz, Integer department, Date birthday, String nativePlace) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.clazz = clazz;
        this.department = department;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return clazz
     */
    public Integer getClazz() {
        return clazz;
    }

    /**
     * 设置
     * @param clazz
     */
    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    /**
     * 获取
     * @return department
     */
    public Integer getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(Integer department) {
        this.department = department;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return nativePlace
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置
     * @param nativePlace
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String toString() {
        return "Student{studentId = " + studentId + ", name = " + name + ", sex = " + sex + ", clazz = " + clazz + ", department = " + department + ", birthday = " + birthday + ", nativePlace = " + nativePlace + "}";
    }
}
