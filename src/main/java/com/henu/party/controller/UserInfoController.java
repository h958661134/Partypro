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

    /**
     * 根据复选框查询条件 以及输入查询内容进行查询
     * @param searchStatus 输入框传回条件
     * @param selectName 查询项
     * @return
     */
    @RequestMapping("/user/search")
    public List<UserInfo> SearchInfo(String searchStatus,String selectName){
        System.out.println(searchStatus + " " + selectName);
        if(searchStatus.equals("0")){
            return userService.getByPartyBranchName(selectName);
        }else{
            return userService.getUserInfo(selectName);
        }
    }

    @RequestMapping("/user/detail")
    public UserInfo getUser(String userName){
        return userService.getAUserInfo(userName);
    }

    /**
     * 添加新的用户信息
     * @param userInfo 添加的用户信息实体
     */
    @RequestMapping("/user/addUserInfo")
    public boolean AddUserInfo(UserInfo userInfo){

        return true;
    }

    /**
     * 修改用户信息
     * @param userInfo 修改用户的实体
     * @return
     */
    @RequestMapping("/user/update")
    public boolean updateUserInfo(UserInfo userInfo){

        return true;
    }

    /**
     * 删除用户信息
     * @param userInfo 删除用户的实体
     * @return
     */
    @RequestMapping("/user/delete")
    public boolean deleteUserInfo(UserInfo userInfo){

        return true;
    }

    /**
     *根据id进行批量删除
     * @param list 选中用户的账号
     * @return
     */
    @RequestMapping("/user/deleteAll")
    public boolean deleteAllSelect(List list){

        return true;
    }

    /**
     * 批量更新现在入党状态
     * @param list 所有需要修改的id的集合
     * @return
     */
    @RequestMapping("/user/updateAll")
    public boolean updateSelectAll(List list){

        return true;
    }
}
