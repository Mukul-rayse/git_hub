package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Branch_Excel {

	public static void main(String[] args) throws IOException, InterruptedException {
		Library LB = new Library();
		LB.OpenApp("http://183.82.100.55/ranford2");
		LB.AdminLgn("Admin","M1ndq");
		
		//To get test data excel file
		FileInputStream fis=new FileInputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Testdata\\Branch.xlsx");
		
		//workbook
		XSSFWorkbook WB=new XSSFWorkbook(fis);
		
		//sheet
		XSSFSheet WS=WB.getSheet("Bdata");
		
		//row count
		int Rc=WS.getLastRowNum();
		System.out.println(Rc);
		
		//multiple iterations loop
		for (int i=1;i<=Rc;i++)
		{
			//row
			XSSFRow WR=WS.getRow(i);
			
			//cell
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			XSSFCell WC2=WR.getCell(2);
			XSSFCell WC3=WR.getCell(3);
			XSSFCell WC4=WR.getCell(4);
			XSSFCell WC5=WR.getCell(5);
			
			XSSFCell WC6=WR.createCell(6);
			
			//cell values
			String Bname=WC.getStringCellValue();
			String Radd=WC1.getStringCellValue();
			String Bzc=WC2.getStringCellValue();
			String Bcty=WC3.getStringCellValue();
			String Bstate=WC4.getStringCellValue();
			String Bcity=WC5.getStringCellValue();
			
			String Res=LB.Branchcre(Bname, Radd, Bzc, Bcty, Bstate, Bcity);
			System.out.println(Res);
			
			WC6.setCellValue(Res);
			
		}
		FileOutputStream fos=new FileOutputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Results\\Res_Branch1.xlsx");
		WB.write(fos);
		WB.close();

	}

}
