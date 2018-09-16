package com.henu.party.bean;

public class PartyDuty {
	private String num;
	private String userName;
	private String SPO;
	private String serviceOg;
	private String jobName;
	private String appDate;
	private String remDate;
	private String mainDuties;
	private String teamMembers;

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

	public String getSPO() {
		return SPO;
	}

	public void setSPO(String sPO) {
		SPO = sPO;
	}

	public String getServiceOg() {
		return serviceOg;
	}

	public void setServiceOg(String serviceOg) {
		this.serviceOg = serviceOg;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getRemDate() {
		return remDate;
	}

	public void setRemDate(String remDate) {
		this.remDate = remDate;
	}

	public String getMainDuties() {
		return mainDuties;
	}

	public void setMainDuties(String mainDuties) {
		this.mainDuties = mainDuties;
	}

	public String getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(String teamMembers) {
		this.teamMembers = teamMembers;
	}

	public PartyDuty(String num, String userName, String sPO, String serviceOg, String jobName, String appDate,
			String remDate, String mainDuties, String teamMembers) {
		super();
		this.num = num;
		this.userName = userName;
		SPO = sPO;
		this.serviceOg = serviceOg;
		this.jobName = jobName;
		this.appDate = appDate;
		this.remDate = remDate;
		this.mainDuties = mainDuties;
		this.teamMembers = teamMembers;
	}

	public PartyDuty() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PartyDuty [num=" + num + ", userName=" + userName + ", SPO=" + SPO + ", serviceOg=" + serviceOg
				+ ", jobName=" + jobName + ", appDate=" + appDate + ", remDate=" + remDate + ", mainDuties="
				+ mainDuties + ", teamMembers=" + teamMembers + "]";
	}

}
