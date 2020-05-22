package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeCreationNg extends Base
{
	@Test(dataProvider="Edata")
	public void Emplye(String En,String Lp,String Rol,String Brnch) throws InterruptedException 
	{
		Lb.Emplye(En, Lp, Rol, Brnch);
	}
	
	@DataProvider
	
	public  Object[][] Edata()
	{
		Object[][] Obj=new Object[3][4];
		
		 Obj[0][0]="Mukulabcd";
		 Obj[0][1]="Mukulabcd";
		 Obj[0][2]="Chandra";
		 Obj[0][3]="Ameerpet";
		 
		 Obj[0][0]="Mukulpqrs";
		 Obj[0][1]="Mukulpqrs";
		 Obj[0][2]="Chandra";
		 Obj[0][3]="Ameerpet";
		 
		 Obj[0][0]="Mukulxyz";
		 Obj[0][1]="Mukulxyz";
		 Obj[0][2]="Chandra";
		 Obj[0][3]="Ameerpet";
		 return Obj;
}
}