package com.ebanking.keywod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;

import com.ebanking.master.Library;

public class KeywordDriven_Excel {

	public static void main(String[] args) throws InterruptedException, IOException {
		Library LB=new Library();
		String Res=null;
		String Kpath="F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\keywod\\keyword_data.xlsx";
		String Kout="F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\keywod\\Res_keyword_data.xlsx";
		
		FileInputStream fi=new FileInputStream(Kpath);
		
		//workbook
		XSSFWorkbook WB=new XSSFWorkbook(fi);
		
		//sheet
		XSSFSheet WS=WB.getSheet("TestCase");
		XSSFSheet WS1=WB.getSheet("TestSteps");
		
		//Row count
		int tcRc=WS.getLastRowNum();
		System.out.println(tcRc);
		
		int TsRc=WS1.getLastRowNum();
		System.out.println(tcRc);
		
		//multiple iterationss--loop
		for(int i=1;i<=tcRc;i++)
		{
				String exe=WS.getRow(i).getCell(2).getStringCellValue();
				if(exe.equalsIgnoreCase("y"))
				{
					String TcId=WS.getRow(i).getCell(0).getStringCellValue();
					System.out.println(TcId);
					
					//test steps
					for(int j=1;j<=TsRc;j++)
					{
						String tsTcid=WS1.getRow(j).getCell(0).getStringCellValue();
						
						if (TcId.equalsIgnoreCase(tsTcid))
						{						
						String key=WS1.getRow(j).getCell(3).getStringCellValue();
						System.out.println(key);
						switch(key)
						{
						case"RLanch":
							Res=LB.OpenApp("http://183.82.100.55/ranford2/");
							break;
						case"RLogin":
							Res=LB.AdminLgn("Admin","M1ndq");
							break;
						case"RLogout":
							LB.admlgt();
							break;
						case "RBranch":
							LB.Branchcre("mucool", "hydrabad", "56789", "INDIA", "GOA", "GOA");
							break;
						case "RRole":
							Res=LB.Rolecre("corona1234","E");
							break;
						case "RClose":
							LB.Appc();
							break;
							
						default:
							System.out.println("Pass avalid keyword");
							break;
						
						}
						
						//result updation in test steps sheet
						
						WS1.getRow(j).createCell(4).setCellValue(Res);
						
						//result updation in test case sheet
						
						if(!WS1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("fail"))
						{
							WS.getRow(i).createCell(3).setCellValue(Res);
						}
						else
						{
							WS.getRow(i).createCell(3).setCellValue(Res);
						}
					}
						
				}
		}
				else
				{
					WS.getRow(i).createCell(3).setCellValue("Blocked");
				}
	}
		FileOutputStream fo=new FileOutputStream(Kout);
		WB.write(fo);
		WB.close();

}
	}