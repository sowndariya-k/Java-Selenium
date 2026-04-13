package com.selenium.javaSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		WebElement input = driver.findElement(By.id("alert1"));
		input.click();
		Alert SA=driver.switchTo().alert();
		String simpleAlert=SA.getText();
		System.out.println(simpleAlert);
		SA.accept();
		driver.quit();
	}

}
