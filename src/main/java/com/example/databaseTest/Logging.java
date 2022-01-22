package com.example.databaseTest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="logging")
@IdClass(LoggindId.class)
public class Logging implements Serializable {

    @Id
//    @ManyToOne
//    @JoinColumn(name="username")
    private String username;
    @Id
    private Date timestamp;



    public Logging(String username, Date timestamp) {
        this.username = username;
        this.timestamp = timestamp;
    }

    public Logging() {
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
}
