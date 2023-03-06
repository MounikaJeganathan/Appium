package com.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ToastMessageText {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
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
		
		WebElement toast = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		toast.click();
		
		WebElement toastMessage = driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
		String message = toastMessage.getText();
		
		System.out.println(message);
	

	}

}
