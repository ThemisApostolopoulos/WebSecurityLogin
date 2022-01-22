package com.example.databaseTest;

import javax.persistence.*;
import java.util.ArrayList;
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

//    @OneToMany(mappedBy = "users")
//    private HashSet<Logging> loggings = new HashSet<>();

    public User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
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
}
