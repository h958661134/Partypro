package com.henu.party.service.impl;

import com.henu.party.bean.UserInfo;
import com.henu.party.mapper.UserInfoMapper;
import com.henu.party.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Description: 用户信息实现类
 * @Author: YangHongJian
 * @Date: 2018-11-1 17:10:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserInfoMapper userInfoMapper;

    /**
     * 返回现在存在的所有的用户信息
     * @return 所有用户信息
     */
    @Override
    public List<UserInfo> getAllUserInfo() {

        return userInfoMapper.selectAllUserInfo();
    }

    /**
     * @param name 将要查询的用户姓名
     * @return 返回所查询的用户
     */
    @Override
    public List<UserInfo> getUserInfo(String name,int state) {

        return userInfoMapper.selectByUserName(name,state);
    }

    /**
     * @param partyState 代表入党状态的数字
     * @return 返回对应状态的所有用户信息
     */
    @Override
    public List<UserInfo> getUserByPartyState(int partyState) {

        return userInfoMapper.selectMemberInfo(partyState);
    }

    /**
     * 通过党支部名称查询对应的用户
     *
     * @param PartyBranchName 党支部名字
     * @return 返回所有查询到的用户信息
     */
    @Override
    public List<UserInfo> getByPartyBranchName(String PartyBranchName,int state) {

        return userInfoMapper.selectByPartyBranch(PartyBranchName,state);
    }

    /**
     * 添加一个用户
     *
     * @param userInfo 用户信息实例
     * @return 返回是否成功
     */
    @Override
    public boolean insertUser(UserInfo userInfo) {
        if(userInfo != null){
            userInfoMapper.insertUser(userInfo);
            return true;
        }else
            return false;
    }

    /**
     * 通过学号删除用户信息
     * @param userName 用户学号
     * @return 返回是否成功
     */
    @Override
    public boolean delateUser(String userName,int state) {
        if(userInfoMapper.selectByUserName(userName,state)!=null) {
            userInfoMapper.deleteByUserName(userName);
            return true;
        }else
            return false;
    }
}
