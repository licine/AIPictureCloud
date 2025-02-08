package com.tutu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tutu.model.dto.user.UserQueryRequest;
import com.tutu.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tutu.model.vo.LoginUserVO;
import com.tutu.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author llllle
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-02-05 10:43:59
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    String getEncryptPassword(String userPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);



    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);





    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);



    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);


    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);



    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);








}
