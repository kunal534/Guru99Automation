package Day7;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Guru99 {

	ChromeDriver driver;
	
	public void invokeBrowser() {
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/v4");

}

public void login(String username, String password) {

WebElement userId;

userId = driver.findElement(By.name("uid"));

userId.sendKeys(username);

driver.findElement(By.name("password")).sendKeys(password);

driver.findElement(By.name("btnLogin")).click();

}

public void addAccount(String custumerId) {
	driver.findElement(By.linkText("New Account")).click();
	System.out.println("clicked");
	WebElement iframe1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	driver.switchTo().frame(iframe1);
	System.out.println("Switched!");
	WebElement iframe2 = driver.findElement(By.id("ad_iframe"));
	driver.switchTo().frame(iframe2);
	System.out.println("Switched2");
	driver.findElement(By.id("dismiss-button")).click();
	System.out.println("clicked");
	driver.switchTo().defaultContent();
	driver.findElement(By.name("cusid")).sendKeys(custumerId);
	WebElement selDropdown = driver.findElement(By.name("selaccount"));
	Select selAccount = new Select(selDropdown);
	selAccount.selectByVisibleText("Current");
	driver.findElement(By.name("inideposit")).sendKeys("583465");
	driver.findElement(By.name("button2")).click();
}

public void closeBrowser() {

//driver.close(); //close only the current browser

driver.quit(); //close all the browser

}

}