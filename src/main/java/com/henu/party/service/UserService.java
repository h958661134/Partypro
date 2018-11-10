package com.henu.party.service;

import com.henu.party.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 返回现在存在的所有的用户信息
     * @return 所有用户信息
     */
    public List<UserInfo> getAllUserInfo();

    /**
     * @param name 将要查询的用户姓名
     * @return 返回所查询的用户
     */
    public List<UserInfo> getUserInfo(String name);

    /**
     * @param partyState 代表入党状态的数字
     * @return 返回对应状态的所有用户信息
     */
    public List<UserInfo> getUserByPartyState(String partyState);

    /**
     * 通过党支部名称查询对应的用户
     * @param PartyBranchName 党支部名字
     * @return 返回所有查询到的用户信息
     */
    public List<UserInfo> getByPartyBranchName(String PartyBranchName);

    /**
     * 添加一个用户
     * @param userInfo 用户信息实例
     * @return 返回是否成功
     */
    public boolean insertUser(UserInfo userInfo);

    /**
     * 通过学号删除用户信息
     * @param userName 用户学号
     * @return 返回是否成功
     */
    public boolean delateUser(String userName,int state);
}
