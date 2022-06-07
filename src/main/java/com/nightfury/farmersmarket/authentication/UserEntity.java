package com.nightfury.farmersmarket.authentication;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "userSequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "userSequence")
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USER_NAME")
    private String userName;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
