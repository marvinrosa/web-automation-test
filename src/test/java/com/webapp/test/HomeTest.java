package com.webapp.test;

import org.testng.annotations.Test;

import com.webapp.page.HomePage;
import com.webapp.utils.BaseTest;

public class HomeTest extends BaseTest {
	
	HomePage home;
	@Test
	public void stepsToPerform() {
		//Step 1
		home = new HomePage(driver);
		//Step 2
		home.closePopUp();
		//Step 3
		home.OnDemandClick();
		//Step4
		
		//Step 5
		home.lookForMovies();
		//Step 6
		home.clickUpFilter();
		//Step 7 - apply option
		home.applyClick();
		//Step 8 - loop over the load data
		home.verify18plusContent();
		//Step 9 - Open details page
		home.openDetailPage();
	}
}
