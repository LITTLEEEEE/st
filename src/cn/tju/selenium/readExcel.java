package cn.tju.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.Rdn;

import com.google.common.collect.Table.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
                                                          
public class readExcel {
    public static List<student> readFromExcel(String filesrc) throws IOException, BiffException{
        List<student> userList = new ArrayList<student>();
        //读取excel文件
        InputStream is = new FileInputStream(filesrc);
        Workbook wb;
		wb = Workbook.getWorkbook(is);
		Sheet sheet = wb.getSheet(0);
		int rows = sheet.getRows();//获取工作表中的总行数
		
        readExcel rdExcel = new readExcel();
	    for(int i = 2 ; i < rows ; i++) {
	        jxl.Cell Cell1=sheet.getCell(1,i);
	        jxl.Cell Cell2=sheet.getCell(2,i);
	        jxl.Cell Cell3=sheet.getCell(3,i);      
	        student student = rdExcel.new student();
	        student.student(Cell1.getContents(), Cell2.getContents(), Cell3.getContents());
	        userList.add(student);
	    }
        return userList;
    }
    class student{
    	public String id;
    	public String name;
    	public String git;
    	public void student(String id,String name,String git) {
    		this.id=id;
    		this.name=name;
    		this.git=git;
    	}
    	public String getid() {
    		return this.id;
    	}
    	public String getname() {
    		return this.name;
    	}
    	public String getgit() {
    		return this.git;
    	}
    }
    public static void main(String[] args){
    	readExcel rd = new readExcel();
    	String filesrc="C:/Users/91208/Desktop/list.xls";
    	try {
			rd.readFromExcel(filesrc);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
