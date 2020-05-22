package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBcrtnPOM 
{
	//Element properties
	@FindBy(xpath="//*[@id=\"txtbName\"]")
	WebElement BranchName;
	
	@FindBy(xpath="//*[@id=\"txtAdd1\"]")
	WebElement Adress;
	
	@FindBy(xpath="//*[@id=\"txtZip\"]")
	WebElement Zip;
	
	@FindBy(xpath="//*[@id=\"lst_counrtyU\"]")
	WebElement Country;
	
	@FindBy(id="lst_stateI")
	WebElement State;
	
	@FindBy(id="lst_cityI")
	WebElement City;
	
	@FindBy(xpath="//*[@id=\"btn_insert\"]")
	WebElement Submit;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	//Element methods
	public void Branchcre(String Bn,String Add1,String Zc,String cty,String state,String city) throws InterruptedException
	{
		BranchName.sendKeys(Bn);
		Adress.sendKeys(Add1);
		Zip.sendKeys(Zc);
		Country.sendKeys(cty);
		Thread.sleep(1000);
		
		State.sendKeys(state);
		Thread.sleep(1000);
		
		City.sendKeys(city);
		
		Submit.click();
		
	}
	

}
