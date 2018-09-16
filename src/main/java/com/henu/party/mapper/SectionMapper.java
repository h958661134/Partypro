package com.henu.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.henu.party.bean.Section;



public interface SectionMapper {

	/**
	 * 插入Section数据
	 * @param Section
	 */
	public void insertSection(Section section);
	
	/**
	 * 根据章节名查询
	 * @param Key
	 * @return Section
	 */
	public Section selectByKeySection(String studySection);
	
	/**
	 * 查询全部
	 * @return Section集合
	 */
	public List<Section> selectAllSection();
	
	/**
	 * 批量删除
	 * @param Keys 指定传入的Key集合
	 */
	public void batchDeleteByKeySection(@Param("Keys")String[] Keys);
	
	public List<Section> searchRowSection(@Param("num1")int num1,@Param("num2")int num2);
	
	public int numberSection();
}
