package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeDataraPro {

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
	
	@Test(dataProvider="Edata")
	public void Emplye(String En,String Lp,String Rol,String Brnch) throws InterruptedException 
	{
		AdminHP AHP=PageFactory.initElements(driver, AdminHP.class);
		AHP.Emp();
		
		NewEmplpagePOM NEP=PageFactory.initElements(driver, NewEmplpagePOM.class);
		NEP.NE();
		
		NewEmplCretnPOM NEC=PageFactory.initElements(driver, NewEmplCretnPOM.class);
		NEC.Emplye(En, Lp, Rol, Brnch);
		
		driver.switchTo().alert().accept();
		NEP.HM();
	}
	@DataProvider
	
	public  Object[][] Edata()
	{
		Object[][] Obj=new Object[3][4];
		
		 Obj[0][0]="Mukulabcd";
		 Obj[0][1]="Mukulabcd";
		 Obj[0][2]="Chandra";
		 Obj[0][3]="Ameerpet";
		 
		 Obj[1][0]="Mukulpqrs";
		 Obj[1][1]="Mukulpqrs";
		 Obj[1][2]="Chandra";
		 Obj[1][3]="Ameerpet";
		 
		 Obj[2][0]="Mukulxyz";
		 Obj[2][1]="Mukulxyz";
		 Obj[2][2]="Chandra";
		 Obj[2][3]="Ameerpet";
		 return Obj;
}
		
				

}
