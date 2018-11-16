package com.henu.party.service.impl;

import com.henu.party.bean.*;
import com.henu.party.mapper.*;
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
    @Autowired
    public TechdutyMapper techdutyMapper;
    @Autowired
    public DemomeetMapper demomeetMapper;
    @Autowired
    public EduDegreeMapper eduDegreeMapper;
    @Autowired
    public JobStationMapper jobStationMapper;
    @Autowired
    public RewardPunishMapper rewardPunishMapper;

    /**
     * 根据主键查询实例
     *
     * @return
     */
    @Override
    public UserInfo getAUserInfo(String userName) {
        return userInfoMapper.selectUserInfoByUsername(userName);
    }

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
    public List<UserInfo> getUserInfo(String name) {

        return userInfoMapper.selectByUserName(name);
    }

    /**
     * @param partyState 代表入党状态的数字
     * @return 返回对应状态的所有用户信息
     */
    @Override
    public List<UserInfo> getUserByPartyState(String partyState) {

        return userInfoMapper.selectMemberInfo(partyState);
    }

    /**
     * 通过党支部名称查询对应的用户
     *
     * @param PartyBranchName 党支部名字
     * @return 返回所有查询到的用户信息
     */
    @Override
    public List<UserInfo> getByPartyBranchName(String PartyBranchName) {

        return userInfoMapper.selectByPartyBranch(PartyBranchName);
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
        if(userInfoMapper.selectByUserName(userName)!=null) {
            userInfoMapper.deleteByUserName(userName);
            return true;
        }else
            return false;
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return 返回是否删除
     */
    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByUserName(userInfo);
        return true;
    }

    @Override
    public OutBoard getOutboard(String userName) {
        return userInfoMapper.selectOutboardByUserName(userName);
    }

    @Override
    public FlowPartyer getFlowPartyer(String userName) {
        return userInfoMapper.selectFlowPartyerByUserName(userName);
    }

    @Override
    public PoorPartyer getPoorPartyer(String userName) {
        return userInfoMapper.selectPoorPartyerByUserName(userName);
    }

    @Override
    public boolean updateOutboard(OutBoard outBoard) {
        if(outBoard!=null)
            userInfoMapper.updateOutboard(outBoard);
        return true;
    }

    @Override
    public boolean updateFlowPartyer(FlowPartyer flowPartyer) {
        if(flowPartyer!=null)
            userInfoMapper.updateFlowPartyer(flowPartyer);
        return true;
    }

    @Override
    public boolean updatePoorPartyer(PoorPartyer poorPartyer) {
        if(poorPartyer!=null)
            userInfoMapper.updatePoorPartyer(poorPartyer);
        return true;
    }

    @Override
    public List<TechDuty> selectTechDutyByUserName(String userName) {

        return techdutyMapper.selectByUserName(userName);
    }

    @Override
    public List<EduDegree> selectEduDegreeByUserName(String userName) {

        return eduDegreeMapper.selectByUserName(userName);
    }

    @Override
    public List<JobStation> selectJobStationByUserName(String userName) {

        return jobStationMapper.selectByUserName(userName);
    }

    @Override
    public List<RewardPunish> selectRewardPunishByUserName(String userName) {

        return rewardPunishMapper.selectByUserName(userName);
    }

    @Override
    public List<DemoMeet> selectDemoMeetByUserName(String userName) {

        return demomeetMapper.selectByUserName(userName);
    }


}
