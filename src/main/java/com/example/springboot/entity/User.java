package com.example.springboot.entity;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = -4042714106942627858L;

    @NotEmpty(message = "用户名不能为空")
    @Length(min = 6,max = 12,message = "用户名长度必须位于6到12之间" )
    private String userName;

    @NotEmpty(message = "密码不能位空")
    @Length(min = 6,message = "密码长度不能小于6位")
    private String passWord;

    @Email(message = "请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证格式错误")
    private String idCard;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}

