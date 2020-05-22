package com.ebanking.master;

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Excelwithpom 
	{

		WebDriver driver;
		
	    @BeforeTest
	
	    public void login()
		  {
			  driver=new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.get("http://183.82.100.55/ranford2");
			  
			  //Pagefactory
			  
			  RanfordHp RHP=PageFactory.initElements(driver,RanfordHp.class);
			  RHP.login();
			  
		  }
	  @Test
	    public void Rolec() throws IOException
	    {
	  	
	    	

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
	    			

			  AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
			  
			  AHP.Rol();
			  
			  
			  //New role
			  					
					AdminHP AHP1=PageFactory.initElements(driver, AdminHP.class);
					AHP1.Rol();
					
					NewRolpagePom NRP=PageFactory.initElements(driver, NewRolpagePom.class);
					NRP.NR();
					
					RolCreationPom RCP=PageFactory.initElements(driver, RolCreationPom.class);
					RCP.Rolecreation(Rname, Rtyp);
					
					//Alert
					driver.switchTo().alert().accept();
					
					NRP.Hm();
				}
			  
	    }
	    			
}

		
	