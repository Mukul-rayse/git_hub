package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class BranchDataProv 
{
	WebDriver driver;
	@BeforeTest
	public void Login()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://183.82.100.55/ranford2");
		RanfordHp RHP=PageFactory.initElements(driver, RanfordHp.class);
		RHP.login();
	}
 	
	@Test(dataProvider="Bdata")
	public void Branchcre(String Bn,String Add1,String Zc,String cty,String state,String city) throws InterruptedException 
	
		{
			AdminHP AHP=PageFactory.initElements(driver, AdminHP.class);
			AHP.Br();
			
			Newbranchpom NBP=PageFactory.initElements(driver, Newbranchpom.class);
			NBP.NB();
			
			NewBcrtnPOM NBC=PageFactory.initElements(driver, NewBcrtnPOM.class);
			NBC.Branchcre(Bn, Add1, Zc, cty, state, city);
			
			//Alert
			driver.switchTo().alert().accept();
			NBP.HM();
	}
	
	@DataProvider
	
	public  Object[][] Bdata()
	{
		Object[][] Obj=new Object[3][6];
		
		 Obj[0][0]="Mukulabcd";
		 Obj[0][1]="belkampeth";
		 Obj[0][2]="11111";
		 Obj[0][3]="INDIA";
		 Obj[0][4]="GOA";
		 Obj[0][5]="GOA";
		 
		 Obj[1][0]="Mukulpqrs";
		 Obj[1][1]="belkampeth";
		 Obj[1][2]="11111";
		 Obj[1][3]="INDIA";
		 Obj[1][4]="GOA";
		 Obj[1][5]="GOA";
		 
		 Obj[2][0]="Mukulaxyz";
		 Obj[2][1]="belkampeth";
		 Obj[2][2]="11111";
		 Obj[2][3]="INDIA";
		 Obj[2][4]="GOA";
		 Obj[2][5]="GOA";
		 
		 
		 return Obj;
	}

}
