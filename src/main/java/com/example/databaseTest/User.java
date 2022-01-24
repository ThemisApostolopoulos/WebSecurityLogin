package com.example.databaseTest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name="users")
public class User {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String description;

    @Column
    private int failedAttempts;

    @Column
    private boolean accountLocked;

    @Column
    private Date lockTime;

    @Column
    private Date passwordSet;

//    @OneToMany(mappedBy = "users")
//    private HashSet<Logging> loggings = new HashSet<>();

    public User(String username, String password, String description, int failedAttempts, boolean accountLocked,Date passwordSet) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.failedAttempts = failedAttempts;
        this.accountLocked = accountLocked;
        this.passwordSet = passwordSet;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.description ="user";
        this.failedAttempts = 0;
        this.accountLocked = false;
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Date getPasswordSet() {
        return passwordSet;
    }

    public void setPasswordSet(Date passwordSet) {
        this.passwordSet = passwordSet;
    }
}
