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
	static String searchBox = "//*[@id=\"search_txt\"]";
	static String searchButton = "//*[@id=\"site-search\"]/div/button";
	static String addToCart = "//*[@id=\"add-to-cart-wrap\"]/button";
	static String creditCardXpath = "//*[@id=\"creditCardNumber\"]";
	static String taxCheckXpath = "//*[@id=\"taxAmount\"]";
	static String grandTotalXpath = "//*[@id=\"grandtotalamount\"]";
	static String productQuantity = "//*[@id=\"main-product-quantity\"]/div/input";
	static String checkCart = "//*[@id=\"cartNav\"]/a";
	static String guestLogin = "//*[@id=\"guest-login\"]/button";
	static String firstName = "//*[@id=\"shippingfirstname\"]";
	static String lastName = "//*[@id=\"shippinglastname\"]";
	static String address = "//*[@id=\"shippingaddress1\"]";
	static String postal = "//*[@id=\"shippingpostalcode\"]";
	static String city = "//*[@id=\"shippingcity\"]";
	static String state = "//*[@id=\"shippingstate\"]";
	static String number = "//*[@id=\"shippingphonenumber\"]";
	static String email = "//*[@id=\"emailAddress\"]";
	
    public static void setup(){
		driver = new ChromeDriver(capabilities);
		capabilities.setCapability("marionette", true);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
    }
	
    public static void addItems() {
    	driver.findElement(By.xpath(searchBox)).sendKeys("Suede Kohler K66266U");
		driver.findElement(By.xpath(searchButton)).click();
		driver.findElement(By.xpath(addToCart)).click();
		driver.findElement(By.xpath(searchBox)).sendKeys("Cashmere Kohler K66266U");
		driver.findElement(By.xpath(searchButton)).click();
		driver.findElement(By.xpath(addToCart)).click();
		driver.findElement(By.xpath(searchBox)).sendKeys("Kohler K-5180-ST");
		driver.findElement(By.xpath(searchButton)).click();
		driver.findElement(By.xpath(productQuantity)).clear();
		driver.findElement(By.xpath(productQuantity)).sendKeys("2");
		driver.findElement(By.xpath(addToCart)).click();
    }
    
    public static void shippingSteps() {
    	driver.findElement(By.xpath(checkCart)).click();
		driver.findElement(By.xpath(guestLogin)).click();
		driver.findElement(By.xpath(firstName)).sendKeys("Varun");
		driver.findElement(By.xpath(lastName)).sendKeys("Gattu");
		driver.findElement(By.xpath(address)).sendKeys("207 Middlesex Essex TPKE");
		driver.findElement(By.xpath(postal)).sendKeys("08830");
		driver.findElement(By.xpath(city)).sendKeys("Iselin");
		WebElement stateDropdown = driver.findElement(By.xpath(state));
		Select njState = new Select(stateDropdown);
		njState.selectByVisibleText("New Jersey");
		driver.findElement(By.xpath(number)).sendKeys("5109962147");
		driver.findElement(By.xpath(email)).sendKeys("gvarun.vs41@gmail.com");
    }
    
	public static void close() {
		System.out.println("After Test called");
		driver.close();
	}
}