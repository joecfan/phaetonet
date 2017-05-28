package com.phaetonet.unicorn.shiro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_shiro_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "userCode", length = 20)
    private String userCode;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "userName", length = 20)
    private String userName;

    @Transient
    private boolean remberMe;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "wechatId", length = 20)
    private String wechatId;

    @Column(name = "qq", length = 20)
    private String qq;

    @Column(name = "invalidLogin", length = 2, columnDefinition="INT default 0",nullable=false)
    private Integer invalidLogin;

    @Column(name = "extInfo", length = 2000)
    private String extInfo;

    @Column(name = "loginIp" , length = 50)
    private String loginIp;

    @Column(name = "createdBy" , length = 20)
    private String createdBy;

    @Column(name = "loginTime")
    private Date loginTime;

    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "insertTime")
    private Date insertTime;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getInvalidLogin() {
        return invalidLogin;
    }

    public void setInvalidLogin(Integer invalidLogin) {
        this.invalidLogin = invalidLogin;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean getRemberMe() {
        return remberMe;
    }

    public void setRemberMe(boolean remberMe) {
        this.remberMe = remberMe;
    }

    public boolean isRemberMe() {
        return remberMe;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}