package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {

	public static void main(String[] args) {
		String Expval="Raanford Bank";
		
				//launch firefox
		WebDriver driver = new FirefoxDriver();
		
		//url
		driver.get("http://183.82.100.55/ranford2/");
		
		//maximize the window
		driver.manage().window().maximize();
		String Actval = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		System.out.println(driver.getTitle());
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Ranford application is not launched");
		}
		else
		{
			System.out.println("Ranford application is launched");
		}
		
		
		
		//enter un
		driver.findElement(By.xpath("//*[@id=\"txtuId\"]")).sendKeys("Admin");
		
		//enter pw
		driver.findElement(By.xpath("//*[@id=\"txtPword\"]")).sendKeys("M1ndq");
		
		//click on login
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		//click on branches
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		
		//click on new branch
		driver.findElement(By.xpath("//*[@id=\"BtnNewBR\"]")).click();
		
		//enter branch name
		driver.findElement(By.xpath("//*[@id=\"txtbName\"]")).sendKeys("Nandanvan");
		
		//enter adress 1
		driver.findElement(By.xpath("//*[@id=\"txtAdd1\"]")).sendKeys("681,new nandanvan laayout");
		
		//enter zipcode
		driver.findElement(By.xpath("//*[@id=\"txtZip\"]")).sendKeys("44000");
		
		//drop down select country
		Select Ctry = new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry .selectByVisibleText("INDIA");
		
		//drop down select state
		Select state = new Select(driver.findElement(By.id("lst_stateI")));
		state.selectByVisibleText("MAHARASTRA");
		
		//DROP DOWN SELECT CITY
		Select city = new Select(driver.findElement(By.id("lst_cityI")));
		city.selectByVisibleText("MUMBAI");
		
		//click on submit
		driver.findElement(By.name("btn_insert")).click();
		
		//handle Alert
		driver.switchTo().alert().accept();
		
		//click on Home button
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"btnRoles\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"txtRname\"]")).sendKeys("student");
		
		Select Rtype = new Select(driver.findElement(By.id("lstRtypeN")));
		Rtype.selectByVisibleText("E");
		
		driver.findElement(By.name("btninsert")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"BtnNew\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("mukul123");
		driver.findElement(By.xpath("//*[@id=\"txtLpwd\"]")).sendKeys("mukul@1234");
		
		Select Role = new Select(driver.findElement(By.id("lst_Roles")));
		Role.selectByVisibleText("student");
		
		Select Branch = new Select(driver.findElement(By.id("lst_Branch")));
		Branch.selectByVisibleText("Nandanvan");
		
		driver.findElement(By.name("BtnSubmit")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[6]/td/a/img")).click();
		//driver.findElement(By.xpath(""))
		
		driver.close();
	}

}
