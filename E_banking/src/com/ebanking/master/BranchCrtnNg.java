package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchCrtnNg extends Base
{
	@Test(dataProvider="Bdata")
	public void Branchcre(String Bn,String Add1,String Zc,String cty,String state,String city) throws InterruptedException 
	{
		Lb.Branchcre(Bn, Add1, Zc, cty, state, city);
	}
	
	@DataProvider
	
	public  Object[][] Bdata()
	{
		Object[][] Obj=new Object[3][6];
		
		 Obj[0][0]="Mukul";
		 Obj[0][1]="belkampeth";
		 Obj[0][2]="11111";
		 Obj[0][3]="INDIA";
		 Obj[0][4]="MAHARASTRA";
		 Obj[0][5]="MUMBAI";
		 
		 Obj[1][0]="Mukulm";
		 Obj[1][1]="belkampeth";
		 Obj[1][2]="11111";
		 Obj[1][3]="INDIA";
		 Obj[1][4]="MAHARASTRA";
		 Obj[1][5]="MUMBAI";
		 
		 Obj[2][0]="Mukulab";
		 Obj[2][1]="belkampeth";
		 Obj[2][2]="11111";
		 Obj[2][3]="INDIA";
		 Obj[2][4]="MAHARASTRA";
		 Obj[2][5]="MUMBAI";
		 
		 
		 return Obj;
	}

}
