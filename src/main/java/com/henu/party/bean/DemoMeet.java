package com.henu.party.bean;

public class DemoMeet {
	private String num;
	private String userName;
	private String startTime;
	private String endTime;
	private String result;
	private String rewardPunish;
	private String rewardPunishReason;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRewardPunish() {
		return rewardPunish;
	}

	public void setRewardPunish(String rewardPunish) {
		this.rewardPunish = rewardPunish;
	}

	public String getRewardPunishReason() {
		return rewardPunishReason;
	}

	public void setRewardPunishReason(String rewardPunishReason) {
		this.rewardPunishReason = rewardPunishReason;
	}

	public DemoMeet(String num, String userName, String startTime, String endTime, String result, String rewardPunish,
			String rewardPunishReason) {
		super();
		this.num = num;
		this.userName = userName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.result = result;
		this.rewardPunish = rewardPunish;
		this.rewardPunishReason = rewardPunishReason;
	}

	@Override
	public String toString() {
		return "DemoMeet [num=" + num + ", userName=" + userName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", result=" + result + ", rewardPunish=" + rewardPunish + ", rewardPunishReason=" + rewardPunishReason
				+ "]";
	}

	public DemoMeet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
