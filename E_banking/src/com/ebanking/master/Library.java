package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.support.ui.Select;

		
		
		public class Library 
		{
		       public static WebDriver driver;
		       public static String Expval,Actval;
		       public static FileInputStream Fis;
		       public static Properties Pr;
		     
		       
			
			public String OpenApp(String Url) throws IOException
			
			{
				Fis=new FileInputStream("F:\\TESTING TOOLS\\E_banking\\src\\com\\ebanking\\Properties\\Rep.properties");
				Pr=new Properties();
				Pr.load(Fis);
				
				System.setProperty("webdriver.geko.driver", "C:\\Users\\lenovo\\Desktop\\geckodriver.exe");
				 Expval="Ranford Bank";
					
				driver = new FirefoxDriver();
					
					driver.get(Url);
					
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
					
					return "Pass";
					
			}
			
			
			
			public String AdminLgn(String Un,String Pwd) throws InterruptedException
			{
				Expval="Welcome to Admin";
				Thread.sleep(3000);
				driver.findElement(By.id(Pr.getProperty("userName"))).sendKeys(Un);
				driver.findElement(By.id(Pr.getProperty("pasward"))).sendKeys(Pwd);
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
						return "Pass";
				
			}
			
			public String Branchcre(String Bn,String Add1,String Zc,String cty,String state,String city) throws InterruptedException
			{
				Expval="Sucessfully";		
				
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
				driver.findElement(By.id(Pr.getProperty("nbrbtn"))).click();
				
				
				driver.findElement(By.id(Pr.getProperty("bname"))).sendKeys(Bn);
				driver.findElement(By.id(Pr.getProperty("add1"))).sendKeys(Add1);
				driver.findElement(By.id(Pr.getProperty("zcode"))).sendKeys(Zc);
				
				//dropdown
				
				Select Ctry=new Select(driver.findElement(By.id(Pr.getProperty("cntryn"))));
				Ctry.selectByVisibleText(cty);
				
				Select Sta=new Select(driver.findElement(By.id(Pr.getProperty("staten"))));
				Sta.selectByVisibleText(state);

				Select Cty=new Select(driver.findElement(By.id(Pr.getProperty("cityn"))));
				Cty.selectByVisibleText(city);

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
				return Actval;
						

			}
			//click on roles
			
			public String Rolecre(String roln,String roltyp) throws InterruptedException
			{
				Expval = "Successfully";
				Thread.sleep(3000);
				driver.findElement(By.xpath(Pr.getProperty("rolebtn"))).click();
				driver.findElement(By.id(Pr.getProperty("nwrole"))).click();
				
				driver.findElement(By.xpath(Pr.getProperty("rolnam"))).sendKeys(roln);
				
				Select rolty=new Select(driver.findElement(By.id(Pr.getProperty("rolty"))));
				rolty.selectByVisibleText(roltyp);
				
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
				return Actval;
				
			}
			
			//click on Employe
			public String Emplye(String En,String Lp,String Rol,String Brnch) throws InterruptedException
			{
				driver.findElement(By.xpath(Pr.getProperty("empl"))).click();
				driver.findElement(By.xpath(Pr.getProperty("nemp"))).click();
				Expval = "New Employee Creation";
				Thread.sleep(3000);
				
				driver.findElement(By.id(Pr.getProperty("emlyn"))).sendKeys(En);
				driver.findElement(By.id(Pr.getProperty("lgps"))).sendKeys(Lp);
				
				Select role=new Select(driver.findElement(By.xpath(Pr.getProperty("rol"))));
				role.selectByVisibleText(Rol);
				
				Select brn=new Select(driver.findElement(By.xpath(Pr.getProperty("brn"))));
				brn.selectByVisibleText(Brnch);
				
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
				return Actval;
				
			}
			
			public void admlgt()
			{
				driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
			}
			
			public void Appc()
			{
				driver.close();
			}



						}
			
			
			

	

