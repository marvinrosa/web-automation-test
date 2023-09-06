package com.webapp.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Getting the element from WebPage
	By popUpCloseUp = By.className("close-modal");
	By lnkOnDemand = By.linkText("On Demand");
	By lnkMovies = By.cssSelector("#root > div.home > div:nth-child(16) > div.header > div > a");
	By btnFilter = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[1]/div");
	By btnApply = By.cssSelector("#root > div.view-all-wrapper > div.sort-filters > div.popUpContainer.viewAllFilter > div.filter-buttons > div.filter-button.filter-apply-button.filter-button-enabled");
	By selecAnimated = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/label/span[2]");
	By lbl18plus = By.xpath("//*[@id=\"703479428\"]/a/div[2]/div/p");
	
	String selectedOption = "Animated";
	String expectedText = "18+";
	
	//Step 2 - close popUP
	public void closePopUp() {
		// TODO : Should click up on the x button 
		fluentWait(popUpCloseUp);
		driver.findElement(popUpCloseUp).click();
		System.out.println("Title CloseUp: " + driver.getTitle());
	}
	
	//Step 3 - click onOndemand
	public void OnDemandClick() {
		driver.findElement(lnkOnDemand).click();
		System.out.println("Title OnDemand: " + driver.getTitle());
	}
	
	//Step 4 - scroll down to Movies Option
	public void scrollToMovies() {
		System.out.println("ScrollToMovies");
	}
	
	//Step 5 - Movies > viewAll
	public void lookForMovies() {
		// TODO: Should be doing scroll down or click on directly on " > " or viewAll text element
		fluentWait(lnkMovies);
		driver.findElement(lnkMovies).click();
		System.out.println("Title Movies: " + driver.getTitle());
	}
	
	//Step 6 
	public void clickUpFilter() {
		// TODO: Should be clicking on filter button and select from the dropdown option as "Animated"
		fluentWait(btnFilter);
		driver.findElement(btnFilter).click();
		System.out.println("Message : "+ driver.findElement(btnFilter).getText());
		fluentWait(selecAnimated);
		driver.findElement(selecAnimated).click();
		System.out.println("Selected Option: " + driver.findElement(selecAnimated).getText());	
	}
	
	//Step 7 - apply option
	public void applyClick() {
		fluentWait(btnApply);
		driver.findElement(btnApply).click();
	}
	//Step 8
	public void verify18plusContent() {
		// TODO: Should be looking for content with 18+ content and do click to have it in the page
		fluentWait(lbl18plus);
		String currentResult = driver.findElement(lbl18plus).getText();
		System.out.println("Filter " + selectedOption +"  : "+ currentResult);
		Assert.assertTrue(currentResult.contains(expectedText));
	}
	
	//Step 9
	public void openDetailPage() {
		System.out.println("openDetailPage");
	}
	public void fluentWait(By locator) {
		// TODO: Required to do some waits 
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(500));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
