package com.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		
		// mouni mob
		/*capabilities.setCapability("udid", "2A151FDH200G9E");
		capabilities.setCapability("deviceName", "Pixel 7");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");*/
		
		// parthip mob
		
		capabilities.setCapability("udid", "R5CR10G4EDT");
		capabilities.setCapability("deviceName", "Samsung");
		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver(url,capabilities);
		
		System.out.println("Done");
		
		WebElement nine = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09"));
		WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
		WebElement five = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
		WebElement equalTo = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
		
		nine.click();
		plus.click();
		five.click();
		equalTo.click();
		
		System.out.println("Clicked");
		
		
	}

}
