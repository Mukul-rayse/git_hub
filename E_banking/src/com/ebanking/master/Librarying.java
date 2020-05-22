package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

		public class Librarying 
		{
		       WebDriver driver;
		       String Expval,Actval;
		       FileInputStream Fis;
		       Properties Pr;
		     
			@Test(priority=1)
			public void OpenApp() throws IOException
			{
				Fis=new FileInputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Properties\\Rep.properties");
				Pr=new Properties();
				Pr.load(Fis);
				
				 Expval="Ranford Bank";
					
				driver = new FirefoxDriver();
					
					driver.get("http://183.82.100.55/ranford2");
					
					//Maximise
					
					driver.manage().window().maximize();
					
				 Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
					
					//Comparision
					
					if (Expval.equalsIgnoreCase(Actval)) 
					{
					System.out.println("Ranford Application Launch Succ");	
					}
					else
					{
						System.out.println("Ranford Application Not Launch");	
					}
					
					//return "Pass";
					
			}
			@Test(priority=2)
			public void AdminLgn() throws InterruptedException
			{
				Expval="Welcome to Admin";
				Thread.sleep(3000);
				driver.findElement(By.id(Pr.getProperty("userName"))).sendKeys("Admin");
				driver.findElement(By.id(Pr.getProperty("pasward"))).sendKeys("M1ndq");
				driver.findElement(By.xpath(Pr.getProperty("login"))).click();
				
				Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
				
				//Comparision
				
						if (Expval.equalsIgnoreCase(Actval)) 
						{
						System.out.println("Admin Login Succ");	
						}
						else
						{
							System.out.println("Admin Login Failed");	
						}
				
			}
			@Test(priority=3)
			public void Branchcre() throws InterruptedException
			{
				Expval="Sucessfully";		
				
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
				driver.findElement(By.id(Pr.getProperty("nbrbtn"))).click();
				
				
				driver.findElement(By.id(Pr.getProperty("bname"))).sendKeys("corona1");
				driver.findElement(By.id(Pr.getProperty("add1"))).sendKeys("newNandanvan");
				driver.findElement(By.id(Pr.getProperty("zcode"))).sendKeys("44009");
				
				//dropdown
				
				Select Ctry=new Select(driver.findElement(By.id(Pr.getProperty("cntryn"))));
				Ctry.selectByVisibleText("INDIA");
				
				Select Sta=new Select(driver.findElement(By.id(Pr.getProperty("staten"))));
				Sta.selectByVisibleText("GOA");

				Select Cty=new Select(driver.findElement(By.id(Pr.getProperty("cityn"))));
				Cty.selectByVisibleText("GOA");

				driver.findElement(By.id(Pr.getProperty("btnsub"))).click();
				
				Thread.sleep(4000);
				
				//Alert
				
				Actval=driver.switchTo().alert().getText();
				String a1 = driver.switchTo().alert().getText();
				System.out.println(a1);
				driver.switchTo().alert().accept();
				
				
				//Comparision
				
				if (Actval.contains(Expval)) 
				{
				System.out.println("Branch Created");	
				}
				else
				{
					System.out.println("Branch Already Exist");
				}
				
				driver.findElement(By.xpath(Pr.getProperty("hmbtn"))).click();
				//return Actval;
						

			}
			//click on roles
			@Test(priority = 4)
			public void Rolecre() throws InterruptedException
			{
				Expval = "Successfully";
				Thread.sleep(3000);
				driver.findElement(By.xpath(Pr.getProperty("rolebtn"))).click();
				driver.findElement(By.id(Pr.getProperty("nwrole"))).click();
				
				driver.findElement(By.xpath(Pr.getProperty("rolnam"))).sendKeys("tapori");
				
				Select rolty=new Select(driver.findElement(By.id(Pr.getProperty("rolty"))));
				rolty.selectByVisibleText("E");
				
				driver.findElement(By.xpath(Pr.getProperty("sbtn"))).click();
				
				//handle alert
				Actval=driver.switchTo().alert().getText();
				String a2 = driver.switchTo().alert().getText();
				System.out.println(a2);
				driver.switchTo().alert().accept();
				
				//comparision
				if (Actval.contains(Expval))
				{
					System.out.println("Role created succ");
				}
				else
				{
					System.out.println("Role already exist");
					
				}
				driver.findElement(By.xpath(Pr.getProperty("hmbtn"))).click();
				//return Actval;
				
			}
			
			//click on Employe
			@Test(priority = 5)
			public void Emplye() throws InterruptedException
			{
				driver.findElement(By.xpath(Pr.getProperty("empl"))).click();
				driver.findElement(By.xpath(Pr.getProperty("nemp"))).click();
				Expval = "New Employee Creation";
				Thread.sleep(3000);
				
				driver.findElement(By.id(Pr.getProperty("emlyn"))).sendKeys("ShriRam");
				driver.findElement(By.id(Pr.getProperty("lgps"))).sendKeys("shriram");
				
				Select role=new Select(driver.findElement(By.xpath(Pr.getProperty("rol"))));
				role.selectByVisibleText("Exe");
				
				Select brn=new Select(driver.findElement(By.xpath(Pr.getProperty("brn"))));
				brn.selectByVisibleText("334");
				
				driver.findElement(By.xpath(Pr.getProperty("sbmt"))).click();
				
				//handle alert
				Actval=driver.switchTo().alert().getText();
				String a3 = driver.switchTo().alert().getText();
				System.out.println(a3);
				driver.switchTo().alert().accept();
				
				//comparision
				if (Actval.contains(Expval))
				{
					System.out.println("Employee created succ");
				}
				else
				{
					System.out.println("Employee already exist");
					
				}
				driver.findElement(By.xpath(Pr.getProperty("hmbtn"))).click();
				
				
//				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
//				driver.close();
				//return Actval;
			}
			
			
			

	}

