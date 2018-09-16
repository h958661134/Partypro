package com.henu.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.henu.party.bean.PartyBranch;
import com.henu.party.bean.PartyBranchMember;
import com.henu.party.bean.PartyCompany;
import com.henu.party.bean.RewardPunishParty;



/**
 * 定义mapper接口，等价于dao层
 * 
 * @author small black
 *
 */

public interface PartyBranchMapper {

	/*
	 * 根据userName查询某一党支部所有信息
	 */
	public PartyBranch selectManagerByUsername(String username) throws Exception;

	/*
	 * 查询所有党支部信息并返回集合
	 */
	public List<PartyBranch> selectAllPartyBranch() throws Exception;

	/*
	 * 模糊查询某党支部信息并返回集合
	 */
	public List<PartyBranch> selectFuzzy(String name) throws Exception;

	/*
	 * 修改党支部管理员密码
	 */
	public void updateUserPwd(PartyBranch partyBranch) throws Exception;

	/*
	 * 根据partyName查询指定党支部信息
	 */
	public PartyBranch selectManagerByPartyName(String partyName) throws Exception;

	/*
	 * 批量删除党支部信息
	 */
	public void batchDeletePartyBranch(@Param("pids")String[] p) throws Exception;
	
	/*
	 * 新增党支部信息
	 */
	public void insertOnePartyBranch(PartyBranch partyBranch) throws Exception;
	
	/*
	 * 根据partyId查询党组织班子成员信息
	 */
	public List<PartyBranchMember> selectParBranMemberByPartyId(String partyId) throws Exception;
	
	/*
	 * 根据partyId查询党组织奖惩信息
	 */
	public List<RewardPunishParty> selectRePuPartyByPartyId(String partyId) throws Exception;
	
	/*
	 * 根据partyId查询党组织关联单位
	 */
	public List<PartyCompany> selectParCompanyByPartyId(String partyId) throws Exception;

	/*
	 * 根据num修改党支部基本信息
	 */
	public void updatePartyBranchInfo(PartyBranch parBranch) throws Exception;
	
	/*
	 * 新增党组织班子成员
	 */
	public void insertParBranchMem(PartyBranchMember partyBranchMem) throws Exception;
	
	/*
	 * 批量删除或删除指定党组织班子成员
	 */
	public void batchDeleteParMem(@Param("pids")String[] p) throws Exception;
	
	/*
	 * 根据num修改党组织班子成员
	 */
	public void updateParBranchMem(PartyBranchMember partyBranchMem) throws Exception;
	
	/*
	 * 新增党组织奖惩信息
	 */
	public void insertParBranchRwd(RewardPunishParty rewardPuPar) throws Exception;
	
	/*
	 * 批量删除或删除指定党组织奖惩信息
	 */
	public void batchDeleteParRepu(@Param("pids")String[] p) throws Exception;
	
	/*
	 * 根据num修改党组织奖惩信息
	 */
	public void updateParRepu(RewardPunishParty rewardPuPar) throws Exception;
	
	/*
	 * 新增党组织关联单位
	 */
	public void insertParBranchCom(PartyCompany partyCom) throws Exception;
	
	/*
	 * 批量删除或删除指定党组织关联单位
	 */
	public void batchDeleteParCom(@Param("pids")String[] p) throws Exception;
	
	/*
	 * 根据num修改党组织关联单位
	 */
	public void updateParCom(PartyCompany partyCom) throws Exception;
}
