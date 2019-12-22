package com.lanjchenx.module.lijiangnew.dto;

import java.util.List;

/**
 * @author admin 2019-05-04 17:36
 */
public class PeopleDto {

    private String userName;
    private String status;
    private List<User> userList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public static class User {
        private String name;
        private String idCard;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }
    }

}
