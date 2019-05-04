package com.tourist.module.lijiangnew.dto;

/**
 * @author admin 2019-05-01 16:39
 */
public class AccountNumberDto {
    private String userName;
    private String password;

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

    public AccountNumberDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
