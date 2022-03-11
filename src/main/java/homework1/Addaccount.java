package homework1;

import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Addaccount {
	WebDriver driver;

	@Before
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logIn() throws InterruptedException {
		WebElement user_name_element = driver.findElement(By.id("username"));
		WebElement user_password_element = driver.findElement(By.id("password"));
		WebElement log_in_element = driver.findElement(By.name("login"));
		
	    user_name_element.sendKeys("demo@techfios.com");
		user_password_element.sendKeys("abc123");
		log_in_element.click();
		
	    WebElement dashbord_header_element = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
		Assert.assertEquals("wrong page", "Dashboard", dashbord_header_element.getText());

	    WebElement bank_cash_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a"));
		WebElement new_account_element = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a"));
		bank_cash_element.click();
		new_account_element.click();
		
		WebElement account_header_element = driver.findElement(By.xpath("//h2[contains(text(), ' Accounts ')]"));
		Assert.assertEquals("wrong page", "Accounts", account_header_element.getText());

		WebElement account_title_element = driver.findElement(By.id("account"));
		WebElement description_element = driver.findElement(By.id("description"));
		WebElement balance_element = driver.findElement(By.id("balance"));
		WebElement account_number_element = driver.findElement(By.id("account_number"));
		WebElement contact_person_element = driver.findElement(By.id("contact_person"));
		WebElement contact_phone_element = driver.findElement(By.id("contact_phone"));
	    WebElement submit_element = driver.findElement(By.cssSelector("#page-wrapper > div.wrapper.wrapper-content.animated.fadeIn > div.row > div > div > div.ibox-content > form > button"));
		
		account_title_element.sendKeys("abc");
		description_element.sendKeys("def");
		balance_element.sendKeys("100");
		account_number_element.sendKeys("6543");
		contact_person_element.sendKeys("jhj");
		contact_phone_element.sendKeys("1234567890");
		submit_element.submit();
		
		Thread.sleep(3000);
	}

	// @After
	// public void teardown() {
	// driver.close();
}
