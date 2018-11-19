package com.henu.party.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.henu.party.bean.UserInfo;

public class ExportExcel {
	public void Export(HttpServletResponse resp,String parState,List<UserInfo> userInfoList) {
		// 声明一个工作薄
		XSSFWorkbook wb = new XSSFWorkbook();
		// 声明一个单子并命名
		XSSFSheet sheet = wb.createSheet(parState + "基本信息表");
		// 给单子名称一个长度
		sheet.setDefaultColumnWidth((short) 10);
		// 生成一个样式，设置单元格格式为文本
		XSSFCellStyle style = wb.createCellStyle();
        XSSFDataFormat format = wb.createDataFormat();    
        style.setDataFormat(format.getFormat("@"));
        // 生成样式，设置Excel第一行加粗效果
        XSSFFont font=wb.createFont();
        font.setFontHeightInPoints((short)12);
        font.setBold(true); //字体加粗
        XSSFCellStyle style1 = wb.createCellStyle(); 
        style1.setDataFormat(format.getFormat("@"));
        style1.setFont(font);
		// 创建第一行（也可以称为表头）
		XSSFRow row = sheet.createRow(0);
		// 给表头第一行一次创建单元格
		XSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("学号");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 2);
		cell.setCellValue("性别");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 3);
		cell.setCellValue("出生日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 4);
		cell.setCellValue("民族");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 5);
		cell.setCellValue("籍贯");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 6);
		cell.setCellValue("居民身份证号");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 7);
		cell.setCellValue("户口所在地派出所");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 8);
		cell.setCellValue("参加工作日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 9);
		cell.setCellValue("加入其它党团");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 10);
		cell.setCellValue("加入其它党团日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 11);
		cell.setCellValue("家庭地址");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 12);
		cell.setCellValue("邮政编码");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 13);
		cell.setCellValue("联系电话");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 14);
		cell.setCellValue("月缴纳党费金额（元）");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 15);
		cell.setCellValue("教育类别");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 16);
		cell.setCellValue("学历");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 17);
		cell.setCellValue("入学日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 18);
		cell.setCellValue("毕业日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 19);
		cell.setCellValue("学位");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 20);
		cell.setCellValue("岗位类型");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 21);
		cell.setCellValue("工作岗位开始日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 22);
		cell.setCellValue("岗位名称");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 23);
		cell.setCellValue("一线情况");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 24);
		cell.setCellValue("是否工人");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 25);
		cell.setCellValue("申请入党日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 26);
		cell.setCellValue("入党培养人");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 27);
		cell.setCellValue("列为积极分子日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 28);
		cell.setCellValue("列为发展对象日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 29);
		cell.setCellValue("最近党课培训情况");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 30);
		cell.setCellValue("最近培训日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 31);
		cell.setCellValue("最近培训结果");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 32);
		cell.setCellValue("入党日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 33);
		cell.setCellValue("入党类型");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 34);
		cell.setCellValue("转正日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 35);
		cell.setCellValue("转正情况");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 36);
		cell.setCellValue("进入党支部日期");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 37);
		cell.setCellValue("进入党支部类型");
		cell.setCellStyle(style1);
		cell = row.createCell((short) 38);
		cell.setCellValue("工作所在单位");
		cell.setCellStyle(style1);
		
		// 添加userInfoList数据
		// 向单元格里填充数据
		for (short i = 0; i < userInfoList.size(); i++) {
			row = sheet.createRow(i + 1);
			XSSFCell cell0 = row.createCell((short) 0);
			cell0.setCellValue(userInfoList.get(i).getUserName());
			cell0.setCellStyle(style);
			XSSFCell cell1 = row.createCell((short) 1);
			cell1.setCellValue(userInfoList.get(i).getName());
			cell1.setCellStyle(style);
			XSSFCell cell2 = row.createCell((short) 2);
			cell2.setCellValue(userInfoList.get(i).getSex());
			cell2.setCellStyle(style);
			XSSFCell cell3 = row.createCell((short) 3);
			cell3.setCellValue(userInfoList.get(i).getBirthDay());
			cell3.setCellStyle(style);
			XSSFCell cell4 = row.createCell((short) 4);
			cell4.setCellValue(userInfoList.get(i).getNation());
			cell4.setCellStyle(style);
			XSSFCell cell5 = row.createCell((short) 5);
			cell5.setCellValue(userInfoList.get(i).getNativePlace());
			cell5.setCellStyle(style);
			XSSFCell cell6 = row.createCell((short) 6);
			cell6.setCellValue(userInfoList.get(i).getId());
			cell6.setCellStyle(style);
			XSSFCell cell7 = row.createCell((short) 7);
			cell7.setCellValue(userInfoList.get(i).getPoliceStation());
			cell7.setCellStyle(style);
			XSSFCell cell8 = row.createCell((short) 8);
			cell8.setCellValue(userInfoList.get(i).getStartWork());
			cell8.setCellStyle(style);
			XSSFCell cell9 = row.createCell((short) 9);
			cell9.setCellValue(userInfoList.get(i).getOtherParty());
			cell9.setCellStyle(style);
			XSSFCell cell10 = row.createCell((short) 10);
			cell10.setCellValue(userInfoList.get(i).getoPDate());
			cell10.setCellStyle(style);
			XSSFCell cell11 = row.createCell((short) 11);
			cell11.setCellValue(userInfoList.get(i).getAddress());
			cell11.setCellStyle(style);
			XSSFCell cell12 = row.createCell((short) 12);
			cell12.setCellValue(userInfoList.get(i).getPostalcode());
			cell12.setCellStyle(style);
			XSSFCell cell13 = row.createCell((short) 13);
			cell13.setCellValue(userInfoList.get(i).getPhone());
			cell13.setCellStyle(style);
			XSSFCell cell14 = row.createCell((short) 14);
			cell14.setCellValue(userInfoList.get(i).getPrice());
			cell14.setCellStyle(style);
			XSSFCell cell15 = row.createCell((short) 15);
			cell15.setCellValue(userInfoList.get(i).getEduType());
			cell15.setCellStyle(style);
			XSSFCell cell16 = row.createCell((short) 16);
			cell16.setCellValue(userInfoList.get(i).getBestEdu());
			cell16.setCellStyle(style);
			XSSFCell cell17 = row.createCell((short) 17);
			cell17.setCellValue(userInfoList.get(i).getTimeInSch());
			cell17.setCellStyle(style);
			XSSFCell cell18 = row.createCell((short) 18);
			cell18.setCellValue(userInfoList.get(i).getTimeOutSch());
			cell18.setCellStyle(style);
			XSSFCell cell19 = row.createCell((short) 19);
			cell19.setCellValue(userInfoList.get(i).getDegree());
			cell19.setCellStyle(style);
			XSSFCell cell20 = row.createCell((short) 20);
			cell20.setCellValue(userInfoList.get(i).getStationType());
			cell20.setCellStyle(style);
			XSSFCell cell21 = row.createCell((short) 21);
			cell21.setCellValue(userInfoList.get(i).getTimeToWork());
			cell21.setCellStyle(style);
			XSSFCell cell22 = row.createCell((short) 22);
			cell22.setCellValue(userInfoList.get(i).getStationName());
			cell22.setCellStyle(style);
			XSSFCell cell23 = row.createCell((short) 23);
			cell23.setCellValue(userInfoList.get(i).getNewStatus());
			cell23.setCellStyle(style);
			XSSFCell cell24 = row.createCell((short) 24);
			cell24.setCellValue(userInfoList.get(i).getIsWorker());
			cell24.setCellStyle(style);
			XSSFCell cell25 = row.createCell((short) 25);
			cell25.setCellValue(userInfoList.get(i).getApplyDate());
			cell25.setCellStyle(style);
			XSSFCell cell26 = row.createCell((short) 26);
			cell26.setCellValue(userInfoList.get(i).getDevelopPeople());
			cell26.setCellStyle(style);
			XSSFCell cell27 = row.createCell((short) 27);
			cell27.setCellValue(userInfoList.get(i).getActiveDate());
			cell27.setCellStyle(style);
			XSSFCell cell28 = row.createCell((short) 28);
			cell28.setCellValue(userInfoList.get(i).getDevelopDate());
			cell28.setCellStyle(style);
			XSSFCell cell29 = row.createCell((short) 29);
			cell29.setCellValue(userInfoList.get(i).getPartyTrain());
			cell29.setCellStyle(style);
			XSSFCell cell30 = row.createCell((short) 30);
			cell30.setCellValue(userInfoList.get(i).getTrainDate());
			cell30.setCellStyle(style);
			XSSFCell cell31 = row.createCell((short) 31);
			cell31.setCellValue(userInfoList.get(i).getTrainResult());
			cell31.setCellStyle(style);
			XSSFCell cell32 = row.createCell((short) 32);
			cell32.setCellValue(userInfoList.get(i).getPartyInDate());
			cell32.setCellStyle(style);
			XSSFCell cell33 = row.createCell((short) 33);
			cell33.setCellValue(userInfoList.get(i).getPartyType());
			cell33.setCellStyle(style);
			XSSFCell cell34 = row.createCell((short) 34);
			cell34.setCellValue(userInfoList.get(i).getPositiveDates());
			cell34.setCellStyle(style);
			XSSFCell cell35 = row.createCell((short) 35);
			cell35.setCellValue(userInfoList.get(i).getPositiveCase());
			cell35.setCellStyle(style);
			XSSFCell cell36 = row.createCell((short) 36);
			cell36.setCellValue(userInfoList.get(i).getEnterDate());
			cell36.setCellStyle(style);
			XSSFCell cell37 = row.createCell((short) 37);
			cell37.setCellValue(userInfoList.get(i).getEnterType());
			cell37.setCellStyle(style);
			XSSFCell cell38 = row.createCell((short) 38);
			cell38.setCellValue(userInfoList.get(i).getWorkPlace());
			cell38.setCellStyle(style);
		}
		
		//调整每一列宽度自适应内容
		for (int j = 0; j <= 38; j++) {
			sheet.autoSizeColumn((short)j);
		}

		try {
			// 默认导出到D盘下
			//FileOutputStream out = new FileOutputStream("D:\\信息统计表.xlsx");
			OutputStream output = resp.getOutputStream();
			// 报头用于提供一个推荐的文件名，并强制浏览器显示保存对话框
			// attachment表示以附件方式下载。如果要在页面中打开，则改为 inline
			resp.reset();
			resp.setHeader("Content-disposition", "attachment; filename="+parState);
			resp.setContentType("Content-Type:application/vnd.ms-excel ");
			wb.write(output);
			output.close();
			JOptionPane.showMessageDialog(null, "导出成功!");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "导出失败!");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "导出失败!");
			e.printStackTrace();
		}
	}
}