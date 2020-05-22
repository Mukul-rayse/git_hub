package mvn_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Practice {

	@Test
	public void Openapp(){
		
		WebDriver driver =new FirefoxDriver();
		driver.get("http://183.82.100.55/ranford2/");
		driver.manage().window().maximize();
				
	}
}
