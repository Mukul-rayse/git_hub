package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Role_Excel {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		Library LB = new Library();
		LB.OpenApp("http://183.82.100.55/ranford2");
		LB.AdminLgn("Admin","M1ndq");
		
		
		//to get Test data Excel file
		FileInputStream Fis = new FileInputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Testdata\\Role.xlsx");
		
		//Workbook
		XSSFWorkbook WB=new XSSFWorkbook(Fis);
		
		//Sheet
		XSSFSheet WS=WB.getSheet("Rdata");
		
		//Row count
		int Rc = WS.getLastRowNum();
		System.out.println(Rc);
		
		//Multiple Iterations--- Loop
		
		for (int i=1;i<=Rc;i++) 
		{
			//Row
			XSSFRow WR = WS.getRow(i);
			
			//Cell
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			
			//Cell Values
			String Rname=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();
			
			String Res=LB.Rolecre(Rname,Rtyp);
			System.out.println(Res);
			
			WC2.setCellValue(Res);	
		}
		
		FileOutputStream Fos=new FileOutputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Results\\Res_Role.xlsx");
		WB.write(Fos);
		WB.close();
		

	}

}
