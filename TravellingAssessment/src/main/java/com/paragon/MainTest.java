package com.paragon;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest extends GenericUtility {

	static {
//		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
	}

	public static WebDriver driver = new ChromeDriver();

	Pages page = new Pages(driver);
	public static String URL = "https://www.paragonsports.com/";

	@BeforeTest
	public void openBrowser() {
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@Test(priority = 1)
	public void verfyLogin() {
		String[] credentials = getRandomCredentials();
		String username = credentials[0];
		String password = credentials[1];
		waitFor(3);
		page.getProfileIcon().click();
		waitFor(2);
		page.getSignInLink().click();
		waitFor(2);
		page.getEmail().sendKeys(username);
		page.getPassword().sendKeys(password);
		waitFor(2);
		page.getSubmitButton().click();
		waitFor(2);
		Assert.assertEquals(driver.getTitle(), "Paragon Sports: NYC's Best Specialty Sports Store");
		System.out.println(driver.getTitle());

	}

	@Test(priority = 2)
	public void verifyText() {

		List<WebElement> types = page.getTypesOfCollections();
		for (int i = 0; i > types.size(); i++) {
			String type = types.get(i).getText();
			if (type.contains("MEN") || type.contains("WOMEN") || type.contains("KIDS")) {
				Assert.assertEquals(type, type.contains("MENWOMENKIDS"));
			}

		}

	}

	@Test(priority = 3)
	public void searchProductByText() {
		String searchValue = "footwear";
		waitFor(2);
		page.getSearchBox().sendKeys(searchValue);
		waitFor(2);
		page.getSearchSubmit().click();
	}

	@Test(priority = 4)
	public void addTocartAndIncreasetheQty() {
		waitFor(3);
		scrollTo(driver, page.getProduct());
		Assert.assertTrue(page.getProduct().isDisplayed());
		page.getProduct().click();
		waitFor(2);
		scrollTo(driver, page.getAddToBag());
		waitFor(2);
		Assert.assertTrue(page.getAddToBag().isDisplayed());
		page.getAddToBag().click();
		waitFor(2);

		Select select = new Select(page.getIncreaseQty());
		if (select.isMultiple()) {
			select.selectByVisibleText("2");
			waitFor(2);

		}

	}

	@AfterTest
	public void closeBrowser() {
//		driver.quit();
	}

}
