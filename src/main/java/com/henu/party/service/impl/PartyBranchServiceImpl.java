package com.henu.party.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.henu.party.bean.PartyBranch;
import com.henu.party.mapper.PartyBranchMapper;
import com.henu.party.service.PartyBranchService;
@Service("partyBranchService")
public class PartyBranchServiceImpl implements PartyBranchService{
	@Resource
	private PartyBranchMapper pBMapper;
	
	
	/*
	 *根据userName得到某一党支部所有信息
	 */
	public PartyBranch ManagerByUsername(@Param("userName")String username) {
			if(username == null || username.trim().isEmpty()){
				throw new RuntimeException("用户名为空");
			}
			
		return pBMapper.selectManagerByPartyName(username);
	}
	
	/*
	 * 得到所有党支部的信息
	 */
	public List<PartyBranch> AllPartyBranch() {
		
		return pBMapper.selectAllPartyBranch();
	}

	/**
	 * 模糊查找党支部信息
	 */
	public List<PartyBranch> PartyBranchFuzzy(String name) {
		if(name == null || name.trim().isEmpty()){
			throw new RuntimeException("党支部名为空");
		}
		return pBMapper.selectFuzzy(name);
	}

	/**
	 * 更改管理员密码
	 */
	public boolean updateUserPwd(PartyBranch partyBranch) {
		if(partyBranch == null ){
			throw new RuntimeException("党支部不存在");
		}
		int res = pBMapper.updateUserPwd(partyBranch);
		return res == 1;
	}

	/**
	 * 根据partyName得到指定党支部信息
	 */
	public PartyBranch ManagerByPartyName(String partyName) {
		if(partyName == null || partyName.trim().isEmpty()){
			throw new RuntimeException("党支部名不存在");
		}
		 
		return pBMapper.selectManagerByPartyName(partyName);
	}

	/*
	 * 批量删除党支部信息
	 */
	public boolean batchDeletePartyBranch(String[] p) {
		if(p == null){
			throw new RuntimeException("删除条件为空");
		}
		int res = pBMapper.batchDeletePartyBranch(p);
		return res == 1;
	}

	/*
	 * 新增党支部信息
	 */
	public boolean insertOnePartyBranch(PartyBranch partyBranch) {
		if(partyBranch == null ){
			throw new RuntimeException("党支部不存在");
		}
		int res = pBMapper.insertOnePartyBranch(partyBranch);
		return res == 1;
	}

}
