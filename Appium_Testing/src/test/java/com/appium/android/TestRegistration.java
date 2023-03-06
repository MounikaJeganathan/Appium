package com.appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;

public class TestRegistration {
	
	/*There are 4 types of mobile drivers:
	 * RemoteWebDriver:
	 * It is the class comes directly from upstream selenium project.
	 * This is generic driver which initializing the driver means making req to selenium hub to start a driver session
	 * Since appium operates on client server model.
	 * Directly using remotewebdriver is not recommended.
	 * 
	 * AppiumDriver:
	 * It inherits from remotewebdriver but it add additional functions which is uselful for mob automation
	 * 
	 * Android driver:
	 * It inherits from AppiumDriver,but it add additional functions which is uselful for mob automation test through
	 * adroid device
	 * Only use when you test android devices or emulator.
	 * 
	 * IOSDriver:
	 * It inherits from AppiumDriver,but it add additional functions which is uselful for mob automation test through
	 * ios device
	 * Only use when you test android devices or emulator
	 * */
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("udid", "R5CR10G4EDT");
		capabilities.setCapability("deviceName", "Samsung");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver(url,capabilities);
		
		System.out.println("Done");
	
		
		WebElement contiune = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		
		contiune.click();
		
		Thread.sleep(2000);
		WebElement okay = driver.findElement(By.className("android.widget.Button"));
		Actions action = new Actions(driver);
		action.clickAndHold(okay);
		action.release(okay).build().perform();
		
		WebElement registraton = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		
		registraton.click();
		
		Thread.sleep(2000);
		
		WebElement userName = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
		userName.sendKeys("Milaasi");
		
		WebElement email = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
		email.sendKeys("mila@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
		pwd.sendKeys("Milaa");
		
		WebElement name = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
		name.clear();
		name.sendKeys("Milaa");
		
		driver.navigate().back();
		//driver.hideKeyboard();
		
		WebElement lang = driver.findElement(By.id("android:id/text1"));
		lang.click();
		
		WebElement java = driver.findElement(By.xpath("//*[@text='Java']"));
		java.click();
		
		
		WebElement acceptCheckBox = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
		acceptCheckBox.click();
		
		WebElement register = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
		register.click();
		
		System.out.println("Success");
		
		
		
		
	}

}
