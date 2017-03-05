package BuildTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class allMethods {
	static DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	static File file = new File("Chrome_Driver/chromedriver.exe");
	static WebDriver driver;
	
    public static void setup(){
		driver = new ChromeDriver(capabilities);
		capabilities.setCapability("marionette", true);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
    }
	
    public static void addItems() {
    	driver.findElement(By.xpath("//*[@id=\"search_txt\"]")).sendKeys("Suede Kohler K66266U");
		driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-wrap\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"search_txt\"]")).sendKeys("Cashmere Kohler K66266U");
		driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-wrap\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"search_txt\"]")).sendKeys("Kohler K-5180-ST");
		driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"main-product-quantity\"]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"main-product-quantity\"]/div/input")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-wrap\"]/button")).click();
    }
    
    public static void shippingSteps() {
    	driver.findElement(By.xpath("//*[@id=\"cartNav\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"guest-login\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"shippingfirstname\"]")).sendKeys("Varun");
		driver.findElement(By.xpath("//*[@id=\"shippinglastname\"]")).sendKeys("Gattu");
		driver.findElement(By.xpath("//*[@id=\"shippingaddress1\"]")).sendKeys("207 Middlesex Essex TPKE");
		driver.findElement(By.xpath("//*[@id=\"shippingpostalcode\"]")).sendKeys("08830");
		driver.findElement(By.xpath("//*[@id=\"shippingcity\"]")).sendKeys("Iselin");
		driver.findElement(By.xpath("//*[@id=\"shippingcity\"]")).sendKeys("Iselin");
		WebElement stateDropdown = driver.findElement(By.xpath("//*[@id=\"shippingstate\"]"));
		Select njState = new Select(stateDropdown);
		njState.selectByVisibleText("New Jersey");
		driver.findElement(By.xpath("//*[@id=\"shippingphonenumber\"]")).sendKeys("5109962147");
		driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("gvarun.vs41@gmail.com");
    }
    
	public static void close() {
		System.out.println("After Test called");
		driver.close();
	}
}