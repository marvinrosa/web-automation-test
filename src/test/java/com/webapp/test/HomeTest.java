package com.webapp.test;

import org.testng.annotations.Test;

import com.webapp.page.HomePage;
import com.webapp.utils.BaseTest;

public class HomeTest extends BaseTest {
	
	HomePage home;
	@Test
	public void stepsToPerform() {
		home = new HomePage(driver);
		home.closePopUp();
		home.OnDemandClick();
		home.lookForMovies();
		home.clickUpFilter();
		home.verify18plusContent();
	}
}
