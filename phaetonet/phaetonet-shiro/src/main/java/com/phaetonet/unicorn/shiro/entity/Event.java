package com.phaetonet.unicorn.shiro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_shiro_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "rawEventId", length = 10)
    private Integer rawEventId;

    @Column(name = "host", length = 50)
    private String host;

    @Column(name = "ip", length = 20)
    private String ip;

    @Column(name = "source", length = 100)
    private String source;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "startTime")
    private Date startTime;

    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "content", length = 2000)
    private String content;

    @Column(name = "dataType", length = 50)
    private String dataType;

    @Column(name = "suggest", length = 200)
    private String suggest;

    @Column(name = "businessSystemId", length = 10)
    private Integer businessSystemId;

    @Column(name = "departmentId", length = 10)
    private Integer departmentId;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "occurCount", length = 10)
    private Integer occurCount;

    @Column(name = "owner", length = 20)
    private String owner;

    @Column(name = "responsedTime")
    private Date responsedTime;

    @Column(name = "responsedBy", length = 20)
    private String responsedBy;

    @Column(name = "resolvedTime")
    private Date resolvedTime;

    @Column(name = "resolvedBy", length = 10)
    private String resolvedBy;

    @Column(name = "closedTime")
    private Date closedTime;

    @Column(name = "closedBy", length = 10)
    private String closedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRawEventId() {
        return rawEventId;
    }

    public void setRawEventId(Integer rawEventId) {
        this.rawEventId = rawEventId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Integer getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(Integer businessSystemId) {
        this.businessSystemId = businessSystemId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOccurCount() {
        return occurCount;
    }

    public void setOccurCount(Integer occurCount) {
        this.occurCount = occurCount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getResponsedTime() {
        return responsedTime;
    }

    public void setResponsedTime(Date responsedTime) {
        this.responsedTime = responsedTime;
    }

    public String getResponsedBy() {
        return responsedBy;
    }

    public void setResponsedBy(String responsedBy) {
        this.responsedBy = responsedBy;
    }

    public Date getResolvedTime() {
        return resolvedTime;
    }

    public void setResolvedTime(Date resolvedTime) {
        this.resolvedTime = resolvedTime;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public Date getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", rawEventId=" + rawEventId +
                ", host=" + host +
                ", ip=" + ip +
                ", source=" + source +
                ", type=" + type +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", content=" + content +
                ", dataType=" + dataType +
                ", suggest=" + suggest +
                ", businessSystemId=" + businessSystemId +
                ", departmentId=" + departmentId +
                ", status=" + status +
                ", occurCount=" + occurCount +
                ", owner=" + owner +
                ", responsedTime=" + responsedTime +
                ", responsedBy=" + responsedBy +
                ", resolvedTime=" + resolvedTime +
                ", resolvedBy=" + resolvedBy +
                ", closedTime=" + closedTime +
                ", closedBy=" + closedBy +
                '}';
    }
}