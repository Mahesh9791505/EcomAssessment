package com.paragon;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	WebDriver driver;

	public Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'vtex-login-2-x-profileIcon')])[1]")
	private WebElement profileIcon;
	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	private WebElement signInLink;
	@FindBy(xpath = "//input[@placeholder='e-mail']")
	private WebElement email;
	@FindBy(xpath = "//input[@placeholder='password']")
	private WebElement password;
	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement submitButton;
	@FindBy(xpath = "//ul[@class='vtex-menu-2-x-menuContainer vtex-menu-2-x-menuContainer--mega-menu list flex pl0 mv0 flex-row']//li//div//a//div")
	private List<WebElement> typesOfCollections;
	@FindBy(xpath = "(//input[@placeholder='What are you looking for?'])[1]")
	private WebElement searchBox;
	@FindBy(xpath = "(//button[@aria-label='Search Products'])[1]")
	private WebElement searchSubmit;
	@FindBy(xpath = "//article//span[text()='mens bondi 8']//ancestor::a")
	private WebElement product;
	@FindBy(xpath = "(//span[text()='ADD TO BAG']//ancestor::div[@class='vtex-flex-layout-0-x-flexRow vtex-flex-layout-0-x-flexRow--qty-add-to-cart']//button)[1]")
	private WebElement addToBag;
	@FindBy(xpath = "//div[@id='quantity-dropdown-52859']//following::select")
	private WebElement increaseQty;

	public WebElement getSearchBox() {

		return searchBox;
	}

	public WebElement getSearchSubmit() {
		return searchSubmit;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getAddToBag() {
		return addToBag;
	}

	public WebElement getIncreaseQty() {
		return increaseQty;
	}

	public List<WebElement> getTypesOfCollections() {
		return typesOfCollections;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
