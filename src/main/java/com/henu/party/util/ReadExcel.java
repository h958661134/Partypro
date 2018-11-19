package com.henu.party.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.henu.party.bean.UserInfo;


/**
 * @author smallBlack
 * @Date 2018-3-20
 * 工具类读取Excel类中内容
 */
public class ReadExcel {
	//设置默认密码
	private String password = "666666";
	//设置入党状态
	private String parState;
    //总行数
    private int totalRows = 0;  
    //总条数
    private int totalCells = 0; 
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;} 
    //获取总列数
    public int getTotalCells() {  return totalCells;} 
    //获取错误信息-暂时未用到暂时留着
    public String getErrorInfo() { return errorMsg; }
    
  /**
   * 读EXCEL文件，获取客户信息集合
   * @param fielName
   * @return
   */
  public List<UserInfo> getExcelInfo(MultipartFile Mfile,String partyState,String partyBranch){
      
//       //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
//       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; 
//       //获取本地存储路径
//       File file = new File("D:\\fileupload");
//       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
//       if (!file.exists()) file.mkdirs();
//       //新建一个文件
//       File file1 = new File("D:\\fileupload\\" + new Date().getTime() + ".xlsx"); 
//       //将上传的文件写入新建的文件中
//       try {
////           cf.getFileItem().write(file1);
//    	   cf.getFileItem(file1);
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
	
       //初始化客户信息的集合    
       List<UserInfo> userInfoList=new ArrayList<UserInfo>();
       //初始化输入流
       FileInputStream is = null;
       Workbook wb = null;
       try{
          //根据新建的文件实例化输入流
          is = new FileInputStream("C:/PAYROLL_xls/PayrollModel.xls");//路径
          POIFSFileSystem fs = new POIFSFileSystem(is);
          //根据excel里面的内容读取客户信息
          
          //当excel是2003时
          //wb = new HSSFWorkbook(is);
          //当excel是2007时
          wb = new XSSFWorkbook(is);
          
          //读取Excel里面客户的信息
          if ("正式党员".equals(partyState)) {
        	  parState = "党员";
        	  userInfoList=readExcelValue1(wb,partyBranch);
          } else if ("预备党员".equals(partyState)) {
        	  parState ="预备党员";
        	  userInfoList=readExcelValue2(wb,partyBranch);
          } else if ("发展对象".equals(partyState)) {
        	  parState ="发展对象";
        	  userInfoList=readExcelValue3(wb,partyBranch);
          } else if ("入党积极分子".equals(partyState)) {
        	  parState ="入党积极分子";
        	  userInfoList=readExcelValue4(wb,partyBranch);
          }
          
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return userInfoList;
  }
 
  /**
   * 读取Excel里面正式党员的信息
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue1(Workbook wb,String partyBranch){ 
      //得到第一个shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //得到Excel的行数
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //得到Excel的列数(前提是有行数)
       if(totalRows>=1 && sheet.getRow(0) != null){//判断行数大于一，并且第一行必须有标题（这里有bug若文件第一行没值就完了）
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }else{
           return null;
       }
       
       List<UserInfo> userInfoList=new ArrayList<UserInfo>();//声明一个对象集合
       UserInfo userInfo;//声明一个对象
       
      //循环Excel行数,从第二行开始。标题不入库
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) 
        	   continue;
           userInfo = new UserInfo();
           
           //循环Excel的列
           for(int c = 0; c <this.totalCells; c++){ 
               Cell cell = row.getCell(c);
               if (null != cell){
            	   switch (c) {
					case 0:
						userInfo.setUserName(getValue(cell));//学号
						break;
					case 1:
						userInfo.setName(getValue(cell));//姓名
						break;
					case 2:
						userInfo.setSex(getValue(cell));//性别
						break;
					case 3:
						userInfo.setBirthDay(getValue(cell));//出生日期
						break;
					case 4:
						userInfo.setNation(getValue(cell));//民族
						break;
					case 5:
						userInfo.setNativePlace(getValue(cell));//籍贯
						break;
					case 6:
						userInfo.setId(getValue(cell));//身份证号
						break;
					case 7:
						userInfo.setPoliceStation(getValue(cell));//户口所在地派出所
						break;
					case 8:
						userInfo.setStartWork(getValue(cell));//参加工作日期
						break;
					case 9:
						userInfo.setOtherParty(getValue(cell));//加入其它党团
						break;
					case 10:
						userInfo.setoPDate(getValue(cell));//加入其它党团日期
						break;
					case 11:
						userInfo.setAddress(getValue(cell));//家庭地址
						break;
					case 12:
						userInfo.setPostalcode(getValue(cell));//邮政编码
						break;
					case 13:
						userInfo.setPhone(getValue(cell));//联系电话
						break;
					case 14:
						userInfo.setPrice(Integer.parseInt(getValue(cell)));//月交纳党费金额
						break;
					case 15:
						userInfo.setEduType(getValue(cell));//教育类别
						break;
					case 16:
						userInfo.setBestEdu(getValue(cell));//最高学历
						break;
					case 17:
						userInfo.setTimeInSch(getValue(cell));//入学日期
						break;
					case 18:
						userInfo.setTimeOutSch(getValue(cell));//毕业日期
						break;
					case 19:
						userInfo.setDegree(getValue(cell));//学位
						break;
					case 20:
						userInfo.setStationType(getValue(cell));//岗位类型
						break;
					case 21:
						userInfo.setTimeToWork(getValue(cell));//工作岗位开始日期
						break;
					case 22:
						userInfo.setStationName(getValue(cell));//岗位名称
						break;
					case 23:
						userInfo.setNewStatus(getValue(cell));//一线情况
						break;
					case 24:
						userInfo.setIsWorker(getValue(cell));//是否工人
						break;
					case 25:
						userInfo.setPartyInDate(getValue(cell));//入党日期
						break;
					case 26:
						userInfo.setPartyType(getValue(cell));//入党类型
						break;
					case 27:
						userInfo.setPositiveDates(getValue(cell));//转正日期
						break;
					case 28:
						userInfo.setPositiveCase(getValue(cell));//转正情况
						break;
					case 29:
						userInfo.setEnterDate(getValue(cell));//进入党支部日期
						break;
					case 30:
						userInfo.setEnterType(getValue(cell));//进入党支部类型
						break;
					case 31:
						userInfo.setWorkPlace(getValue(cell));//工作所在单位
						break;
					default:
						break;
            	   }
               }
           }
           //设置所属党支部、入党状态和初始密码属性值
           userInfo.setPartyBranch(partyBranch);
           userInfo.setPartyState(parState);
           userInfo.setPassword(password);
           //添加对象到集合中
           userInfoList.add(userInfo);
       }
       return userInfoList;
  }
  
  /**
   * 读取Excel里面预备党员的信息
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue2(Workbook wb,String partyBranch){ 
      //得到第一个shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //得到Excel的行数
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //得到Excel的列数(前提是有行数)
       if(totalRows>=1 && sheet.getRow(0) != null){//判断行数大于一，并且第一行必须有标题（这里有bug若文件第一行没值就完了）
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }else{
           return null;
       }
       
       List<UserInfo> userInfoList=new ArrayList<UserInfo>();//声明一个对象集合
       UserInfo userInfo;//声明一个对象
       
      //循环Excel行数,从第二行开始。标题不入库
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) 
        	   continue;
           userInfo = new UserInfo();
           
           //循环Excel的列
           for(int c = 0; c <this.totalCells; c++){ 
               Cell cell = row.getCell(c);
               if (null != cell){
            	   switch (c) {
					case 0:
						userInfo.setUserName(getValue(cell));//学号
						break;
					case 1:
						userInfo.setName(getValue(cell));//姓名
						break;
					case 2:
						userInfo.setSex(getValue(cell));//性别
						break;
					case 3:
						userInfo.setBirthDay(getValue(cell));//出生日期
						break;
					case 4:
						userInfo.setNation(getValue(cell));//民族
						break;
					case 5:
						userInfo.setNativePlace(getValue(cell));//籍贯
						break;
					case 6:
						userInfo.setId(getValue(cell));//身份证号
						break;
					case 7:
						userInfo.setPoliceStation(getValue(cell));//户口所在地派出所
						break;
					case 8:
						userInfo.setStartWork(getValue(cell));//参加工作日期
						break;
					case 9:
						userInfo.setOtherParty(getValue(cell));//加入其它党团
						break;
					case 10:
						userInfo.setoPDate(getValue(cell));//加入其它党团日期
						break;
					case 11:
						userInfo.setAddress(getValue(cell));//家庭地址
						break;
					case 12:
						userInfo.setPostalcode(getValue(cell));//邮政编码
						break;
					case 13:
						userInfo.setPhone(getValue(cell));//联系电话
						break;
					case 14:
						userInfo.setPrice(0);//月交纳党费金额
						break;
					case 15:
						userInfo.setEduType(getValue(cell));//教育类别
						break;
					case 16:
						userInfo.setBestEdu(getValue(cell));//最高学历
						break;
					case 17:
						userInfo.setTimeInSch(getValue(cell));//入学日期
						break;
					case 18:
						userInfo.setTimeOutSch(getValue(cell));//毕业日期
						break;
					case 19:
						userInfo.setDegree(getValue(cell));//学位
						break;
					case 20:
						userInfo.setStationType(getValue(cell));//岗位类型
						break;
					case 21:
						userInfo.setTimeToWork(getValue(cell));//工作岗位开始日期
						break;
					case 22:
						userInfo.setStationName(getValue(cell));//岗位名称
						break;
					case 23:
						userInfo.setNewStatus(getValue(cell));//一线情况
						break;
					case 24:
						userInfo.setIsWorker(getValue(cell));//是否工人
						break;
					case 25:
						userInfo.setPartyInDate(getValue(cell));//入党日期
						break;
					case 26:
						userInfo.setPartyType(getValue(cell));//入党类型
						break;
					case 27:
						userInfo.setEnterDate(getValue(cell));//进入党支部日期
						break;
					case 28:
						userInfo.setEnterType(getValue(cell));//进入党支部类型
						break;
					case 29:
						userInfo.setWorkPlace(getValue(cell));//工作所在单位
						break;
					default:
						break;
            	   }
               }
           }
           //设置所属党支部、入党状态和初始密码属性值
           userInfo.setPartyBranch(partyBranch);
           userInfo.setPartyState(parState);
           userInfo.setPassword(password);
           //添加对象到集合中
           userInfoList.add(userInfo);
       }
       return userInfoList;
  }
  
  /**
   * 读取Excel里面发展对象的信息
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue3(Workbook wb,String partyBranch){ 
      //得到第一个shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //得到Excel的行数
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //得到Excel的列数(前提是有行数)
       if(totalRows>=1 && sheet.getRow(0) != null){//判断行数大于一，并且第一行必须有标题（这里有bug若文件第一行没值就完了）
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }else{
           return null;
       }
       
       List<UserInfo> userInfoList=new ArrayList<UserInfo>();//声明一个对象集合
       UserInfo userInfo;//声明一个对象
       
      //循环Excel行数,从第二行开始。标题不入库
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) 
        	   continue;
           userInfo = new UserInfo();
           
           //循环Excel的列
           for(int c = 0; c <this.totalCells; c++){ 
               Cell cell = row.getCell(c);
               if (null != cell){
            	   switch (c) {
					case 0:
						userInfo.setUserName(getValue(cell));//学号
						break;
					case 1:
						userInfo.setName(getValue(cell));//姓名
						break;
					case 2:
						userInfo.setSex(getValue(cell));//性别
						break;
					case 3:
						userInfo.setBirthDay(getValue(cell));//出生日期
						break;
					case 4:
						userInfo.setNation(getValue(cell));//民族
						break;
					case 5:
						userInfo.setNativePlace(getValue(cell));//籍贯
						break;
					case 6:
						userInfo.setId(getValue(cell));//身份证号
						break;
					case 7:
						userInfo.setPoliceStation(getValue(cell));//户口所在地派出所
						break;
					case 8:
						userInfo.setStartWork(getValue(cell));//参加工作日期
						break;
					case 9:
						userInfo.setOtherParty(getValue(cell));//加入其它党团
						break;
					case 10:
						userInfo.setoPDate(getValue(cell));//加入其它党团日期
						break;
					case 11:
						userInfo.setAddress(getValue(cell));//家庭地址
						break;
					case 12:
						userInfo.setPostalcode(getValue(cell));//邮政编码
						break;
					case 13:
						userInfo.setPhone(getValue(cell));//联系电话
						break;
					case 14:
						userInfo.setPrice(Integer.parseInt(getValue(cell)));//月交纳党费金额
						break;
					case 15:
						userInfo.setEduType(getValue(cell));//教育类别
						break;
					case 16:
						userInfo.setBestEdu(getValue(cell));//最高学历
						break;
					case 17:
						userInfo.setTimeInSch(getValue(cell));//入学日期
						break;
					case 18:
						userInfo.setTimeOutSch(getValue(cell));//毕业日期
						break;
					case 19:
						userInfo.setDegree(getValue(cell));//学位
						break;
					case 20:
						userInfo.setStationType(getValue(cell));//岗位类型
						break;
					case 21:
						userInfo.setTimeToWork(getValue(cell));//工作岗位开始日期
						break;
					case 22:
						userInfo.setStationName(getValue(cell));//岗位名称
						break;
					case 23:
						userInfo.setNewStatus(getValue(cell));//一线情况
						break;
					case 24:
						userInfo.setIsWorker(getValue(cell));//是否工人
						break;
					case 25:
						userInfo.setApplyDate(getValue(cell));//申请入党日期
						break;
					case 26:
						userInfo.setDevelopPeople(getValue(cell));//入党培养人
						break;
					case 27:
						userInfo.setActiveDate(getValue(cell));//列为积极分子日期
						break;
					case 28:
						userInfo.setDevelopDate(getValue(cell));//列为发展对象日期
						break;
					case 29:
						userInfo.setPartyTrain(getValue(cell));//最近党课培训情况
						break;
					case 30:
						userInfo.setTrainDate(getValue(cell));//最近培训日期
						break;
					case 31:
						userInfo.setTrainResult(getValue(cell));//最近培训结果
						break;
					default:
						break;
            	   }
               }
           }
           //设置所属党支部、入党状态和初始密码属性值
           userInfo.setPartyBranch(partyBranch);
           userInfo.setPartyState(parState);
           userInfo.setPassword(password);
           //添加对象到集合中
           userInfoList.add(userInfo);
       }
       return userInfoList;
  }
  
  /**
   * 读取Excel里面入党积极分子的信息
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue4(Workbook wb,String partyBranch){ 
      //得到第一个shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //得到Excel的行数
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //得到Excel的列数(前提是有行数)
       if(totalRows>=1 && sheet.getRow(0) != null){//判断行数大于一，并且第一行必须有标题（这里有bug若文件第一行没值就完了）
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }else{
           return null;
       }
       
       List<UserInfo> userInfoList=new ArrayList<UserInfo>();//声明一个对象集合
       UserInfo userInfo;//声明一个对象
       
      //循环Excel行数,从第二行开始。标题不入库
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) 
        	   continue;
           userInfo = new UserInfo();
           
           //循环Excel的列
           for(int c = 0; c <this.totalCells; c++){ 
               Cell cell = row.getCell(c);
               if (null != cell){
            	   switch (c) {
					case 0:
						userInfo.setUserName(getValue(cell));//学号
						break;
					case 1:
						userInfo.setName(getValue(cell));//姓名
						break;
					case 2:
						userInfo.setSex(getValue(cell));//性别
						break;
					case 3:
						userInfo.setBirthDay(getValue(cell));//出生日期
						break;
					case 4:
						userInfo.setNation(getValue(cell));//民族
						break;
					case 5:
						userInfo.setNativePlace(getValue(cell));//籍贯
						break;
					case 6:
						userInfo.setId(getValue(cell));//身份证号
						break;
					case 7:
						userInfo.setPoliceStation(getValue(cell));//户口所在地派出所
						break;
					case 8:
						userInfo.setStartWork(getValue(cell));//参加工作日期
						break;
					case 9:
						userInfo.setOtherParty(getValue(cell));//加入其它党团
						break;
					case 10:
						userInfo.setoPDate(getValue(cell));//加入其它党团日期
						break;
					case 11:
						userInfo.setAddress(getValue(cell));//家庭地址
						break;
					case 12:
						userInfo.setPostalcode(getValue(cell));//邮政编码
						break;
					case 13:
						userInfo.setPhone(getValue(cell));//联系电话
						break;
					case 14:
						userInfo.setPrice(Integer.parseInt(getValue(cell)));//月交纳党费金额
						break;
					case 15:
						userInfo.setEduType(getValue(cell));//教育类别
						break;
					case 16:
						userInfo.setBestEdu(getValue(cell));//最高学历
						break;
					case 17:
						userInfo.setTimeInSch(getValue(cell));//入学日期
						break;
					case 18:
						userInfo.setTimeOutSch(getValue(cell));//毕业日期
						break;
					case 19:
						userInfo.setDegree(getValue(cell));//学位
						break;
					case 20:
						userInfo.setStationType(getValue(cell));//岗位类型
						break;
					case 21:
						userInfo.setTimeToWork(getValue(cell));//工作岗位开始日期
						break;
					case 22:
						userInfo.setStationName(getValue(cell));//岗位名称
						break;
					case 23:
						userInfo.setNewStatus(getValue(cell));//一线情况
						break;
					case 24:
						userInfo.setIsWorker(getValue(cell));//是否工人
						break;
					case 25:
						userInfo.setApplyDate(getValue(cell));//申请入党日期
						break;
					case 26:
						userInfo.setDevelopPeople(getValue(cell));//入党培养人
						break;
					case 27:
						userInfo.setActiveDate(getValue(cell));//列为积极分子日期
						break;
					case 28:
						userInfo.setPartyTrain(getValue(cell));//最近党课培训情况
						break;
					case 29:
						userInfo.setTrainDate(getValue(cell));//最近培训日期
						break;
					case 30:
						userInfo.setTrainResult(getValue(cell));//最近培训结果
						break;
					default:
						break;
            	   }
               }
           }
           //设置所属党支部、入党状态和初始密码属性值
           userInfo.setPartyBranch(partyBranch);
           userInfo.setPartyState(parState);
           userInfo.setPassword(password);
           //添加对象到集合中
           userInfoList.add(userInfo);
       }
       return userInfoList;
  }
  
  /**
   * 得到Excel表中的值
   * 
   * @param cell
   *            Excel中的每一个格子
   * @return Excel中每一个格子中的值
   */
  @SuppressWarnings({ "static-access", "unused" })
  private String getValue(Cell cell) {
      if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
          // 返回布尔类型的值
          return String.valueOf(cell.getBooleanCellValue());
      } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
          // 返回数值类型的值
          return String.valueOf(cell.getNumericCellValue());
      } else {
          // 返回字符串类型的值
          return String.valueOf(cell.getStringCellValue());
      }
  }

}