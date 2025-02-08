package com.tutu.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2025-02-05 11:24
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;
}
