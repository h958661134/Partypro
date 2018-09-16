package com.henu.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.henu.party.bean.Exam;



public interface ExamMapper {

	/**
	 * 插入Exam数据
	 * @param exam
	 */
	public void insertExam(Exam exam);
	
	/**
	 * 根据id号查询
	 * @param id
	 * @return Exam
	 */
	public Exam selectByIdExam(Integer id);
	
	/**
	 * 查询全部
	 * @return Exam集合
	 */
	public List<Exam> selectAllExam();
	
	/**
	 * 模糊查找
	 * @return Exam集合
	 */
	public List<Exam> selectLike(String Keywords);
	
	/**
	 * 批量删除
	 * @param ids 指定传入的id集合
	 */
	public void batchDeleteByIdExam(@Param("ids")String[] ids);
	
	public List<Exam> searchRowExam(@Param("num1")int num1,@Param("num2")int num2);
	
	public int numberExam();
}
