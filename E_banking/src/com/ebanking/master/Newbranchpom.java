package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newbranchpom
{
	//Element properties
	@FindBy(xpath="//*[@id=\"BtnNewBR\"]")
	WebElement Newbranch;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home2;
	
	//Element methods
	public void NB()
	{
		Newbranch.click();
	}
	
	public void HM()
	{
		Home2.click();
	}
}
