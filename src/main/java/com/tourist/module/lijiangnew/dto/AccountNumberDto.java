package com.tourist.module.lijiangnew.dto;

/**
 * @author admin 2019-05-01 16:39
 */
public class AccountNumberDto {
    private String userName;
    private String password;
    private String validate;

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

    public String getValidate() {
        return validate;
    }

    public void setValidate(String password) {
        this.validate = validate;
    }

    public AccountNumberDto(String userName, String password, String validate) {
        this.userName = userName;
        this.password = password;
        this.validate = validate;
    }
}
