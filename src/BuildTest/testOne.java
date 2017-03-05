package BuildTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class testOne extends allMethods{
	
	@BeforeMethod
	public static void init() {
		setup();
	}
	
	@Test
	public static void startTest() {
		driver.get("https://www.build.com/");
		addItems();
		shippingSteps();
		driver.findElement(By.xpath("//*[@id=\"creditCardNumber\"]")).sendKeys("4111111111111111");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"taxAmount\"]")).getText().equals("$0.00"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"grandtotalamount\"]")).getText().equals("$660.37"));
	}
	
	@AfterMethod
	public static void cleanUp() {
		close();
	}
}