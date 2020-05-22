package com.ebanking.master;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	Library Lb=new Library();
	
	 @BeforeSuite
	  public void beforeSuite() throws IOException
	  {
		  Lb.OpenApp("http://183.82.100.55/ranford2");
	  }
  
	
  @AfterSuite
  public void afterClass() 
  {
	  Lb.Appc();
  }
  

  @BeforeTest
  public void beforeTest() throws InterruptedException 
  {
	  Lb.AdminLgn("Admin", "M1ndq");
  }
  
  @AfterTest
  public void AfterTest()
  {
	  Lb.admlgt();
  }

}
