package com.demo.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class login {

	public static void Connectdevice() {
		AppiumDriver<WebElement> driver = null;
		try {
			File app = new File("C:\\Users\\admin\\Desktop\\app-debug.apk");
			System.out.println(app.toPath());
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");// 5.0/4.4.4
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SAMSUNG-SGH-1337");// 1dd2d9a0/TA622001JQ/03758475437dfb17
			caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.astegic.mspectrum");
			caps.setCapability("app", app);
			caps.setCapability("autoLaunch", "true");

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
			
			driver.findElementByName("Username").sendKeys("pkumari+a@astegic.com");
			driver.findElementsByClassName("android.widget.EditText").get(1).sendKeys("123456");
			driver.findElementByClassName("android.widget.Button").click();
			
			driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.astegic.mspectrum:id/next']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.astegic.mspectrum:id/next']")).click();
			//driver.findElementsByClassName("android.widget.Button").get(1).click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String ram[]){
		System.out.println("started");
		Connectdevice();
		System.out.println("ended");
	}
}
