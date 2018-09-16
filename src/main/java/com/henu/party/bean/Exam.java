package com.henu.party.bean;

import java.io.Serializable;
import java.util.List;

public class Exam implements Serializable {
	//examId、examName、examList、create、test
	//考试编号、考试名称、考试题目集、创建时间、党课测试表
	private Integer examId;//考试编号
	private String examName;//考试名称
	private String examList;//考试题目集
	private String create;//创建时间
	private List<Test> test;//党课测试表
	public Integer getExamId() {
		return examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamList() {
		return examList;
	}
	public void setExamList(String examList) {
		this.examList = examList;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public List<Test> getTest() {
		return test;
	}
	public void setTest(List<Test> test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName
				+ ", examList=" + examList + ", create=" + create + ", test="
				+ test + "]";
	}
	public Exam(String examName, String examList, String create, List<Test> test) {
		super();
		this.examName = examName;
		this.examList = examList;
		this.create = create;
		this.test = test;
	}
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
