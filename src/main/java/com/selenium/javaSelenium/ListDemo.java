package com.selenium.javaSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListDemo {

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://leafground.com/select.xhtml");
			WebElement input = driver.findElement(By.id("j_idt87:auto-complete_input"));
			input.sendKeys("selenium");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> suggestion = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#j_idt87\\:auto-complete_panel ul li")));
			for(WebElement option : suggestion) {
			    System.out.println(option.getText()); 
			    if(option.getText().trim().equalsIgnoreCase("JMeter")) {
			        option.click();
			        break;
			    }
			}
			driver.close();
		}

}
