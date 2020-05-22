package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewEmplCretnPOM 
{
	@FindBy(xpath="//*[@id=\"txtUname\"]")
	WebElement EmplName;
	
	@FindBy(xpath="//*[@id=\"txtLpwd\"]")
	WebElement LogPass;
	
	@FindBy(xpath="//*[@id=\"lst_Roles\"]")
	WebElement rol;
	
	@FindBy(xpath="//*[@id=\"lst_Branch\"]")
	WebElement branch;
	
	@FindBy(xpath="//*[@id=\"BtnSubmit\"]")
	WebElement submit;
	
	//Element methods
	public void Emplye(String En,String Lp,String Rol,String Brnch) throws InterruptedException
	{
		EmplName.sendKeys(En);
		LogPass.sendKeys(Lp);
		rol.sendKeys(Rol);
		Thread.sleep(1000);
		
		branch.sendKeys(Brnch);
		submit.click();
	}

}
