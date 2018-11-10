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

    /**
     * 根据当前入党状态查询对应人员
     * @param type
     * @return
     */
    @RequestMapping("/user/SelectByInfo")
    public List<UserInfo> SelectByInfo(String type){
        return userService.getUserByPartyState(type);
    }

    @RequestMapping("/user/search")
    public List<UserInfo> SearchInfo(String searchStatus,String selectName){
        System.out.println(searchStatus + " " + selectName);
        if(searchStatus.equals("0")){
            return userService.getByPartyBranchName(selectName);
        }else{
            return userService.getUserInfo(selectName);
        }
    }
}
