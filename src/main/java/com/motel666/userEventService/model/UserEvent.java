package com.motel666.userEventService.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String type;

    //  This is unix epoch time
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private String context;

    public UserEvent() {}

    public UserEvent(String userName) {
        this.userName = userName;
    }

    public UserEvent(Long userId, String userName, String type, Date timestamp, String context) {
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.timestamp = timestamp;
        this.context = context;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContext() {
        return context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
