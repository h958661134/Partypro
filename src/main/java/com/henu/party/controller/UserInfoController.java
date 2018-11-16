package com.henu.party.controller;

import com.henu.party.bean.*;
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
        System.err.println(userInfo);
        userService.updateUserInfo(userInfo);
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

    /**
     * 根据学号查找出国信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getOutBoard")
    public OutBoard getOutBoardMsg(String userName){

        return userService.getOutboard(userName);
    }

    /**
     * 根据学号查找党员流动信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getFlowPartyer")
    public FlowPartyer getFlowPartyerMsg(String userName){

        return userService.getFlowPartyer(userName);
    }

    /**
     * 根据学号查找党员贫困信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getPoorPartyer")
    public PoorPartyer getPoorPartyerMsg(String userName){

        return userService.getPoorPartyer(userName);
    }

    /**
     * 更新出国数据
     * @param outBoard 出国信息
     * @return
     */
    @RequestMapping("/user/updateOutBoard")
    public boolean updateOutBoard(OutBoard outBoard){

        return userService.updateOutboard(outBoard);
    }

    /**
     * 更新党员流动
     * @param flowPartyer 流动信息
     * @return
     */
    @RequestMapping("/user/updateFlowPartyer")
    public boolean updateFlowPartyer(FlowPartyer flowPartyer){

        return userService.updateFlowPartyer(flowPartyer);
    }

    /**
     * 更新贫穷信息
     * @param poorPartyer 贫穷信息
     * @return
     */
    @RequestMapping("/user/updatePoorPartyer")
    public boolean updatePoorPartyer(PoorPartyer poorPartyer){

        return userService.updatePoorPartyer(poorPartyer);
    }

    /**
     * 根据id查询信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getTechDuty")
    public List<TechDuty> getTechDuty(String userName){

        return userService.selectTechDutyByUserName(userName);
    }

    /**
     * 根据id查询教育信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getEduDegree")
    public List<EduDegree> getEduDegree(String userName){

        return userService.selectEduDegreeByUserName(userName);
    }

    /**
     * 根据id查询工作信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getJobStation")
    public List<JobStation> getJobStation(String userName){

        return userService.selectJobStationByUserName(userName);
    }

    /**
     * 根据id查询得奖信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getRewardPunish")
    public List<RewardPunish> getRewardPunish(String userName){

        return userService.selectRewardPunishByUserName(userName);
    }

    /**
     * 根据id查询评议信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getDemoMeet")
    public List<DemoMeet> getDemoMeet(String userName){

        return userService.selectDemoMeetByUserName(userName);
    }

    /**
     * 根据id查询任职信息
     * @param userName
     * @return
     */
    @RequestMapping("/user/getPartyDuty")
    public List<PartyDuty> getPartyDuty(String userName){

        return userService.selectPartyDutyByUserName(userName);
    }
}
