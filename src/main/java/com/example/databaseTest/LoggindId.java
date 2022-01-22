package com.example.databaseTest;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LoggindId implements Serializable {
    private String username;
    private Date timestamp;

    public LoggindId(String username, Date timestamp) {
        this.username = username;
        this.timestamp = timestamp;
    }

    public LoggindId() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LoggindId loggindId = (LoggindId) object;
        return this.timestamp.equals(loggindId.timestamp) && this.username.equals(loggindId.username);
    }

    @Override
    public int hashCode(){
        return Objects.hash(username,timestamp);
    }
}
