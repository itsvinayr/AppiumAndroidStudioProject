package com.example.testapplication;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ExampleUnitTest {

    public final static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    public final static String BASE_URL = "http://google.com";
    public static AppiumDriver driver;

    @Test
    public void addition_isCorrect() throws MalformedURLException, InterruptedException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

        driver = new AndroidDriver(new URL(APPIUM_URL), capabilities);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("Hello Appium !!!");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/button[2]")).click();
        Thread.sleep(3000L);
        driver.quit();
    }
}