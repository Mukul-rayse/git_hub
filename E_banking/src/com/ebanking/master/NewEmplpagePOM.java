package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewEmplpagePOM 
{
	@FindBy(xpath="//*[@id=\"BtnNew\"]")
	WebElement NewEmploye;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement home3;
	
	
	//Element method
	public void NE()
	{
		NewEmploye.click();
	}
	
	public void HM()
	{
		home3.click();
	}
	

}
