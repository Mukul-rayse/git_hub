package com.ebanking.master;

import org.testng.annotations.Test;

public class Branchcre extends Base
{
	@Test
	public void bcre() throws InterruptedException
	{
		Lb.Branchcre("mindqtesting", "Srnagar", "12345", "INDIA", "GOA", "GOA");
	}
}
