package com.example.login.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_info")
public class MyUser {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String aurhorized;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAurhorized() {
        return aurhorized;
    }

    public void setAurhorized(String aurhorized) {
        this.aurhorized = aurhorized;
    }
}
