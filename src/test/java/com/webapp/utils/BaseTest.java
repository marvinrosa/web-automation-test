package com.webapp.utils;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
  

  WebDriver driver;
	
  @BeforeMethod
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://telustvplus.com/#/");
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
