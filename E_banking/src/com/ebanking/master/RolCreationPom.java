package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RolCreationPom
{
	//Element properties
	@FindBy(xpath="//*[@id=\"txtRname\"]")
	WebElement Rname;
	
	@FindBy(xpath="//*[@id=\"lstRtypeN\"]")
	WebElement Rtype;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement Sbtn;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement logout;
	
	//Element methods
	
	public void Rolecreation(String Rn,String Rty)
	{
		Rname.sendKeys(Rn);
		
		Select Rt=new Select(Rtype);
		Rt.selectByVisibleText(Rty);
		
		Sbtn.click();
	}
	

}
