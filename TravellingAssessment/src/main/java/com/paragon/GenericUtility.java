package com.paragon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtility {

	public static void waitFor(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	public static void scrollTo(WebDriver driver, WebElement ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	private static final List<String[]> CREDENTIALS = Arrays.asList(
			new String[] { "user1@gmail.com", "password1" },
			new String[] { "user2@gmail.com", "password1" },
			new String[] { "muniraj.thirumahesh@gmail.com", "Mahesh@123" });

	public static String[] getRandomCredentials() {
		Random random = new Random();
		return CREDENTIALS.get(random.nextInt(CREDENTIALS.size()));
	}
}
