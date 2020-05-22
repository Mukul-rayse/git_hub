package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleDataraPro
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
	
	@Test(dataProvider="Rdata")
	public void Rol(String Rn,String Rty)
	{
		
		AdminHP AHP=PageFactory.initElements(driver, AdminHP.class);
		AHP.Rol();
		
		NewRolpagePom NRP=PageFactory.initElements(driver, NewRolpagePom.class);
		NRP.NR();
		
		RolCreationPom RCP=PageFactory.initElements(driver, RolCreationPom.class);
		RCP.Rolecreation(Rn, Rty);
		
		//Alert
		driver.switchTo().alert().accept();
		
		NRP.Hm();
		
		
	}
	
@DataProvider
	
	public  Object[][] Rdata()
	{
		Object[][] Obj=new Object[3][2];
		
		 Obj[0][0]="Tallerabcd";
		 Obj[0][1]="E";
		 
		 Obj[1][0]="Managerabcd";
		 Obj[1][1]="E";
		 
		 Obj[2][0]="Clerkabcd";
		 Obj[2][1]="E";
		 
		 return Obj;
	}

}
