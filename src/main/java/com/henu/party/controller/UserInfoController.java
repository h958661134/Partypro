package com.henu.party.controller;

import com.henu.party.bean.UserInfo;
import com.henu.party.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: YangWuXin
 * @Date: 2018/11/9 16:01
 */
@RestController
public class UserInfoController {
    @Autowired
    UserService userService;

    @RequestMapping("/User/UserInfo")
    public List<UserInfo> UserInfo(){
        return userService.getAllUserInfo();
    }
}
