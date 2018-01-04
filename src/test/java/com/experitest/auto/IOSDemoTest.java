package com.experitest.auto;

import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		//dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		//dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("testName", "iOS Jenkins");
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
		dc.setCapability("instrumentApp", true);
		driver = new IOSDriver<>(new URL(url + "/wd/hub"), dc);
		
		driver.setLogLevel(Level.INFO);
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@accessibilityLabel='Username']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@accessibilityLabel='Login']")).click();
		driver.findElement(By.xpath("//*[@accessibilityLabel='Make Payment']")).click();
		
		driver.findElement(By.xpath("//*[@accessibilityLabel='Phone']")).sendKeys("5552424");
		driver.findElement(By.xpath("//*[@accessibilityLabel='Name']")).sendKeys("Eyal");
		driver.findElement(By.xpath("//*[@accessibilityLabel='Amount']")).sendKeys("20");
		driver.findElement(By.xpath("//*[@accessibilityLabel='Country']")).sendKeys("Israel");
		
		driver.findElement(By.xpath("//*[@accessibilityLabel='Send Payment']")).click();
		driver.findElement(By.xpath("//*[@accessibilityLabel='Yes']")).click();
		
		driver.findElement(By.xpath("//*[@accessibilityLabel='Logout']")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
