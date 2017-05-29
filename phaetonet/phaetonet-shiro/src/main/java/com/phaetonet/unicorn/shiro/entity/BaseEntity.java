package com.phaetonet.unicorn.shiro.entity;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/29.
 */
public class BaseEntity {

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
}
