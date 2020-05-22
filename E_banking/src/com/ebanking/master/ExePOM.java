package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExePOM 
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
	
		//Pagefactory
	@Test
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
	
		
		@Test
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
		
			
		}
			
		@Test
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

}
