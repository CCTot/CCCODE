package com.hnust.system.pojo;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String identity;


    public User() {
    }

    public User(Integer uid, String username, String password, String identity) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    /**
     * 获取
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return identity
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 设置
     * @param identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String toString() {
        return "User{uid = " + uid + ", username = " + username + ", password = " + password + ", identity = " + identity + "}";
    }
}
