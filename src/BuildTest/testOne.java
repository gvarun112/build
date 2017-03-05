package BuildTest;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

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
		driver.findElement(By.xpath(creditCardXpath)).sendKeys("4111111111111111");
		assertThat(driver.findElement(By.xpath(taxCheckXpath)).getText().equals("$0.00"));
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"taxAmount\"]")).getText().equals("$0.00"));
		assertThat(driver.findElement(By.xpath(grandTotalXpath)).getText().equals("$660.37"));
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"grandtotalamount\"]")).getText().equals("$660.37"));
	}
	
	@AfterMethod
	public static void cleanUp() {
		close();
	}
}