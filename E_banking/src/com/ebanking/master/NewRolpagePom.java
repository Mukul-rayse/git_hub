package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRolpagePom
{
	//Element properties
	@FindBy(xpath="//*[@id=\"btnRoles\"]")
	WebElement NewRol;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	
	//Element methods
	
	public void NR()
	{
		NewRol.click();
	}
	
	public void Hm()
	{
		Home.click();
	}

	

}
