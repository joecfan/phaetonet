package com.phaetonet.feilong.entity;

import javax.persistence.*;
import com.phaetonet.unicorn.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/22.
 */
@Entity
@Table(name = "t_fl_trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "idNo", length = 20)
    private String idNo;

    @Column(name = "schoolName", length = 100)
    private String schoolName;

    @Column(name = "teacher", length = 10)
    private String teacher;

    @Column(name = "registryDate")
    private Date registryDate;

    @Column(name = "amount", columnDefinition = "decimal(7,2)")
    private BigDecimal amount;

    @Column(name = "imgUrl", length = 100)
    private String imgUrl;

    @Column(name = "extInfo", length = 500)
    private String extInfo;


    @Column(name = "updateTime")
    private Date updateTime;

    @Column(name = "insertTime")
    private Date insertTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        if (updateTime == null) {
            updateTime = new Date();
        }
        this.updateTime = updateTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        if (insertTime == null) {
            insertTime = new Date();
        }
        this.insertTime = insertTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
